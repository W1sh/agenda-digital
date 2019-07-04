<%@page import="com.everis.academia.java.agenda.digital.entidades.Cidade"%>
<%@page import="com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness"%>
<%@page import="com.everis.academia.java.agenda.digital.business.ICidadeBusiness"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<body>
	<a href="<%=request.getContextPath()%>/jsp/cidade/create"><label>Create</label></a>
	<br>
	<a href="<%=request.getContextPath()%>/cc?operation=sort"><label>Sort</label></a>
	<br>
	<a href="<%=request.getContextPath()%>/cc?operation=sortByName"><label>Sort by name</label></a>
	<br>
	<table border="1">
	<tr>
			<td><label>Codigo: </label></td>
			<td><label>Name: </label></td>
	</tr>
		<%
		ICidadeBusiness business = new CidadeBusiness();
		for(Cidade cidade : business.read()){ %>	
		<tr>
			<td><%=cidade.getCodigo() %></td>
			<td><%=cidade.getNome() %></td>
			<td><a href="<%=request.getContextPath()%>/delete/cidade/ctrl?codigo=1"><label>Delete</label></a></td>
			<td><a href="<%=request.getContextPath()%>/jsp/cidade/update?codigo=1"><label>Update</label></a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>