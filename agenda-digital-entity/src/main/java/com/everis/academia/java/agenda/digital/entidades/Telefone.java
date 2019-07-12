package com.everis.academia.java.agenda.digital.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TELEFONE", schema = "public")
@SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", initialValue = 1, allocationSize = 1, schema = "public")
public class Telefone {

	@Id
	@GeneratedValue(generator = "SQ_TELEFONE", strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO")
	private Integer codigo;

	@Column(name = "NUMERO", nullable = false, unique = true)
	private Long numero;

	@ManyToOne(targetEntity = PrestadorServico.class)
	@JoinColumn(name = "ID_PRESTADOR", nullable = false)
	private PrestadorServico prestadorServico;

	public Telefone() {
		super();
	}

	public Telefone(Long numero) {
		this();
		this.numero = numero;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Telefone [codigo=" + codigo + ", numero=" + numero + ", prestadorServico=" + prestadorServico + "]";
	}
}
