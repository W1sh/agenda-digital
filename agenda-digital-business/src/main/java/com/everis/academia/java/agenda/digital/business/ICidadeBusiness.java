package com.everis.academia.java.agenda.digital.business;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public interface ICidadeBusiness extends IBusiness<Cidade, Integer> {

	Boolean isAssigned(Integer codigo);
}
