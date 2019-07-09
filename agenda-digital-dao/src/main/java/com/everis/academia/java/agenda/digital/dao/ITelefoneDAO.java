package com.everis.academia.java.agenda.digital.dao;

import com.everis.academia.java.agenda.digital.entidades.Telefone;

public interface ITelefoneDAO extends IGenericDAO<Telefone> {

	Boolean delete(Short codigo);
}
