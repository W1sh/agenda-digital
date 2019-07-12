package com.everis.academia.java.agenda.digital.dao;

import com.everis.academia.java.agenda.digital.entidades.TipoServico;

public interface ITipoServicoDAO extends IGenericDAO<TipoServico, Short> {

	Boolean isAssigned(Short codigo);
}
