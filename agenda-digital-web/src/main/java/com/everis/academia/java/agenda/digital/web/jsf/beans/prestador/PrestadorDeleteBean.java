package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;

@Component(value = "prestadorDelete")
@ManagedBean(name = "prestadorDelete")
@RequestScope
public class PrestadorDeleteBean {

	@Autowired
	private IPrestadorServicoBusiness business;

	public void delete(Integer codigo) {
		try {
			System.out.println("ALLO");
			business.delete(codigo);
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Prestador apagado com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("dataTable", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a apagar o prestador!", e.getLocalizedMessage()));
		}
	}
}
