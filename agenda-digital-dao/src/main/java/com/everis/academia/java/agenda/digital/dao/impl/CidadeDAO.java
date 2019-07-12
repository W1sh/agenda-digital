package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

public class CidadeDAO implements ICidadeDAO {

	private static final List<Cidade> cidades = new ArrayList<Cidade>();
	private static int codigo = 1;

	@Override
	public void create(Cidade cidade) {
		cidade.setCodigo(codigo++);
		cidades.add(cidade);
	}

	@Override
	public List<Cidade> read() {
		return cidades;
	}

	public static Cidade read(Integer codigo) {
		// cidades.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst().get();
		for (Cidade cidade : cidades) {
			if (cidade.getCodigo().equals(codigo)) {
				return cidade;
			}
		}
		return null;
	}

	@Override
	public void update(Cidade newCidade) {
		cidades.set(cidades.indexOf(newCidade), newCidade);
	}

	@Override
	public void delete(Integer codigo) {
		cidades.removeIf(c -> c.getCodigo().equals(codigo));
	}

	@Override
	public void delete(Cidade entidade) {
		cidades.remove(entidade);
	}

	public static void sort(boolean reversed) {
		if (!reversed) {
			cidades.sort((o1, o2) -> o1.getCodigo().compareTo(o2.getCodigo()));
		} else {
			cidades.sort((o1, o2) -> o2.getCodigo().compareTo(o1.getCodigo()));
		}
	}

	public static void sortByName(boolean reversed) {
		if (!reversed) {
			cidades.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome()));
		} else {
			cidades.sort((o1, o2) -> o2.getNome().compareTo(o1.getNome()));
		}
	}

	@Override
	public Boolean contains(Cidade cidade) {
		for (Cidade c : cidades) {
			if (c.getNome().trim().equals(cidade.getNome())) {
				return true;
				/* TODO */
			}
		}
		return false;
	}
}
