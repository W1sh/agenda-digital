package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

public interface ITelefoneBusiness {

	void create(Telefone telefone) throws BusinessException;

	Collection<Telefone> read();

	void update(Telefone telefone) throws BusinessException;

	Boolean delete(Integer codigo) throws BusinessException;

}
