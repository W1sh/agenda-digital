package com.everis.academia.java.agenda.digital.web.html;

public class A extends HtmlComponent {

	public A(String value) throws Exception {
		super("a");
		Text text = new Text(value);
		insertComponent(text);
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (!(component instanceof Text)) {
			throw new Exception("Tipo n�o suportado");
		}
		return getComponents().add(component);
	}

}
