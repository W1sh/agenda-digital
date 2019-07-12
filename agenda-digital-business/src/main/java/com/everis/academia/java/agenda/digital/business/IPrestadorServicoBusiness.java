package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

public interface IPrestadorServicoBusiness extends IBusiness<PrestadorServico, Integer> {

	Collection<Telefone> readTelefones();

	Boolean numeroTelefoneExists(Long numero);
}
