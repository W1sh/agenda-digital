package com.everis.academia.java.agenda.digital.web.jsf.beans.cidade;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@ManagedBean(name = "cidadeCreate")
public class CidadeCreateBean {

	private ICidadeBusiness business = new CidadeBusiness();
	private Cidade cidade = new Cidade();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String create() {
		try {
			business.create(cidade);
			FacesContext.getCurrentInstance().addMessage("dataTable",
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cidade criada com sucesso!", ""));
			return "cidades";
		} catch (BusinessException e) {
			FacesContext.getCurrentInstance().addMessage("nome", new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Ocorreu um erro a criar a cidade!", e.getLocalizedMessage()));
			return null;
		}
	}

	public String call() {
		return "create";
	}

	public void clean() {
		cidade = new Cidade();
	}
}
