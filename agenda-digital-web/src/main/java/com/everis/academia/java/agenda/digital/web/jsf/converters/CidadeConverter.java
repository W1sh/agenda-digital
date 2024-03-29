package com.everis.academia.java.agenda.digital.web.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

@FacesConverter(value = "cidadeConverter")
public class CidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		if (value.getClass() == String.class && value.trim().isEmpty()) {
			return null;
		}
		if (value.contains("Escolha uma")) {
			return null;
		}

		Integer codigo = Integer.valueOf(value);
		return new Cidade(codigo);

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		if (value.getClass() == String.class && ((String) value).trim().isEmpty()) {
			return null;
		}

		Cidade cidade = (Cidade) value;

		return cidade.getCodigo().toString();
	}

}
