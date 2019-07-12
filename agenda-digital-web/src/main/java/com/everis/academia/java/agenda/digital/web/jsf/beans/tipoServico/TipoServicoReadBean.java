package com.everis.academia.java.agenda.digital.web.jsf.beans.tipoServico;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@Component(value = "tipoServicoRead")
@ManagedBean(name = "tipoServicoRead")
@RequestScope
public class TipoServicoReadBean {

	@Autowired
	private ITipoServicoBusiness business;

	public Collection<TipoServico> getServicos() {
		return business.read();
	}

	public String call() {
		return "tipoServicos";
	}
}
