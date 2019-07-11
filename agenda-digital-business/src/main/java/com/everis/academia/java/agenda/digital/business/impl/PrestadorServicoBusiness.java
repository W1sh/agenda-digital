package com.everis.academia.java.agenda.digital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.academia.java.agenda.digital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;

@Service
public class PrestadorServicoBusiness implements IPrestadorServicoBusiness {

	@Autowired
	private IPrestadorServicoDAO dao;

	@Override
	public void create(PrestadorServico prestador) throws BusinessException {
		dao.create(prestador);
	}

	@Override
	public Collection<PrestadorServico> read() {
		return dao.read();
	}

	@Override
	public void update(PrestadorServico prestador) throws BusinessException {
		dao.update(prestador);
	}

	@Override
	public Boolean delete(Integer codigo) throws BusinessException {
		return dao.delete(codigo);
	}

}
