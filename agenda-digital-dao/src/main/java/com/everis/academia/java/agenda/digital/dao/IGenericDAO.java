package com.everis.academia.java.agenda.digital.dao;

import java.util.Collection;

public interface IGenericDAO<T, K> {

	void create(T entidade);

	Collection<T> read();

	void update(T entidade);

	void delete(K codigo);
}
