package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.everis.academia.java.agenda.digital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;
import com.everis.academia.java.agenda.digital.enums.TipoLogradouro;

@Component(value = "prestadorCreate")
@ManagedBean(name = "prestadorCreate")
@ViewScoped
public class PrestadorCreateBean {

	@Autowired
	private ITipoServicoBusiness businessTipoServico;
	@Autowired
	private IPrestadorServicoBusiness businessPrestador;
	@Autowired
	private ITelefoneBusiness businessTelefone;

	private PrestadorServico prestador = new PrestadorServico();
	private Collection<Telefone> telefones;
	private Telefone telefone = new Telefone();
	private DualListModel<TipoServico> servicosCredenciados;
	private TipoServico servico = new TipoServico();

	@PostConstruct
	public void init() {
		List<TipoServico> source = new ArrayList<TipoServico>(businessTipoServico.read());
		List<TipoServico> target = new ArrayList<TipoServico>();

		servicosCredenciados = new DualListModel<TipoServico>(source, target);
		telefones = businessTelefone.read();
	}

	public String create() {
		try {
			prestador.getServicosCredenciados().addAll(servicosCredenciados.getTarget());
			System.out.println(prestador);
			businessPrestador.create(prestador);
			prestador = new PrestadorServico();
			FacesContext.getCurrentInstance().addMessage("prestadorPanel",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Prestador criado com sucesso!", ""));
			return null;
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("prestadorPanel", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a criar o prestador!", e.getLocalizedMessage()));
			return null;
		}
	}

	public void createServico() {
		try {
			businessTipoServico.create(servico);
			prestador.getServicosCredenciados().add(servico);
			updateDualList(new ArrayList<TipoServico>(businessTipoServico.read()), new ArrayList<TipoServico>());
			servico = new TipoServico();
			FacesContext.getCurrentInstance().addMessage("tipoServicoMsgs",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo servico criado com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("tipoServicoMsgs", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a criar o tipo servico!", e.getLocalizedMessage()));
		}
	}

	public void createTelefone() {
		try {
			if (telefone.getCodigo() == null) {
				businessTelefone.create(telefone);
				FacesContext.getCurrentInstance().addMessage("telefonesDataTable",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone criado com sucesso!", ""));
			} else {
				businessTelefone.update(telefone);
				FacesContext.getCurrentInstance().addMessage("telefonesDataTable",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone atualizado com sucesso!", ""));
			}
			telefone = new Telefone();
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("telefonesDataTable", new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Ocorreu um erro a criar o telefone!", e.getLocalizedMessage()));
		}
	}

	public void updateTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void deleteTelefone(Integer codigo) {
		try {
			businessTelefone.delete(codigo);
			FacesContext.getCurrentInstance().addMessage("telefonesDataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone apagado com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("telefonesDataTable", new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Ocorreu um erro a apagar o telefone!", e.getLocalizedMessage()));
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

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Collection<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Collection<Telefone> telefones) {
		this.telefones = telefones;
	}

	public TipoLogradouro[] getLogradouros() {
		return TipoLogradouro.values();
	}

}
