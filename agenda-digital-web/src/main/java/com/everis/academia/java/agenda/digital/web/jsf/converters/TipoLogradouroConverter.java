package com.everis.academia.java.agenda.digital.web.jsf.converters;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import com.everis.academia.java.agenda.digital.enums.TipoLogradouro;

@FacesConverter(value = "tipoLogradouroConverter")
public class TipoLogradouroConverter extends EnumConverter {

	public TipoLogradouroConverter() {
		super(TipoLogradouro.class);
	}

}
