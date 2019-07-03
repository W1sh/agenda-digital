package com.everis.academia.java.agenda.digital.business;

import java.util.List;

import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeBusiness {

	void create(Cidade cidade) throws BusinessException;

	List<Cidade> read();

	void update(Cidade cidade) throws BusinessException;

	Boolean delete(Integer codigo) throws BusinessException;

}
