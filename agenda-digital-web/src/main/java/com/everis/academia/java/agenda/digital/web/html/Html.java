package com.everis.academia.java.agenda.digital.web.html;

public class Html extends HtmlComponent {

	public Html() {
		super("html");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (!(component instanceof Body)) {
			throw new Exception("Tipo não suportado");
		}
		if (!getComponents().isEmpty()) {
			throw new Exception("Html so pode conter uma tag <Body>");
		}
		return getComponents().add(component);
	}

}
