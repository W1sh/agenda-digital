package com.everis.academia.java.agenda.digital.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Form", urlPatterns = "/form")
public class Form extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printwriter = resp.getWriter();
		printwriter.println("<html>");
		printwriter.println("<body>");
		printwriter.println("<form action=\"controller\">");
		printwriter.println("<table border=\"1\">");
		printwriter.println("<tr><td colspan=\"2\">Formulário</td></tr>");
		printwriter.println("<tr><td>Nome: </td><td><input type=\"text\" name=\"nome\"/></td></tr>");
		printwriter.println("<tr><td>Idade: </td><td><input type=\"text\" name=\"idade\"/></td></tr>");
		printwriter.println("<tr><td>Salario: </td><td><input type=\"text\" name=\"salario\"/></td></tr>");
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
