package com.everis.academia.java.agenda.digital.dao;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeDAO extends IGenericDAO<Cidade, Integer> {

	Boolean contains(Cidade cidade);

	Boolean isAssigned(Integer codigo);
}
