package com.everis.academia.java.agenda.digital.web.html;

public class Body extends HtmlComponent {

	public Body() {
		super("body");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (component instanceof Html) {
			throw new Exception("Tipo não suportado");
		}
		return getComponents().add(component);
	}

	public boolean insertComponent(HtmlComponent component, boolean withBreak) throws Exception {
		getComponents().add(component);
		return getComponents().add(new Br());
	}
}
