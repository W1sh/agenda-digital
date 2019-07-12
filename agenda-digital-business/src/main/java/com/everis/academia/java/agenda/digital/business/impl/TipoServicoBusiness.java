package com.everis.academia.java.agenda.digital.business.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.dao.ITipoServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@Service
public class TipoServicoBusiness implements ITipoServicoBusiness {

	@Autowired
	private ITipoServicoDAO dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(TipoServico tipoServico) throws BusinessException {
		validaNome(tipoServico);
		dao.create(tipoServico);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<TipoServico> read() {
		return dao.read();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(TipoServico tipoServico) throws BusinessException {
		validaNome(tipoServico);
		validaCodigo(tipoServico.getCodigo());
		dao.update(tipoServico);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Short codigo) throws BusinessException {
		validaCodigo(codigo);
		dao.delete(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean isAssigned(Short codigo) {
		return dao.isAssigned(codigo);
	}

	private void validaNome(TipoServico tipoServico) throws BusinessException {
		if (tipoServico.getDescricao() == null || tipoServico.getDescricao().trim().isEmpty()) {
			throw new BusinessException("Descricao do tipo servico não pode ser vazio nem nulo!");
		}
		if (tipoServico.getDescricao().length() > 50) {
			throw new BusinessException(
					"Descricao do tipo servico é demasiado grande! Tamanho limite é de 50 caracteres");
		}
	}

	private void validaCodigo(Short codigo) throws BusinessException {
		if (codigo == null || codigo <= 0) {
			throw new BusinessException("Codigo não pode ser inferior a zero ou nulo!");
		}
	}

}
