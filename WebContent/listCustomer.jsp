<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<p><h2>Clientes</h2></p>
	<table align="center" style="width:90%" title="Clientes">
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
				<th>Pets</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customersList}" var="customer">
				<tr>
					<td><c:out value="${customer.code}"/></td>
					<td><c:out value="${customer.name}" /></td>
					<td><c:out value="${customer.cpf.cpf}" /></td>
					<td><c:out value="${customer.email.email}" /></td>
					<td><c:out value="${customer.telephone.telephone}" /></td>
					<td><c:out value="${customer.date_of_birth}" /></td>
					<td><c:out value="${customer.address.address}" /></td>
					<td><c:out value="${customer.address.neighborhood}" /></td>
					<td><c:out value="${customer.address.city}" /></td>	
					<td><c:out value="${customer.address.cep}" /></td>
					<td><a href="AnimalServlet?action=listAnimal&code=<c:out value="${customer.code}"/>">Pets</a></td>	
					<td><a href="CustomerServlet?action=edit&code=<c:out value="${customer.code}"/>">Update</a></td>
					<td><a href="CustomerServlet?action=delete&code=<c:out value="${customer.code}"/>">Delete</a></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br></br>
	<p><a href="CustomerServlet?action=insert">Cadastrar Cliente</a></p>		
	<%@include file='shared/footer.html'%>
</body>
</html>