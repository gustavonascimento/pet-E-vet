<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pet e-Vet</title>
</head>
<body>
	<h1>Cadastro de cliente</h1>
	<form action="CustomerServlet" method="POST">
		<input type = "text" name ="name" placeholder = "Nome"><br>
		<input type = "text" name ="cpf" placeholder = "CPF"><br>
		<input type = "text" name ="email" placeholder = "Email"><br>
		<input type = "text" name ="telephone" placeholder = "Número de Telefone"><br>
		<input type = "text" name ="date_of_birth" placeholder = "Data de Nascimento"><br>
		<input type = "text" name ="address" placeholder = "Endereço"><br>
		<input type = "text" name ="neighborhood" placeholder = "Bairro"><br>
		<input type = "text" name ="city" placeholder = "Cidade"><br>
		<input type = "text" name ="cep" placeholder = "CEP"><br>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>