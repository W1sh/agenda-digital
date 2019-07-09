package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.enums.TipoLogradouro;

@ManagedBean(name = "prestadorCreate")
public class PrestadorCreateBean {

	private PrestadorServico prestador = new PrestadorServico();

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}

	public TipoLogradouro[] getLogradouros() {
		return TipoLogradouro.values();
	}

}
