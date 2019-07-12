package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.everis.academia.java.agenda.digital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

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
	public void delete(Integer codigo) {
		prestadores.removeIf(p -> p.getCodigo().equals(codigo));
	}

	@Override
	public Collection<Telefone> readTelefones() {
		// TODO Auto-generated method stub
		return null;
	}

}
