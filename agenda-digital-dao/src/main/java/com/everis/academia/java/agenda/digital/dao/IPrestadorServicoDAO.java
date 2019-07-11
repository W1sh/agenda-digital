package com.everis.academia.java.agenda.digital.dao;

import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;

public interface IPrestadorServicoDAO extends IGenericDAO<PrestadorServico> {

	Boolean delete(Integer codigo);
}
