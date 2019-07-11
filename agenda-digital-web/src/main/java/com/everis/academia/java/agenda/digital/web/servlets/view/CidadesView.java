package com.everis.academia.java.agenda.digital.web.servlets.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.IGenericBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;
import com.everis.academia.java.agenda.digital.web.html.A;
import com.everis.academia.java.agenda.digital.web.html.Body;
import com.everis.academia.java.agenda.digital.web.html.Html;
import com.everis.academia.java.agenda.digital.web.html.HtmlComponent;
import com.everis.academia.java.agenda.digital.web.html.Table;

@WebServlet(name = "Cidades", urlPatterns = "/cidades")
public class CidadesView extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IGenericBusiness<Cidade, Integer> cidadeBusiness = new CidadeBusiness();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printwriter = resp.getWriter();

		try {
			Html html = new Html();
			Body body = new Body();
			A aCreate = new A("Create", " href=\"./create/cidade\"");
			body.insertComponent(aCreate, true);
			A aSort = new A("Sort", " href=\"./cc?operation=sort\"");
			body.insertComponent(aSort, true);
			A aSortByName = new A("Sort by name", " href=\"./cc?operation=sortByName\"");
			body.insertComponent(aSortByName, true);
			Table table = new Table(" border=\"1\"");
			String[] columns1 = { "Codigo: ", "Name: " };
			table.addRow(columns1);
			for (Cidade cidade : cidadeBusiness.read()) {
				A aDelete = new A("Delete", " href=\"./delete/cidade/ctrl?codigo=" + cidade.getCodigo() + "\"");
				A aUpdate = new A("Update", " href=\"./update/cidade?codigo=" + cidade.getCodigo() + "\"");
				String[] columns2 = { String.valueOf(cidade.getCodigo()), String.valueOf(cidade.getNome()) };
				HtmlComponent[] components = { aDelete, aUpdate };
				table.addRow(columns2, components);
			}
			html.insertComponent(body);
			body.insertComponent(table);
			printwriter.write(html.getHtml());
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
