package com.everis.academia.java.agenda.digital.web.jsf.beans.tipoServico;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.impl.TipoServicoBusiness;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@ManagedBean(name = "tipoServicoRead")
public class TipoServicoReadBean {

	private ITipoServicoBusiness business = new TipoServicoBusiness();
	private Collection<TipoServico> servicos;

	@PostConstruct
	public void init() {
		this.servicos = business.read();
	}

	public Collection<TipoServico> getServicos() {
		return servicos;
	}

	public void setServicos(Collection<TipoServico> servicos) {
		this.servicos = servicos;
	}

}
