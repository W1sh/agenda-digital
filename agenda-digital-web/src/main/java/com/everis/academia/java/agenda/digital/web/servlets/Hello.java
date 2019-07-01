package com.everis.academia.java.agenda.digital.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Hello", urlPatterns = "/hello")
public class Hello extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printwriter = resp.getWriter();
		printwriter.println("<html>");
		printwriter.println("<body>");
		printwriter.println("Hello Academia Java");
		printwriter.println("</body>");
		printwriter.println("</html>");
	}
}
