package com.everis.academia.java.agenda.digital.web.html;

public class Text extends HtmlComponent {

	private String value;

	public Text(String value) {
		super("label");
		this.value = value;
	}

	@Override
	public boolean insertComponent(HtmlComponent component) throws Exception {
		return false;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getHtml() {
		String html = "<" + getTag() + getAdditionalProperties() + ">";
		html += value;
		return html + "</" + getTag() + ">";
	}

}
