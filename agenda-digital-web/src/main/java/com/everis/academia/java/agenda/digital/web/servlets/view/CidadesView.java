package com.everis.academia.java.agenda.digital.web.servlets.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.everis.academia.java.agenda.digital.dao.CidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;
import com.everis.academia.java.agenda.digital.web.html.A;
import com.everis.academia.java.agenda.digital.web.html.Body;
import com.everis.academia.java.agenda.digital.web.html.Html;
import com.everis.academia.java.agenda.digital.web.html.HtmlComponent;
import com.everis.academia.java.agenda.digital.web.html.Table;

@WebServlet(name = "Cidades", urlPatterns = "/cidades")
public class CidadesView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printwriter = resp.getWriter();

		try {
			Html html = new Html();
			Body body = new Body();

			A aCreate = new A("Create");
			aCreate.setAdditionalProperties(" href=\"./createCidade\"");
			body.insertComponent(aCreate, true);

			A aSort = new A("Sort");
			aSort.setAdditionalProperties(" href=\"./cc?operation=sort\"");
			body.insertComponent(aSort, true);

			Table table = new Table();
			for (Cidade cidade : CidadeDAO.read()) {

				String[] columns1 = { "Codigo: ", String.valueOf(cidade.getCodigo()) };
				table.addRow(columns1);

				String[] columns2 = { "Name: ", String.valueOf(cidade.getNome()) };
				table.addRow(columns2);

				A aDelete = new A("Delete");
				aDelete.setAdditionalProperties(" href=\"./cc?operation=delete&codigo=" + cidade.getCodigo() + "&nome="
						+ cidade.getNome() + "\"");
				A aUpdate = new A("Update");
				aUpdate.setAdditionalProperties(
						" href=\"./updateCidade?codigo=" + cidade.getCodigo() + "&nome=" + cidade.getNome() + "\"");
				HtmlComponent[] components = { aDelete, aUpdate };
				table.addRow(components);
				table.setAdditionalProperties(" border=\"1\"");
			}
			html.insertComponent(body);
			body.insertComponent(table);

			System.out.println(html.getHtml());
			printwriter.write(html.getHtml());
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * printwriter.println("<html>");
		 * printwriter.println("<body bgcolor=\"#FF0000\">");
		 * printwriter.println("<table border=\"1\">"); printwriter.
		 * println("<tr><td>Parametros Recebidos</td><td><a href=\"./cc?operation=sort\">Sort</a></tr>"
		 * ); for (Cidade cidade : CidadeDAO.read()) {
		 * printwriter.println("<tr><td>Codigo: </td><td>" + cidade.getCodigo() +
		 * "</td></tr>"); printwriter.println("<tr><td>Nome: </td><td>" +
		 * cidade.getNome() + "</td></tr>");
		 * printwriter.println("<tr><td><a href=\"./cc?operation=delete&codigo=" +
		 * cidade.getCodigo() + "&nome=" + cidade.getNome() + "\">Delete</a></td>");
		 * printwriter.println("<td><a href=\"./updateCidade?codigo=" +
		 * cidade.getCodigo() + "&nome=" + cidade.getNome() +
		 * "\">Update</a></td></tr>"); } printwriter.println("</table>");
		 * printwriter.println("</body>"); printwriter.println("</html>");
		 */
	}
}
