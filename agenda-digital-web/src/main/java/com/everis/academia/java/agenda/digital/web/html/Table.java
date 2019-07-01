package com.everis.academia.java.agenda.digital.web.html;

public class Table extends HtmlComponent {

	public Table() {
		super("table");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (!(component instanceof Tr)) {
			throw new Exception("Tipo não suportado");
		}
		return getComponents().add(component);
	}

}
