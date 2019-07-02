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
	private int codigo = 1;
	private boolean sorted = false;
	private boolean sortedByName = false;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getQueryString() != null) {

			switch (req.getParameter("operation")) {
			case "create":
				// Recupera
				String nomeCreate = req.getParameter("nome");

				// Valida
				validaNome(nomeCreate);

				// Cria
				Cidade novaCidadeCreate = new Cidade(codigo++, nomeCreate);
				CidadeDAO.create(novaCidadeCreate);
				break;
			case "update":
				// Recupera
				Integer codigoUpdate = Integer.valueOf(req.getParameter("codigo"));
				String nomeUpdate = req.getParameter("nome");

				// Valida
				validaNome(nomeUpdate);

				// Cria
				Cidade novaCidadeUpdate = new Cidade(codigoUpdate, nomeUpdate);
				CidadeDAO.update(novaCidadeUpdate);
				break;
			case "delete":
				// Recupera
				Integer codigoDelete = Integer.valueOf(req.getParameter("codigo"));

				// Valida
				validaCodigo(codigoDelete);

				// Cria
				boolean deleteSuccess = CidadeDAO.delete(codigoDelete);
				if (!deleteSuccess) {
					throw new ServletException("Não foi possivel apagar a cidade com codigo: " + codigoDelete);
				}
				break;
			case "sort":
				CidadeDAO.sort(sorted);
				sorted = !sorted;
			case "sortByName":
				CidadeDAO.sortByName(sortedByName);
				sortedByName = !sortedByName;
			default:
				break;
			}
			resp.sendRedirect("cidades");
		}
	}

	private boolean validaCodigo(Integer codigo) throws ServletException {
		if (codigo == null || codigo <= 0) {
			throw new ServletException("Codigo não pode ser inferior a zero ou nulo!");
		}
		return true;
	}

	private boolean validaNome(String nome) throws ServletException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new ServletException("Nome da cidade não pode ser vazio nem nulo!");
		}
		if (CidadeDAO.contains(nome) != null) {
			throw new ServletException("Esta cidade já existe!");
		}
		return true;
	}
}
