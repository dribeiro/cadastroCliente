<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Atualizar Cliente</title>
</head>
<body>
	<h1>Alteração de Clientes</h1>
	<form action="<c:url value="/cliente/${cliente.id}"/>" method="post">
	<fieldset>
		<div>
			<label for="nome">Nome:</label>
			<input type="text" value="${cliente.nome}" name="cliente.nome"/>
		</div>
		<input type="hidden" name="_method" value="PUT"/>
		<input type="hidden" name="cliente.id" value="${cliente.id}" />
		<button type="submit" >Atualizar</button>

	</fieldset>

	</form>

</body>
</html>
