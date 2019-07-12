package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

public interface IPrestadorServicoDAO extends IGenericDAO<PrestadorServico, Integer> {

	Collection<Telefone> readTelefones();

	Boolean numeroTelefoneExists(Long numero);

	Boolean emailExists(String email);
}
