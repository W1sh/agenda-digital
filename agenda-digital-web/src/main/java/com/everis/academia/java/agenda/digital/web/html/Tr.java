package com.everis.academia.java.agenda.digital.web.html;

public class Tr extends HtmlComponent {

	public Tr() {
		super("tr");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		/*
		 * if (component instanceof Tr || component instanceof Body || component
		 * instanceof Html) { throw new Exception("Tipo não suportado"); }
		 */
		return getComponents().add(component);
	}

}
