package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.everis.academia.java.agenda.digital.dao.ICidadeDAO;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

public class CidadeDAO implements ICidadeDAO {

	private static final List<Cidade> cidades = new ArrayList<Cidade>();

	private CidadeDAO() {
	}

	@Override
	public Boolean create(Cidade cidade) {
		return cidades.add(cidade);
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
	public Boolean update(Cidade newCidade) {
		return cidades.set(cidades.indexOf(newCidade), newCidade) != null;
	}

	@Override
	public Boolean delete(Integer codigo) {
		return cidades.removeIf(c -> c.getCodigo().equals(codigo));
	}

	public static void sort(boolean reversed) {
		if (!reversed) {
			Collections.sort(cidades);
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

	public static Cidade contains(String nomeCidade) {
		// cidades.stream().anyMatch(c -> c.getNome().trim().equals(nomeCidade));
		for (Cidade cidade : cidades) {
			if (cidade.getNome().trim().equals(nomeCidade)) {
				return cidade;
			}
		}
		return null;
	}
}
