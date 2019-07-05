package com.everis.academia.java.agenda.digital.web.jsf.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloJSF")
public class HelloJSF {

	private String mensagem = "Academistas";

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
