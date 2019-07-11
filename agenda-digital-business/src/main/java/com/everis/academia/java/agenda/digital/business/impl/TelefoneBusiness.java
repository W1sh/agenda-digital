package com.everis.academia.java.agenda.digital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.academia.java.agenda.digital.business.ITelefoneBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.dao.ITelefoneDAO;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

@Service
public class TelefoneBusiness implements ITelefoneBusiness {

	@Autowired
	private ITelefoneDAO dao;
	private static final int NUMERO_LENGTH = 9;

	@Override
	public void create(Telefone telefone) throws BusinessException {
		if (telefone.getNumero() == null) {
			throw new BusinessException("Numero de telefone não pode ser nulo!");
		}
		if (telefone.getNumero().toString().length() < NUMERO_LENGTH
				|| telefone.getNumero().toString().length() > NUMERO_LENGTH) {
			throw new BusinessException("Numero de telefone tem que ter 9 digitos!");
		}
		dao.create(telefone);
	}

	@Override
	public Collection<Telefone> read() {
		return dao.read();
	}

	@Override
	public void update(Telefone telefone) throws BusinessException {
		if (telefone.getNumero() == null) {
			throw new BusinessException("Numero de telefone não pode ser nulo!");
		}
		if (telefone.getNumero().toString().length() < NUMERO_LENGTH
				|| telefone.getNumero().toString().length() > NUMERO_LENGTH) {
			throw new BusinessException("Numero de telefone tem que ter 9 digitos!");
		}
		dao.update(telefone);
	}

	@Override
	public Boolean delete(Integer codigo) throws BusinessException {
		if (codigo == null || codigo <= 0) {
			throw new BusinessException("Codigo não pode ser inferior a zero ou nulo!");
		}
		return dao.delete(codigo);
	}

}
