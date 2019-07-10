package com.everis.academia.java.agenda.digital.web.jsf.beans.cidade;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@Component(value = "cidadeRead")
@ManagedBean(name = "cidadeRead")
@RequestScope
public class CidadeReadBean {

	@Autowired
	private ICidadeBusiness business;
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
