<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Cadastrar Cliente</title>

</head>
<body>
	<div>
		<h1>Cadastro de Clientes</h1>
		<form action="<c:url value="/cliente"/>" method="post">
			<fieldset>
				<div>
					<label for="nome">Nome:</label> <input type="text" name="cliente.nome" /> 
					<input type="submit" value="Criar Cliente" />
				</div>
			</fieldset>
		</form>
	</div>

</body>
</html>
