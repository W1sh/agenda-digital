package com.everis.academia.java.agenda.digital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CIDADE", schema = "public")
@SequenceGenerator(name = "SQ_CIDADE", sequenceName = "SQ_CIDADE", initialValue = 1, allocationSize = 1, schema = "public")
public class Cidade implements Comparable<Cidade>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SQ_CIDADE", strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO")
	private Integer codigo;

	@Column(name = "NOME", length = 255, nullable = false, unique = true)
	private String nome;

	public Cidade() {
		super();
	}

	public Cidade(Integer codigo) {
		this();
		this.codigo = codigo;
	}

	public Cidade(Integer codigo, String nome) {
		this(codigo);
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cidade other) {
		return this.codigo.compareTo(other.getCodigo());
	}

	@Override
	public String toString() {
		return "Cidade [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
