package com.everis.academia.java.agenda.digital.web.jsf.beans.telefone;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

@Component(value = "telefoneRead")
@ManagedBean(name = "telefoneRead")
@RequestScope
public class TelefoneReadBean {

	@Autowired
	private IPrestadorServicoBusiness business;

	public Collection<Telefone> getTelefones() {
		return business.readTelefones();
	}
}
