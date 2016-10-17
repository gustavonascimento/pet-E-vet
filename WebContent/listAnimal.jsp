<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file='shared/head.html'%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<!-- Style geral -->
<title>Pet e-Vet</title>
<link rel="stylesheet" href="bootstrap/css/style.css">

</head>
<body>
<%@include file='shared/navbar.html'%>
<br></br>
<br></br>
<p><h2>Cliente</h2></p>
	<table  style="width:100%">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Data de Nascimento</th>
				<th>Endereço</th>
				<th>Bairro</th>
				<th>Cidade</th>
				<th>CEP</th>
				<th>Adicionar Pet</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${customer.code}" /></td>
				<td><c:out value="${customer.name}" /></td>
				<td><c:out value="${customer.cpf.cpf}" /></td>
				<td><c:out value="${customer.email.email}" /></td>
				<td><c:out value="${customer.telephone.telephone}" /></td>
				<td><c:out value="${customer.date_of_birth}" /></td>
				<td><c:out value="${customer.address.address}" /></td>
				<td><c:out value="${customer.address.neighborhood}" /></td>
				<td><c:out value="${customer.address.city}" /></td>
				<td><c:out value="${customer.address.cep}" /></td>
				<td><a
					href="AnimalServlet?action=insert&code=<c:out value="${customer.code}"/>">Cadastrar
						Animal</a></td>
			</tr>
		</tbody>
	</table>
	<br></br>
	<p>
	<p><h2>Pets</h2></p>
	<table style="width:50%">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nome</th>
				<th>Raça</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th colspan=1>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${animalsList}" var="animal">
				<tr>
					<td><c:out value="${animal.code}" /></td>
					<td><c:out value="${animal.name}" /></td>
					<td><c:out value="${animal.breed}" /></td>
					<td><c:out value="${animal.age}" /></td>
					<td><c:out value="${animal.sex}" /></td>
					<td><a
						href="AnimalServlet?action=deleteAnimal&name=<c:out value="${animal.name}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br></br>
	</p>
	<%@include file='shared/footer.html'%>
</body>
</html>