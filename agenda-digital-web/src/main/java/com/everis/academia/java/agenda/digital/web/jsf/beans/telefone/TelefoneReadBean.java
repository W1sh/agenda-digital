package com.everis.academia.java.agenda.digital.web.jsf.beans.telefone;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.business.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.business.impl.TelefoneBusiness;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

@ManagedBean(name = "telefoneRead")
public class TelefoneReadBean {

	private ITelefoneBusiness business = new TelefoneBusiness();
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
