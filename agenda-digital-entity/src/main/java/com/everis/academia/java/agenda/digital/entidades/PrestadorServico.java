package com.everis.academia.java.agenda.digital.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.everis.academia.java.agenda.digital.enums.TipoLogradouro;

@Entity
@Table(name = "TB_PRESTADOR_SERVICO", schema = "public")
@SequenceGenerator(name = "SQ_PRESTADOR_SERVICO", sequenceName = "SQ_PRESTADOR_SERVICO", initialValue = 1, allocationSize = 1, schema = "public")
public class PrestadorServico {

	@Id
	@GeneratedValue(generator = "SQ_PRESTADOR_SERVICO", strategy = GenerationType.SEQUENCE)
	@Column(name = "CODIGO")
	private Integer codigo;

	@Column(name = "NOME", length = 255, nullable = false, unique = false)
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
	@JoinColumn(name = "ID_CIDADE", nullable = false)
	private Cidade cidade;

	@Column(name = "BAIRRO", length = 255, nullable = false, unique = false)
	private String bairro;

	@Column(name = "CEP", length = 255, nullable = false, unique = false)
	private String cep;

	@Column(name = "TIPO_LOGRADOURO", length = 255, nullable = false, unique = false)
	private TipoLogradouro tipoLogradouro;

	@Column(name = "LOGRADOURO", length = 255, nullable = false, unique = false)
	private String logradouro;

	@Column(name = "COMPLEMENTO", length = 255, nullable = false, unique = false)
	private String complemento;

	@Column(name = "NUMERO", length = 50, nullable = false, unique = false)
	private String numero;

	@Column(name = "EMAIL", length = 255, nullable = false, unique = true)
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, targetEntity = Telefone.class)
	private Set<Telefone> telefones;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = TipoServico.class)
	@JoinTable(name = "TB_SERVICOS_PRESTADOS", joinColumns = {
			@JoinColumn(name = "ID_PRESTADOR") }, inverseJoinColumns = { @JoinColumn(name = "ID_TIPO_SERVICO") })
	private Set<TipoServico> servicosCredenciados;

	@Transient
	private Set<PrestacaoServico> prestacaoServicos;

	public PrestadorServico() {
		super();
		this.telefones = new HashSet<>();
		this.prestacaoServicos = new HashSet<>();
		this.servicosCredenciados = new HashSet<>();
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<PrestacaoServico> getPrestacaoServicos() {
		return prestacaoServicos;
	}

	public void setPrestacaoServicos(Set<PrestacaoServico> prestacaoServicos) {
		this.prestacaoServicos = prestacaoServicos;
	}

	public Set<TipoServico> getServicosCredenciados() {
		return servicosCredenciados;
	}

	public void setServicosCredenciados(Set<TipoServico> servicosCredenciados) {
		this.servicosCredenciados = servicosCredenciados;
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
		PrestadorServico other = (PrestadorServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrestadorServico [codigo=" + codigo + ", nome=" + nome + ", cidade=" + cidade + ", bairro=" + bairro
				+ ", cep=" + cep + ", tipoLogradouro=" + tipoLogradouro + ", logradouro=" + logradouro
				+ ", complemento=" + complemento + ", numero=" + numero + ", email=" + email + ", telefones="
				+ telefones + ", prestacaoServicos=" + prestacaoServicos + ", servicosCredenciados="
				+ servicosCredenciados + "]";
	}

}
