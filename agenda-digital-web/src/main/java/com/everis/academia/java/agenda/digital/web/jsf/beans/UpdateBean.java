package com.everis.academia.java.agenda.digital.web.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@ManagedBean(name = "updateBean")
public class UpdateBean {

	private ICidadeBusiness business = new CidadeBusiness();
	private Cidade cidade = new Cidade();

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String update() throws ServletException {
		try {
			business.update(cidade);
		} catch (BusinessException e) {
			throw new ServletException(e);
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
