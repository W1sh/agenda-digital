package com.everis.academia.java.agenda.digital.dao;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeDAO extends IGenericDAO<Cidade> {

	public Boolean delete(Integer codigo);

	Boolean contains(String nome);
}
