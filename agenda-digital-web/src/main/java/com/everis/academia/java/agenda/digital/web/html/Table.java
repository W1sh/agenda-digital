package com.everis.academia.java.agenda.digital.web.html;

public class Table extends HtmlComponent {

	public Table() {
		super("table");
	}

	public Table(String additionalProperties) {
		this();
		setAdditionalProperties(additionalProperties);
	}

	public void addRow(String[] columns) throws Exception {
		Tr tr = new Tr();
		for (String column : columns) {
			Text text = new Text(column);
			Td td = new Td();
			td.insertComponent(text);
			tr.insertComponent(td);
		}
		insertComponent(tr);
	}

	public void addRow(HtmlComponent[] components) throws Exception {
		Tr tr = new Tr();
		for (HtmlComponent component : components) {
			Td td = new Td();
			td.insertComponent(component);
			tr.insertComponent(td);
		}
		insertComponent(tr);
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		if (!(component instanceof Tr)) {
			throw new Exception("Tipo não suportado");
		}
		return getComponents().add(component);
	}

}
