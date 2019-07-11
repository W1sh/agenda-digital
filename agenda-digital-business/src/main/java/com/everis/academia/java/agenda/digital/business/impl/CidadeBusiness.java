package com.everis.academia.java.agenda.digital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@Service
public class CidadeBusiness implements ICidadeBusiness {

	@Autowired
	private ICidadeDAO cidadeDAO;
	// private ICidadeDAO cidadeDAO = new SetCidadeDAO();

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Cidade cidade) throws BusinessException {
		validaNome(cidade.getNome());
		cidadeDAO.create(cidade);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Cidade> read() {
		return cidadeDAO.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Cidade cidade) throws BusinessException {
		validaNome(cidade.getNome());
		validaCodigo(cidade.getCodigo());
		cidadeDAO.update(cidade);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Boolean delete(Integer codigo) throws BusinessException {
		validaCodigo(codigo);
		return cidadeDAO.delete(codigo);
	}

	private void validaNome(String nome) throws BusinessException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new BusinessException("Nome da cidade não pode ser vazio nem nulo!");
		}
		if (cidadeDAO.contains(nome)) {
			throw new BusinessException("Esta cidade já existe!");
		}
	}

	private void validaCodigo(Integer codigo) throws BusinessException {
		if (codigo == null || codigo <= 0) {
			throw new BusinessException("Codigo não pode ser inferior a zero ou nulo!");
		}
	}
}
