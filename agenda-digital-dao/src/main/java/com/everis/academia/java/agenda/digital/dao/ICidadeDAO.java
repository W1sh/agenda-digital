package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeDAO {

	void create(Cidade cidade);

	Collection<Cidade> read();

	void update(Cidade cidade);

	Boolean delete(Integer codigo);

	Boolean contains(String nome);
}
