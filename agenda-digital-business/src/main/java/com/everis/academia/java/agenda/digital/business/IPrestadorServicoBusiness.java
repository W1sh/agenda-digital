package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;

public interface IPrestadorServicoBusiness {

	void create(PrestadorServico prestador) throws BusinessException;

	Collection<PrestadorServico> read();

	void update(PrestadorServico prestador) throws BusinessException;

	Boolean delete(Integer codigo) throws BusinessException;
}
