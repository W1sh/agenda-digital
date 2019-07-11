package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.HashSet;
import java.util.Set;

import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

public class SetCidadeDAO implements ICidadeDAO {

	private static final Set<Cidade> cidades = new HashSet<Cidade>();
	private static int codigo = 1;

	@Override
	public void create(Cidade cidade) {
		cidade.setCodigo(codigo++);
		cidades.add(cidade);
	}

	@Override
	public Set<Cidade> read() {
		return cidades;
	}

	@Override
	public void update(Cidade cidade) {
		cidades.forEach(c -> {
			if (c.getCodigo().equals(cidade.getCodigo())) {
				cidades.remove(c);
				cidades.add(cidade);
			}
		});

	}

	@Override
	public Boolean delete(Integer codigo) {
		return cidades.removeIf(c -> c.getCodigo().equals(codigo));
	}

	@Override
	public Boolean delete(Cidade entidade) {
		return cidades.remove(entidade);
	}

	@Override
	public Boolean contains(String nome) {
		for (Cidade c : cidades) {
			if (c.getNome().trim().equals(nome)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean contains(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}
}
