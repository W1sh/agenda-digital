package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;
import com.everis.academia.java.agenda.digital.enums.TipoLogradouro;

@Component(value = "prestadorUpdate")
@ManagedBean(name = "prestadorUpdate")
@RequestScope
public class PrestadorUpdateBean {

	@Autowired
	private ITipoServicoBusiness businessTipoServico;
	@Autowired
	private IPrestadorServicoBusiness businessPrestador;

	private PrestadorServico prestador = new PrestadorServico();
	private Set<Telefone> telefones;
	private Telefone telefone = new Telefone();
	private DualListModel<TipoServico> servicosCredenciados;
	private TipoServico servico = new TipoServico();

	public String create() {
		try {
			prestador.getServicosCredenciados().addAll(servicosCredenciados.getTarget());
			businessPrestador.create(prestador);
			prestador = new PrestadorServico();
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Prestador atualizado com sucesso!", ""));
			return "prestadores";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("prestadorPanel", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro a atualizar o prestador!", e.getLocalizedMessage()));
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
			FacesContext.getCurrentInstance().addMessage("tipoServicoMsgs", new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Ocorreu um erro a criar o tipo servico!", e.getLocalizedMessage()));
		}
	}

	public void createTelefone() {
		telefones.forEach(t -> {
			if (t.getNumero().equals(telefone.getNumero())) {
				FacesContext.getCurrentInstance().addMessage("telefonesDataTable",
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone com esse numero j� existe!", ""));
				return;
			}
		});
		telefone.setPrestadorServico(prestador);
		telefones.add(telefone);
		FacesContext.getCurrentInstance().addMessage("telefonesDataTable",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone atualizado com sucesso!", ""));
		telefone = new Telefone();
	}

	public void updateTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void deleteTelefone(Long numero) {
		telefones.remove(new Telefone(numero));
		FacesContext.getCurrentInstance().addMessage("telefonesDataTable",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Telefone apagado com sucesso!", ""));
	}

	public String call(PrestadorServico prestadorServico) {
		prestador = prestadorServico;
		List<TipoServico> source = new ArrayList<TipoServico>(businessTipoServico.read());
		source.removeIf(servico -> prestadorServico.getServicosCredenciados().contains(servico));
		List<TipoServico> target = new ArrayList<TipoServico>(prestador.getServicosCredenciados());

		servicosCredenciados = new DualListModel<TipoServico>(source, target);
		telefones = prestador.getTelefones();
		return "update";
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

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public TipoLogradouro[] getLogradouros() {
		return TipoLogradouro.values();
	}

}
