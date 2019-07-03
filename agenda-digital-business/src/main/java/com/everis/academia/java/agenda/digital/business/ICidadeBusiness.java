package com.everis.academia.java.agenda.digital.business;

import java.util.List;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeBusiness {

	Boolean create(Cidade cidade);

	List<Cidade> read();

	Boolean update(Cidade cidade);

	Boolean delete(Integer codigo);

}
