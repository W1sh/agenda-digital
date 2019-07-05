package com.everis.academia.java.agenda.digital.web.jsf.beans;

import javax.faces.bean.ManagedBean;

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

	public String update() {
		try {
			business.update(cidade);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "cidades";
	}

	public String call(Integer codigo, String nome) {
		cidade.setCodigo(codigo);
		cidade.setNome(nome);
		return "update";
	}

	public void clean() {
		cidade = new Cidade();
	}
}
