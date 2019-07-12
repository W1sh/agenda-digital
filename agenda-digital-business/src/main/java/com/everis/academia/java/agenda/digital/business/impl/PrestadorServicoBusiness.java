package com.everis.academia.java.agenda.digital.business.impl;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agenda.digital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.dao.IPrestadorServicoDAO;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;

@Service
public class PrestadorServicoBusiness implements IPrestadorServicoBusiness {

	@Autowired
	private IPrestadorServicoDAO dao;
	private static final int NUMERO_LENGTH = 9;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(PrestadorServico prestador) throws BusinessException {
		validaPrestador(prestador);
		validaTelefones(prestador.getTelefones());
		dao.create(prestador);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<PrestadorServico> read() {
		return dao.read();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Telefone> readTelefones() {
		return dao.readTelefones();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(PrestadorServico prestador) throws BusinessException {
		validaPrestador(prestador);
		validaTelefones(prestador.getTelefones());
		validaCodigo(prestador.getCodigo());
		for (Telefone t : prestador.getTelefones()) {
			validaCodigo(t.getCodigo());
		}
		dao.update(prestador);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer codigo) throws BusinessException {
		validaCodigo(codigo);
		dao.delete(codigo);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Boolean numeroTelefoneExists(Long numero) {
		return dao.numeroTelefoneExists(numero);
	}

	private void validaCodigo(Integer codigo) throws BusinessException {
		if (codigo == null || codigo <= 0) {
			throw new BusinessException("Codigo não pode ser inferior a zero ou nulo!");
		}
	}

	public void validaPrestador(PrestadorServico prestador) throws BusinessException {
		if (prestador.getNome() == null || prestador.getNome().trim().isEmpty()) {
			throw new BusinessException("Nome do prestador não pode ser vazio nem nulo!");
		}
		if (prestador.getCidade() == null) {
			throw new BusinessException("Cidade não pode ser nula!");
		}
		if (prestador.getBairro() == null || prestador.getBairro().trim().isEmpty()) {
			throw new BusinessException("Bairro não pode ser vazio nem nulo!");
		}
		if (prestador.getCep() == null || prestador.getCep().trim().isEmpty()) {
			throw new BusinessException("CEP não pode ser vazio nem nulo!");
		}
		if (prestador.getLogradouro() == null || prestador.getLogradouro().trim().isEmpty()) {
			throw new BusinessException("Logradouro não pode ser vazio nem nulo!");
		}
		if (prestador.getComplemento() == null || prestador.getComplemento().trim().isEmpty()) {
			throw new BusinessException("Complemento não pode ser vazio nem nulo!");
		}
		if (prestador.getNumero() == null || prestador.getNumero().trim().isEmpty()) {
			throw new BusinessException("Numero não pode ser vazio nem nulo!");
		}
		if (prestador.getEmail() == null || prestador.getEmail().trim().isEmpty()) {
			throw new BusinessException("Email não pode ser vazio nem nulo!");
		}
		if (!prestador.getEmail().contains("@")) {
			throw new BusinessException("Email inválido!");
		}
		if (prestador.getTelefones().isEmpty()) {
			throw new BusinessException("Prestador tem que ter pelo menos um telefone!");
		}
		if (prestador.getServicosCredenciados().isEmpty()) {
			throw new BusinessException("Prestador tem que ter pelo menos um serviço credenciado!");
		}
	}

	public void validaTelefones(Set<Telefone> telefones) throws BusinessException {
		for (Telefone t : telefones) {
			if (t.getNumero() == null) {
				throw new BusinessException("Numero de telefone não pode ser nulo!");
			}
			if (t.getNumero().toString().length() < NUMERO_LENGTH
					|| t.getNumero().toString().length() > NUMERO_LENGTH) {
				throw new BusinessException("Numero de telefone tem que ter 9 digitos!");
			}
		}
	}
}
