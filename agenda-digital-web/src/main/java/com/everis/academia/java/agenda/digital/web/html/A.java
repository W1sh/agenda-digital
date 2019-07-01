package com.everis.academia.java.agenda.digital.web.html;

public class A extends HtmlComponent {

	public A() {
		super("a");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (!(component instanceof Text)) {
			throw new Exception("Tipo não suportado");
		}
		return getComponents().add(component);
	}

}
