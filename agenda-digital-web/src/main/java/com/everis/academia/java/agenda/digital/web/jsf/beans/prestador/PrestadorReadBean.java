package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import java.util.Collection;
import java.util.Set;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.everis.academia.java.agenda.digital.business.IPrestadorServicoBusiness;
import com.everis.academia.java.agenda.digital.entidades.PrestadorServico;
import com.everis.academia.java.agenda.digital.entidades.Telefone;
import com.everis.academia.java.agenda.digital.entidades.TipoServico;

@Component(value = "prestadorRead")
@ManagedBean(name = "prestadorRead")
@RequestScope
public class PrestadorReadBean {

	@Autowired
	private IPrestadorServicoBusiness business;

	public Collection<PrestadorServico> getPrestadores() {
		return business.read();
	}

	public String telefonesAsString(Set<Telefone> telefones) {
		if (!telefones.isEmpty()) {
			return telefones.stream().map(t -> t.getNumero().toString()).reduce((s1, s2) -> s1 + ", " + s2).get();
		}
		return "";
	}

	public String servicosAsString(Set<TipoServico> servicosCredenciados) {
		if (!servicosCredenciados.isEmpty()) {
			return servicosCredenciados.stream().map(t -> t.getDescricao()).reduce((s1, s2) -> s1 + ", " + s2).get();
		}
		return "";
	}

	public String call() {
		System.out.println("redirect");
		return "prestadores";
	}
}
