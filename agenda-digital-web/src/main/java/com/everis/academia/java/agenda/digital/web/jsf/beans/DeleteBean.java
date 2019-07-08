package com.everis.academia.java.agenda.digital.web.jsf.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

@ManagedBean(name = "cidadeDelete")
public class DeleteBean {

	private ICidadeBusiness business = new CidadeBusiness();

	public void delete(Integer codigo) {
		try {
			business.delete(codigo);
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade apagada com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("dataTable", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a apagar a cidade!", e.getLocalizedMessage()));
		}
	}
}
