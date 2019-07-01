package com.everis.academia.java.agenda.digital.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public class CidadeDAO {

	private static final List<Cidade> cidades = new ArrayList<Cidade>();

	private CidadeDAO() {
	}

	public static void create(Cidade cidade) {
		cidades.add(cidade);
	}

	public static List<Cidade> read() {
		return cidades;
	}

	public static boolean update(Cidade oldCidade, Cidade newCidade) {
		cidades.remove(oldCidade);
		return cidades.add(newCidade);
	}

	public static void delete(Cidade cidade) {
		cidades.remove(cidade);
	}

	public static void sort() {
		Collections.sort(cidades);
	}
}
