package com.everis.academia.java.agenda.digital.business.impl;

import java.util.List;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

public class CidadeBusiness implements ICidadeBusiness {

	private CidadeDAO cidadeDAO = new CidadeDAO();

	@Override
	public void create(Cidade cidade) throws BusinessException {
		validaNome(cidade.getNome());
		cidadeDAO.create(cidade);
	}

	@Override
	public List<Cidade> read() {
		return cidadeDAO.read();
	}

	@Override
	public void update(Cidade cidade) throws BusinessException {
		validaNome(cidade.getNome());
		validaCodigo(cidade.getCodigo());
		cidadeDAO.update(cidade);
	}

	@Override
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
