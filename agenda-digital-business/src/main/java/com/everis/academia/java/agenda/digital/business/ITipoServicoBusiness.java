package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

public interface ITipoServicoBusiness {

	void create(TipoServico tipoServico) throws BusinessException;

	Collection<TipoServico> read();

	void update(TipoServico tipoServico) throws BusinessException;

	Boolean delete(Short codigo) throws BusinessException;

}
