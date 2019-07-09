package com.everis.academia.java.agenda.digital.web.jsf.beans.telefone;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.entidades.Telefone;

@ManagedBean(name = "telefoneCreate")
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
