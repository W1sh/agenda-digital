package com.everis.academia.java.agenda.digital.web.servlets.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@WebServlet(name = "CidadeUpdateController", urlPatterns = "/update/cidade/ctrl")
public class CidadeUpdateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ICidadeBusiness cidadeBusiness = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer codigoUpdate = Integer.valueOf(req.getParameter("codigo"));
			String nomeUpdate = req.getParameter("nome");
			Cidade novaCidadeUpdate = new Cidade(codigoUpdate, nomeUpdate);
			cidadeBusiness.update(novaCidadeUpdate);
		} catch (BusinessException e) {
			throw new ServletException(e);
		}
		resp.sendRedirect("/agenda-digital-web/cidades");
	}

}
