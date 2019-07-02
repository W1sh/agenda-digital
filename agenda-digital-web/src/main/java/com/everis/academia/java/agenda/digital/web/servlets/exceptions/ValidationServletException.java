package com.everis.academia.java.agenda.digital.web.servlets.exceptions;

import javax.servlet.ServletException;

public class ValidationServletException extends ServletException {

	private static final long serialVersionUID = 1L;

	public ValidationServletException() {
		super();
	}

	public ValidationServletException(String message) {
		super(message);
	}
}
