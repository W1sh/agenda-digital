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

		printwriter.println("<html>");
		printwriter.println("<body bgcolor=\"#FF0000\">");
		printwriter.println("<table border=\"1\">");
		printwriter.println("<tr><td colspan=\"2\">Parametros Recebidos</td></tr>");
		for (Cidade cidade : CidadeDAO.read()) {
			printwriter.println("<tr><td>Codigo: </td><td>" + cidade.getCodigo() + "</td></tr>");
			printwriter.println("<tr><td>Nome: </td><td>" + cidade.getNome() + "</td></tr>");
			printwriter.println("<tr><td><a href=\"./cc?operation=delete&codigo=" + cidade.getCodigo() + "&nome="
					+ cidade.getNome() + "\">Delete</a></td>");
			printwriter.println("<td><a href=\"./updateCidade?codigo=" + cidade.getCodigo() + "&nome="
					+ cidade.getNome() + "\">Update</a></td></tr>");
		}
		printwriter.println("</table>");
		printwriter.println("</body>");
		printwriter.println("</html>");
	}
}
