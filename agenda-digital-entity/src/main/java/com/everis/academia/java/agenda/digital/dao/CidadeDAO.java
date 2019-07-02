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

	public static boolean update(Cidade newCidade) {
		for (Cidade cidade : CidadeDAO.read()) {
			if (cidade.getCodigo().equals(newCidade.getCodigo())) {
				cidade.setNome(newCidade.getNome());
				return true;
			}
		}
		return false;
	}

	public static boolean delete(Cidade cidade) {
		return cidades.remove(cidade);
	}

	public static void sort() {
		Collections.sort(cidades);
	}

	public static Cidade contains(String nomeCidade) {
		for (Cidade cidade : CidadeDAO.read()) {
			if (cidade.getNome().trim().equals(nomeCidade)) {
				return cidade;
			}
		}
		return null;
	}
}
