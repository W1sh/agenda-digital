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
import com.everis.academia.java.agenda.digital.web.html.Table;
import com.everis.academia.java.agenda.digital.web.html.Td;
import com.everis.academia.java.agenda.digital.web.html.Text;
import com.everis.academia.java.agenda.digital.web.html.Tr;

@WebServlet(name = "Cidades", urlPatterns = "/cidades")
public class CidadesView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printwriter = resp.getWriter();

		if (req.getQueryString() != null) {
			Integer codigo = Integer.valueOf(req.getParameter("codigo"));
			String nome = req.getParameter("nome");
			Cidade novaCidade = new Cidade(codigo, nome);
			CidadeDAO.create(novaCidade);
		}

		try {
			Html html = new Html();
			Body body = new Body();

			Table table = new Table();
			for (Cidade cidade : CidadeDAO.read()) {
				Tr tr1 = new Tr();
				Td td1 = new Td();
				Text text1 = new Text("Codigo: ");

				Td td2 = new Td();
				Text text2 = new Text(String.valueOf(cidade.getCodigo()));

				Tr tr2 = new Tr();
				Td td3 = new Td();
				Text text3 = new Text("Name: ");

				Td td4 = new Td();
				Text text4 = new Text(String.valueOf(cidade.getNome()));

				Tr tr3 = new Tr();
				Td td5 = new Td();
				A a1 = new A();
				Text text5 = new Text("Delete");

				Tr tr4 = new Tr();
				Td td6 = new Td();

				A a2 = new A();
				Text text6 = new Text("Update");

				td1.insertComponent(text1);
				td2.insertComponent(text2);
				tr1.insertComponent(td1);
				tr1.insertComponent(td2);
				table.insertComponent(tr1);
				table.setAdditionalProperties(" border=\"1\"");

				td3.insertComponent(text3);
				td4.insertComponent(text4);
				tr2.insertComponent(td3);
				tr2.insertComponent(td4);
				table.insertComponent(tr2);

				a1.insertComponent(text5);
				a1.setAdditionalProperties(" href=\"./cc?operation=delete&codigo=" + cidade.getCodigo() + "&nome="
						+ cidade.getNome() + "\"");
				td5.insertComponent(a1);
				tr3.insertComponent(td5);

				a2.insertComponent(text6);
				a2.setAdditionalProperties(
						" href=\"./updateCidade?codigo=" + cidade.getCodigo() + "&nome=" + cidade.getNome() + "\"");
				td6.insertComponent(a2);
				tr3.insertComponent(td6);
				table.insertComponent(tr3);
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
