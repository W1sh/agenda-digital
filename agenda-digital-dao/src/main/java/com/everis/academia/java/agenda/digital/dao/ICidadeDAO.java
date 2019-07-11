package com.everis.academia.java.agenda.digital.dao;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeDAO extends IGenericDAO<Cidade> {

	Boolean delete(Integer codigo);

	Boolean contains(Cidade cidade);
}
