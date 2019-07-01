package com.everis.academia.java.agenda.digital.web.servlets.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.dao.CidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@WebServlet(name = "CidadesController", urlPatterns = "/cc")
public class CidadesController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getQueryString() != null) {

			switch (req.getParameter("operation")) {
			case "create":
				Integer codigoCreate = Integer.valueOf(req.getParameter("codigo"));
				String nomeCreate = req.getParameter("nome");
				Cidade novaCidadeCreate = new Cidade(codigoCreate, nomeCreate);
				CidadeDAO.create(novaCidadeCreate);
				break;
			case "update":
				Integer codigoUpdate = Integer.valueOf(req.getParameter("codigo"));
				String nomeUpdate = req.getParameter("nome");
				Cidade novaCidadeUpdate = new Cidade(codigoUpdate, nomeUpdate);
				Integer oldCodigo = Integer.valueOf(req.getParameter("oldCodigo"));
				String oldNome = req.getParameter("oldNome");
				Cidade oldCidade = new Cidade(oldCodigo, oldNome);
				CidadeDAO.update(oldCidade, novaCidadeUpdate);
				break;
			case "delete":
				Integer codigo = Integer.valueOf(req.getParameter("codigo"));
				String nome = req.getParameter("nome");
				Cidade novaCidade = new Cidade(codigo, nome);
				CidadeDAO.delete(novaCidade);
				break;
			case "sort":
				CidadeDAO.sort();
			default:
				break;
			}
			resp.sendRedirect("cidades");
		}
	}
}
