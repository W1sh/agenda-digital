package com.everis.academia.java.agenda.digital.web.jsf.beans.tipoServico;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.TipoServicoBusiness;

@ManagedBean(name = "tipoServicoDelete")
public class TipoServicoDeleteBean {

	private ITipoServicoBusiness business = new TipoServicoBusiness();

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
