package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;
import com.everis.academia.java.agenda.digital.enums.TipoLogradouro;

@Component(value = "prestadorCreate")
@ManagedBean(name = "prestadorCreate")
@RequestScope
public class PrestadorCreateBean {

	@Autowired
	private ITipoServicoBusiness business;
	private PrestadorServico prestador = new PrestadorServico();
	private DualListModel<TipoServico> servicosCredenciados;
	private TipoServico servico = new TipoServico();

	@PostConstruct
	public void init() {
		System.out.println("init");
		List<TipoServico> source = new ArrayList<TipoServico>(business.read());
		List<TipoServico> target = new ArrayList<TipoServico>();

		servicosCredenciados = new DualListModel<TipoServico>(source, target);
	}

	public void createServico() {
		try {
			business.create(servico);
			prestador.getServicosCredenciados().add(servico);
			updateDualList(new ArrayList<TipoServico>(business.read()),
					new ArrayList<TipoServico>(prestador.getServicosCredenciados()));
			FacesContext.getCurrentInstance().addMessage("tipoServicoMsgs",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo servico criado com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("tipoServicoMsgs", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a criar o tipo servico!", e.getLocalizedMessage()));
		}
	}

	public void updateDualList(List<TipoServico> source, List<TipoServico> target) {
		servicosCredenciados = new DualListModel<TipoServico>(source, target);
	}

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}

	public DualListModel<TipoServico> getServicosCredenciados() {
		return servicosCredenciados;
	}

	public void setServicosCredenciados(DualListModel<TipoServico> servicosCredenciados) {
		this.servicosCredenciados = servicosCredenciados;
	}

	public TipoServico getServico() {
		return servico;
	}

	public void setServico(TipoServico servico) {
		this.servico = servico;
	}

	public TipoLogradouro[] getLogradouros() {
		return TipoLogradouro.values();
	}

}
