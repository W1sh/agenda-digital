<%@page import="com.everis.academia.java.agenda.digital.entidades.Cidade"%>
<%@page import="com.everis.academia.java.agenda.digital.business.impl.CidadeBusiness"%>
<%@page import="com.everis.academia.java.agenda.digital.business.ICidadeBusiness"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<body>
	<a href="<%=request.getContextPath()%>/jsp/cidade/create.jsp"><label>Create</label></a>
	<br>
	<!-- <a href="<%=request.getContextPath()%>/cc?operation=sort"><label>Sort</label></a>
	<br>
	<a href="<%=request.getContextPath()%>/cc?operation=sortByName"><label>Sort by name</label></a>
	<br> -->
	<table border="1">
	<tr>
			<th align="center"><label>Codigo: </label></th>
			<th align="center"><label>Name: </label></th>
			<th colspan="2" align="center"><label>Ações: </label></th>
	</tr>
		<%
		ICidadeBusiness business = new CidadeBusiness();
		for(Cidade cidade : business.read()){ %>	
		<tr>
			<td align="center" width="75px"><%=cidade.getCodigo() %></td>
			<td width="200px"><%=cidade.getNome() %></td>
			<td><a href="<%=request.getContextPath()%>/delete/cidade/ctrl?codigo=<%=cidade.getCodigo()%>"><label>Delete</label></a></td>
			<td><a href="<%=request.getContextPath()%>/jsp/cidade/update.jsp?codigo=<%=cidade.getCodigo()%>"><label>Update</label></a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>