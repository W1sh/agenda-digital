package com.everis.academia.java.agenda.digital.dao;

import java.util.HashSet;
import java.util.Set;

import com.everis.academia.java.agenda.digital.entidades.Cidade;

public class CidadeDAO {

	private static final Set<Cidade> cidades = new HashSet<Cidade>();

	private CidadeDAO() {
	}

	public static void create(Cidade cidade) {
		cidades.add(cidade);
	}

	public static Set<Cidade> read() {
		return cidades;
	}

	public static boolean update(Cidade oldCidade, Cidade newCidade) {
		cidades.remove(oldCidade);
		return cidades.add(newCidade);
	}

	public static void delete(Cidade cidade) {
		System.out.println(cidades.size());
		cidades.remove(cidade);
		System.out.println(cidades.size());
	}
}
