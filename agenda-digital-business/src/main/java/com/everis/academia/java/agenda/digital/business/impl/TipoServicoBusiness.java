package com.everis.academia.java.agenda.digital.business.impl;

import java.util.Collection;

import com.everis.academia.java.agenda.digital.business.ITipoServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.dao.ITipoServicoDAO;
import com.everis.academia.java.agenda.digital.dao.impl.TipoServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

public class TipoServicoBusiness implements ITipoServicoBusiness {

	private ITipoServicoDAO dao = new TipoServicoDAO();

	@Override
	public void create(TipoServico tipoServico) throws BusinessException {
		if (tipoServico.getDescricao() == null || tipoServico.getDescricao().trim().isEmpty()) {
			throw new BusinessException("Descricao do tipo servico n�o pode ser vazio nem nulo!");
		}
		if (tipoServico.getDescricao().length() > 50) {
			throw new BusinessException(
					"Descricao do tipo servico � demasiado grande! Tamanho limite � de 50 caracteres");
		}
		dao.create(tipoServico);
	}

	@Override
	public Collection<TipoServico> read() {
		return dao.read();
	}

	@Override
	public void update(TipoServico tipoServico) throws BusinessException {
		if (tipoServico.getDescricao() == null || tipoServico.getDescricao().trim().isEmpty()) {
			throw new BusinessException("Descricao do tipo servico n�o pode ser vazio nem nulo!");
		}
		if (tipoServico.getDescricao().length() > 50) {
			throw new BusinessException(
					"Descricao do tipo servico � demasiado grande! Tamanho limite � de 50 caracteres!");
		}
		if (tipoServico.getCodigo() == null || tipoServico.getCodigo() <= 0) {
			throw new BusinessException("Codigo n�o pode ser inferior a zero ou nulo!");
		}
		dao.update(tipoServico);
	}

	@Override
	public Boolean delete(Short codigo) throws BusinessException {
		if (codigo == null || codigo <= 0) {
			throw new BusinessException("Codigo n�o pode ser inferior a zero ou nulo!");
		}
		return dao.delete(codigo);
	}

}
