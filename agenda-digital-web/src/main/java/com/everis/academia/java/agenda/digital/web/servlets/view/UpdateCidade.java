package com.everis.academia.java.agenda.digital.web.servlets.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UpdateCidade", urlPatterns = "/updateCidade")
public class UpdateCidade extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printwriter = resp.getWriter();

		printwriter.println("<html>");
		printwriter.println("<body>");
		printwriter.println("<form action=\"cc\">");
		printwriter.println("<table border=\"1\">");
		printwriter.println("<tr><td colspan=\"2\">Formulário</td></tr>");
		if (req.getQueryString() != null) {
			Integer codigo = Integer.valueOf(req.getParameter("codigo"));
			String nome = req.getParameter("nome");
			printwriter.println("<input type=\"hidden\" name=\"operation\" value=\"update\">");
			printwriter.println("<tr><td>Nome: </td><td><input type=\"text\" name=\"codigo\" value=\"" + codigo
					+ "\" readonly/></td></tr>");
			printwriter.println(
					"<tr><td>Nome: </td><td><input type=\"text\" name=\"nome\" value=\"" + nome + "\"/></td></tr>");
			// printwriter.println("<input type=\"hidden\" name=\"oldNome\" value=\"" + nome
			// + "\">");
		} else {
			// ERROR, NAO PODE DAR UPDATE A NADA
			printwriter.println("<input type=\"hidden\" name=\"operation\" value=\"create\">");
			printwriter.println("<tr><td>Nome: </td><td><input type=\"text\" name=\"nome\"/></td></tr>");
		}
		printwriter.println("<tr><td colspan=\"2\" align=\"center\">");
		printwriter.println("<input type=\"submit\" value=\"Enviar\">");
		printwriter.println("<input type=\"reset\" value=\"Limpar\">");
		printwriter.println("</td></tr>");
		printwriter.println("</table>");
		printwriter.println("</form>");
		printwriter.println("</body>");
		printwriter.println("</html>");
	}
}
