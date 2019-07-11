package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;

@Repository
public class PrestadorServicoDAO implements IPrestadorServicoDAO {

	private static final List<PrestadorServico> prestadores = new ArrayList<PrestadorServico>();
	private static int codigo = 1;

	@Override
	public void create(PrestadorServico entidade) {
		entidade.setCodigo(codigo++);
		prestadores.add(entidade);
	}

	@Override
	public Collection<PrestadorServico> read() {
		return prestadores;
	}

	@Override
	public void update(PrestadorServico entidade) {
		prestadores.set(prestadores.indexOf(entidade), entidade);
	}

	@Override
	public Boolean delete(PrestadorServico entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Integer codigo) {
		return prestadores.removeIf(c -> c.getCodigo().equals(codigo));
	}

}
