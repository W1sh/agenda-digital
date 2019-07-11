package com.everis.academia.java.agenda.digital.web.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@FacesConverter(value = "tipoServicoConverter")
public class TipoServicoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		if (value.getClass() == String.class && value.trim().isEmpty()) {
			return null;
		}

		Short codigo = Short.valueOf(value);
		return new TipoServico(codigo);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return null;
		}
		if (value.getClass() == String.class && ((String) value).trim().isEmpty()) {
			return null;
		}

		TipoServico servico = (TipoServico) value;

		return servico.getCodigo().toString();
	}

}
