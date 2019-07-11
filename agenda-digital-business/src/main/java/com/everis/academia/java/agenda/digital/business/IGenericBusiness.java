package com.everis.academia.java.agenda.digital.business;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;

public interface IGenericBusiness<T, K> {

	void create(T entidade) throws BusinessException;

	Collection<T> read();

	void update(T entidade) throws BusinessException;

	void delete(K id) throws BusinessException;

}
