package com.everis.academia.java.agenda.digital.web.html;

import java.util.ArrayList;
import java.util.List;

public abstract class HtmlComponent {

	private List<HtmlComponent> components;
	private String tag;
	private String additionalProperties = "";

	public HtmlComponent(String tag) {
		super();
		this.components = new ArrayList<HtmlComponent>();
		this.tag = tag;
	}

	public abstract boolean insertComponent(HtmlComponent component) throws Exception;

	public String getHtml() {
		String html = "<" + tag + additionalProperties + ">";
		for (HtmlComponent component : components) {
			html += component.getHtml();
		}
		System.out.println(html);
		return html + "</" + tag + ">";
	}

	public List<HtmlComponent> getComponents() {
		return components;
	}

	public void setAdditionalProperties(String additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public String getTag() {
		return tag;
	}

	public String getAdditionalProperties() {
		return additionalProperties;
	}

}
