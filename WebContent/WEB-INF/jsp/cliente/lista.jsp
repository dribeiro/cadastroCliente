<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
	<h1>Lista de Clientes</h1>
	<div>
				<c:if test="${not empty clientes}">
					<table width="600px">
						<tr>
						<thead>
							<th>Id</th>
							<th>Nome</th>
							<th colspan="2"></th>
						</thead>
						</tr>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.id}</td>
								<td>${cliente.nome}</td>
								<td><a href="<c:url value="/cliente/${cliente.id}"/>">Atualizar</a>
								</td>
								<td>
									<form action="<c:url value="/cliente/${cliente.id}"/>" method="post">
										<input name="_method" value="DELETE" type="hidden" /> 
										<input name="cliente.id" value="${cliente.id}" type="hidden" /> 
										<input type="submit" value="Remover" />
									</form>
							</tr>
						</c:forEach>
					</table>
				</c:if>
				<c:if test="${empty clientes}">Não há clientes cadastrados.</c:if>
		<fieldset>
			<a href="<c:url value="/formulario"/>">Criar Novo</a>
		</fieldset>
	</div>

</body>
</html>
