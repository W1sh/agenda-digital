package com.everis.academia.java.agenda.digital.web.jsf.beans.tipoServico;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@Component(value = "tipoServicoUpdate")
@ManagedBean(name = "tipoServicoUpdate")
@RequestScope
public class TipoServicoUpdateBean {

	@Autowired
	private ITipoServicoBusiness business;
	private TipoServico servico = new TipoServico();

	public TipoServico getServico() {
		return servico;
	}

	public void setServico(TipoServico servico) {
		this.servico = servico;
	}

	public String update() {
		try {
			business.update(servico);
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo servico atualizada com sucesso!", ""));
			return "tipoServicos";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("descricao", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a atualizar o tipo servico!", e.getLocalizedMessage()));
			return null;
		}
	}

	public String call(TipoServico servico) {
		setServico(servico);
		return "update";
	}

	public void clean() {
		servico = new TipoServico();
	}

}
