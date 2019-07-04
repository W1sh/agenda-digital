<%@page import="com.everis.academia.java.agenda.digital.dao.impl.CidadeDAO"%>
<%@page import="com.everis.academia.java.agenda.digital.entidades.Cidade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<body>
	<form action="<%=request.getContextPath()%>/update/cidade/ctrl">
		<table border="1">
			<tr>
				<td colspan="2" align="center">Formulário</td>
			</tr>
			<%
			Integer codigo = Integer.valueOf(request.getParameter("codigo"));
			Cidade cidade = CidadeDAO.read(codigo);
			%>
			<tr>
				<td>Codigo:</td>
				<td><input type="text" name="codigo" value="<%=cidade.getCodigo() %>" readonly /></td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" value="<%=cidade.getNome() %>" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Enviar"> <input type="reset" value="Limpar">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
