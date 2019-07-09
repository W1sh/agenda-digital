package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

public interface IGenericDAO<T> {

	void create(T entidade);

	Collection<T> read();

	void update(T entidade);

	Boolean delete(T entidade);
}
