package com.everis.academia.java.agenda.digital.web.jsf.beans.tipoServico;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;

@Component(value = "tipoServicoDelete")
@ManagedBean(name = "tipoServicoDelete")
@RequestScope
public class TipoServicoDeleteBean {

	@Autowired
	private ITipoServicoBusiness business;

	public void delete(Short codigo) {
		try {
			business.delete(codigo);
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Tipo servico apagado com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("dataTable", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a apagar o tipo servico!", e.getLocalizedMessage()));
		}
	}
}
