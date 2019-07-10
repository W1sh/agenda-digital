package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.impl.TipoServicoBusiness;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;
import com.everis.academia.java.agenda.digital.enums.TipoLogradouro;

@ManagedBean(name = "prestadorCreate")
public class PrestadorCreateBean {

	private ITipoServicoBusiness business = new TipoServicoBusiness();
	private PrestadorServico prestador = new PrestadorServico();
	private DualListModel<TipoServico> servicosCredenciados;

	@PostConstruct
	public void init() {
		List<TipoServico> source = (List<TipoServico>) business.read();
		List<TipoServico> target = new ArrayList<TipoServico>();

		servicosCredenciados = new DualListModel<TipoServico>(source, target);
	}

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}

	public TipoLogradouro[] getLogradouros() {
		return TipoLogradouro.values();
	}

}
