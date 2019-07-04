<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<body>
	<form action="<%=request.getContextPath()%>/create/cidade/ctrl">
		<table border="1">
			<tr>
				<td colspan="2">Formulário</td>
			</tr>
			<tr>
				<td>Nome:</td>
				<td><input type="text" name="nome" /></td>
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
