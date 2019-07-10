package com.everis.academia.java.agenda.digital.web.jsf.beans.telefone;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

@Component(value = "telefoneRead")
@ManagedBean(name = "telefoneRead")
@RequestScope
public class TelefoneReadBean {

	@Autowired
	private ITelefoneBusiness business;
	private Collection<Telefone> telefones;

	@PostConstruct
	public void init() {
		telefones = business.read();
	}

	public Collection<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
	}

}
