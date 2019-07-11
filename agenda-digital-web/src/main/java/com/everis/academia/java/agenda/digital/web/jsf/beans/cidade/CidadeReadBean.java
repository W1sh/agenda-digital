package com.everis.academia.java.agenda.digital.web.jsf.beans.cidade;

import java.util.Collection;

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

	public Collection<Cidade> getCidades() {
		return business.read();
	}
}
