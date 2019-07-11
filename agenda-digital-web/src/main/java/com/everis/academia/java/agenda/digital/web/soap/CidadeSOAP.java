package com.everis.academia.java.agenda.digital.web.soap;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.everis.academia.java.agenda.digital.business.ICidadeBusiness;
import com.everis.academia.java.agenda.digital.business.exceptions.BusinessException;
import com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness;
import com.everis.academia.java.agenda.digital.entidades.Cidade;

@WebService()
public class CidadeSOAP {

	private ICidadeBusiness business = new CidadeBusiness();

	@WebMethod(operationName = "create")
	@WebResult(name = "cidade")
	public Cidade create(@WebParam(name = "cidade", mode = Mode.IN) Cidade cidade) throws BusinessException {
		business.create(cidade);
		return cidade;
	}

	@WebMethod(operationName = "read")
	@WebResult(name = "cidade")
	public Collection<Cidade> read() throws BusinessException {
		return business.read();

	}

	@WebMethod(operationName = "update")
	@WebResult(name = "cidade")
	public Cidade update(@WebParam(name = "cidade", mode = Mode.IN) Cidade cidade) throws BusinessException {
		business.update(cidade);
		return cidade;
	}

	@WebMethod(operationName = "delete")
	@WebResult()
	public void delete(@WebParam(name = "codigo", mode = Mode.IN) Integer codigo) throws BusinessException {
		business.delete(codigo);
	}
}