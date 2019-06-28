package com.everis.academia.java.agenda.digital.entidades;

import java.util.Date;
import java.util.List;

public class PrestacaoServico {

	private Integer codigo;
	private Date data;
	private PrestadorServico prestadorServico;
	private List<ServicoPrestado> servicosPrestados;

	public PrestacaoServico() {
		super();
	}

	public PrestacaoServico(Integer codigo, Date data, PrestadorServico prestadorServico,
			List<ServicoPrestado> servicosPrestados) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.prestadorServico = prestadorServico;
		this.servicosPrestados = servicosPrestados;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

	public List<ServicoPrestado> getServicosPrestados() {
		return servicosPrestados;
	}

	public void setServicosPrestados(List<ServicoPrestado> servicosPrestados) {
		this.servicosPrestados = servicosPrestados;
	}

}
