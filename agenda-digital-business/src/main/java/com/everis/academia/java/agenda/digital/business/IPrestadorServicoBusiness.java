package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.entidades.Cidade;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

public interface IPrestadorServicoBusiness extends IBusiness<PrestadorServico, Integer> {

	Collection<Telefone> readTelefones();

	Boolean numeroTelefoneExists(Long numero);

	Boolean emailExists(String email);

	Boolean isCidadeAssigned(Cidade cidade);

	Boolean isTipoServicoAssigned(TipoServico tipoServico);
}
