package com.everis.academia.java.agenda.digital.web.jsf.beans.prestador;

import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component(value = "prestadorUpdate")
@ManagedBean(name = "prestadorUpdate")
@RequestScope
public class PrestadorUpdateBean {

	public String call() {
		return "";
	}
}
