package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entidades.TipoServico;

public interface ITipoServicoDAO {

	void create(TipoServico tipoServico);

	Collection<TipoServico> read();

	void update(TipoServico tipoServico);

	Boolean delete(Integer codigo);

}
