package com.everis.academia.java.agenda.digital.web.html;

public class Td extends HtmlComponent {

	public Td() {
		super("td");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		/*
		 * if (!(component instanceof Text) || !(component instanceof A)) { throw new
		 * Exception("Tipo não suportado"); }
		 */
		return getComponents().add(component);
	}

}
