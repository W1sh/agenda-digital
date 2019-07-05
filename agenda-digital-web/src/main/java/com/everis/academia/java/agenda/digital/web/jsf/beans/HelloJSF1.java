package com.everis.academia.java.agenda.digital.web.jsf.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloJSF1")
public class HelloJSF1 {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String digaOi() {
		System.out.println("...");
		return "Oi!";
	}

}
