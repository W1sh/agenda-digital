package com.everis.academia.java.agenda.digital.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.everis.academia.java.agenda.digital.dao.ITelefoneDAO;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

@Repository
public class TelefoneDAO implements ITelefoneDAO {

	private static final List<Telefone> telefones = new ArrayList<Telefone>();
	private static int codigo = 1;

	@Override
	public void create(Telefone entidade) {
		entidade.setCodigo(codigo++);
		telefones.add(entidade);
	}

	@Override
	public Collection<Telefone> read() {
		return telefones;
	}

	@Override
	public void update(Telefone entidade) {
		for (Telefone telefone : telefones) {
			/* TODO */
		}
	}

	@Override
	public Boolean delete(Telefone entidade) {
		return telefones.remove(entidade);
	}

	@Override
	public Boolean delete(Integer codigo) {
		return telefones.removeIf(c -> c.getCodigo().equals(codigo));
	}

}
