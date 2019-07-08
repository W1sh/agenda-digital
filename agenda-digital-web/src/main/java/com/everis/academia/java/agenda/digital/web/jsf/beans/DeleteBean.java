package com.everis.academia.java.agenda.digital.web.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.servlet.ServletException;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

@ManagedBean(name = "cidadeDelete")
public class DeleteBean {

	private ICidadeBusiness business = new CidadeBusiness();

	public void delete(Integer codigo) throws ServletException {
		try {
			business.delete(codigo);
		} catch (BusinessException e) {
			throw new ServletException(e);
		}
	}
}
