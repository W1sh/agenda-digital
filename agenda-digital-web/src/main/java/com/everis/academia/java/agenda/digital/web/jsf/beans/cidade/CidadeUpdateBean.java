package com.everis.academia.java.agenda.digital.web.jsf.beans.cidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@Component(value = "cidadeUpdate")
@ManagedBean(name = "cidadeUpdate")
@RequestScope
public class CidadeUpdateBean {

	@Autowired
	private ICidadeBusiness business;
	private Cidade cidade = new Cidade();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String update() {
		try {
			business.update(cidade);
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade atualizada com sucesso!", ""));
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("nome", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a atualizar a cidade!", e.getLocalizedMessage()));
			return null;
		}
		return "cidades";
	}

	public String call(Cidade cidade) {
		setCidade(cidade);
		return "update";
	}

	public void clean() {
		cidade = new Cidade();
	}
}
