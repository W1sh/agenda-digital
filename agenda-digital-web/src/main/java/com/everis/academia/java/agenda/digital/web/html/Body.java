package com.everis.academia.java.agenda.digital.web.html;

public class Body extends HtmlComponent {

	public Body() {
		super("body");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (component instanceof Html) {
			throw new Exception("Tipo n�o suportado");
		}
		return getComponents().add(component);
	}

}
