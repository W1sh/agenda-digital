package com.everis.academia.java.agenda.digital.web.servlets.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO;

@WebServlet(name = "CidadesController", urlPatterns = "/cc")
public class CidadesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private boolean sorted = false;
	private boolean sortedByName = false;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getQueryString() != null) {
			switch (req.getParameter("operation")) {
			case "sort":
				CidadeDAO.sort(sorted);
				sorted = !sorted;
				break;
			case "sortByName":
				CidadeDAO.sortByName(sortedByName);
				sortedByName = !sortedByName;
				break;
			default:
				break;
			}
			resp.sendRedirect("jsp/cidade/cidades");
		}
	}
}
