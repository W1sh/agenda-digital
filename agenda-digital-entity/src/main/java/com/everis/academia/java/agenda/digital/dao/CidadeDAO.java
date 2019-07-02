package com.everis.academia.java.agenda.digital.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public class CidadeDAO {

	private static final List<Cidade> cidades = new ArrayList<Cidade>();

	private CidadeDAO() {
	}

	public static boolean create(Cidade cidade) {
		return cidades.add(cidade);
	}

	public static List<Cidade> read() {
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

	public static void update(Cidade newCidade) {
		cidades.set(cidades.indexOf(newCidade), newCidade);
	}

	public static boolean delete(Integer codigo) {
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
		for (Cidade cidade : CidadeDAO.read()) {
			if (cidade.getNome().trim().equals(nomeCidade)) {
				return cidade;
			}
		}
		return null;
	}
}
