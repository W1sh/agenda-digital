package com.everis.academia.java.agenda.digital.web.jsf.beans.cidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;

@Component(value = "cidadeDelete")
@ManagedBean(name = "cidadeDelete")
@RequestScope
public class CidadeDeleteBean {

	@Autowired
	private ICidadeBusiness business;

	public void delete(Integer codigo) {
		try {
			business.delete(codigo);
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade apagada com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("dataTable", new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Ocorreu um erro a apagar a cidade!", e.getLocalizedMessage()));
		}
	}
}
