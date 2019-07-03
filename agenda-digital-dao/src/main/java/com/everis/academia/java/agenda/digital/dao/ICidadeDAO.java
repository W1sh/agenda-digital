package com.everis.academia.java.agenda.digital.dao;

import java.util.List;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeDAO {

	Boolean create(Cidade cidade);

	List<Cidade> read();

	Boolean update(Cidade cidade);

	Boolean delete(Integer codigo);

}
