package com.everis.academia.java.agenda.digital.web.servlets.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.IGenericBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@WebServlet(name = "CidadeCreateController", urlPatterns = "/create/cidade/ctrl")
public class CidadeCreateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IGenericBusiness<Cidade, Integer> cidadeBusiness = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String nomeCreate = req.getParameter("nome");
			Cidade novaCidadeCreate = new Cidade();
			novaCidadeCreate.setNome(nomeCreate);

			cidadeBusiness.create(novaCidadeCreate);
			resp.sendRedirect("/agenda-digital-web/jsp/cidade/cidades.jsp");
		} catch (BusinessException e) {
			throw new ServletException(e);
		}
	}
}
