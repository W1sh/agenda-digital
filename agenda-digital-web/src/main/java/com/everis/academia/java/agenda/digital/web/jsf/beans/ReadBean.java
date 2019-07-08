package com.everis.academia.java.agenda.digital.web.jsf.beans;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@ManagedBean(name = "readBean")
public class ReadBean {

	private ICidadeBusiness business = new CidadeBusiness();
	private Collection<Cidade> cidades;

	@PostConstruct
	public void init() {
		this.cidades = business.read();
	}

	public Collection<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}
}
