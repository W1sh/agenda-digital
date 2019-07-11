package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.ITipoServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@Repository
public class TipoServicoDAO implements ITipoServicoDAO {

	private static final List<TipoServico> tipoServicos = new ArrayList<TipoServico>();
	private static short codigo = 1;

	@Override
	public void create(TipoServico entidade) {
		entidade.setCodigo(codigo++);
		tipoServicos.add(entidade);
	}

	@Override
	public Collection<TipoServico> read() {
		return tipoServicos;
	}

	@Override
	public void update(TipoServico entidade) {
		tipoServicos.set(tipoServicos.indexOf(entidade), entidade);
	}

	@Override
	public void delete(TipoServico entidade) {
		delete(entidade.getCodigo());
	}

	@Override
	public Boolean delete(Short codigo) {
		return tipoServicos.removeIf(ts -> ts.getCodigo().equals(codigo));
	}

}
