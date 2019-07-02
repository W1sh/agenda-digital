package com.everis.academia.java.agenda.digital.web.html;

public class A extends HtmlComponent {

	public A(String value) throws Exception {
		super("a");
		Text text = new Text(value);
		insertComponent(text);
	}

	public A(String value, String additionalProperties) throws Exception {
		this(value);
		setAdditionalProperties(additionalProperties);
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (!(component instanceof Text)) {
			throw new Exception("Tipo não suportado");
		}
		return getComponents().add(component);
	}

}
