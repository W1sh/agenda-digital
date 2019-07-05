package com.everis.academia.java.agenda.digital.web.jsf.beans;

import javax.faces.bean.ManagedBean;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;

@ManagedBean(name = "deleteBean")
public class DeleteBean {

	private ICidadeBusiness business = new CidadeBusiness();

	public void delete(Integer codigo) {
		try {
			business.delete(codigo);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}
