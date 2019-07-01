package com.everis.academia.java.agenda.digital.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Integer idade = Integer.valueOf(req.getParameter("idade"));
		Double salario = Double.valueOf(req.getParameter("salario"));

		PrintWriter printwriter = resp.getWriter();
		printwriter.println("<html>");
		printwriter.println("<body bgcolor=\"#FF0000\">");
		printwriter.println("<table border=\"1\">");
		printwriter.println("<tr><td colspan=\"2\">Parametros Recebidos</td></tr>");
		printwriter.println("<tr><td>Nome: </td><td>" + nome + "</td></tr>");
		printwriter.println("<tr><td>Idade: </td><td>" + idade + "</td></tr>");
		printwriter.println("<tr><td>Salario: </td><td>" + salario + "</td></tr>");
		printwriter.println("</table>");
		printwriter.println("</body>");
		printwriter.println("</html>");
	}
}
