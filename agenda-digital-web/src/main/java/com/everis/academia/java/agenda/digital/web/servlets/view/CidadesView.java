package com.everis.academia.java.agenda.digital.web.servlets.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
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
	ICidadeBusiness cidadeBusiness = new CidadeBusiness();

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
			for (Cidade cidade : cidadeBusiness.read()) {
				String[] columns1 = { "Codigo: ", String.valueOf(cidade.getCodigo()) };
				table.addRow(columns1);
				String[] columns2 = { "Name: ", String.valueOf(cidade.getNome()) };
				table.addRow(columns2);
				A aDelete = new A("Delete", " href=\"./delete/cidade/ctrl?codigo=" + cidade.getCodigo() + "\"");
				A aUpdate = new A("Update", " href=\"./update/cidade?codigo=" + cidade.getCodigo() + "\"");
				HtmlComponent[] components = { aDelete, aUpdate };
				table.addRow(components);
			}
			html.insertComponent(body);
			body.insertComponent(table);
			printwriter.write(html.getHtml());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
