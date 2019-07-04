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

@WebServlet(name = "CidadeDeleteController", urlPatterns = "/delete/cidade/ctrl")
public class CidadeDeleteController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ICidadeBusiness cidadeBusiness = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Integer codigoDelete = Integer.valueOf(req.getParameter("codigo"));
			cidadeBusiness.delete(codigoDelete);
			resp.sendRedirect("/agenda-digital-web/cidades");
		} catch (BusinessException e) {
			throw new ServletException(e);
		}
	}
}
