package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;

public interface IBusiness<T, K> {

	void create(T entidade) throws BusinessException;

	Collection<T> read();

	void update(T entidade) throws BusinessException;

	void delete(K codigo) throws BusinessException;
}
