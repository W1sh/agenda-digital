package com.everis.academia.java.agenda.digital.web.jsf.beans.telefone;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.entidades.Telefone;

@Component(value = "telefoneCreate")
@ManagedBean(name = "telefoneCreate")
@RequestScope
public class TelefoneCreateBean {

	private Telefone telefone = new Telefone();

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void create() {

	}
}
