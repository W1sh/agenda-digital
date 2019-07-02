package com.everis.academia.java.agenda.digital.web.html;

public class Br extends HtmlComponent {

	public Br() {
		super("br");
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		return false;
	}

	@Override
	public String getHtml() {
		return "<" + getTag() + ">";
	}
}
