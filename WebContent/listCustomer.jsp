<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Customers</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Data de Nascimento</th>
				<th>Endereço</th>
				<th>Bairro</th>
				<th>Cidade</th>
				<th>CEP</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td><c:out value="${customer.code}"/></td>
					<td><c:out value="${customer.name}" /></td>
					<td><c:out value="${customer.cpf}" /></td>
					<td><c:out value="${customer.email}" /></td>
					<td><c:out value="${customer.telephone}" /></td>
					<td><c:out value="${customer.date_of_birth}" /></td>
					<td><c:out value="${customer.address}" /></td>
					<td><c:out value="${customer.neighborhood}" /></td>
					<td><c:out value="${customer.city}" /></td>	
					<td><c:out value="${customer.cep}" /></td>	
					<td><a href="CustomerServlet?action=edit&code=<c:out value="${customer.code}"/>">Update</a></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="CustomerServlet?action=insert">Cadastrar Cliente</a></p>		
</body>
</html>