<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new customer</title>
</head>
<body>
	<form method = "POST" action='CustomerServlet' name="formAddCustomer">
		Code : <input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${customer.code}"/>" /> <br />
		Nome :	<input
				type="text" name="name"
				value="<c:out value="${customer.name}" />" /> <br />
		CPF :	<input
				type="text" name="cpf"
				value="<c:out value="${customer.cpf.cpf}" />" /> <br />
		Email :	<input
				type="text" name="email"
				value="<c:out value="${customer.email.email}" />" /> <br />
		Telefone :	<input
				type="text" name="telephone"
				value="<c:out value="${customer.telephone.telephone}" />" /> <br />
		Data de Nascimento :	<input
				type="text" name="date_of_birth"
				value="<c:out value="${customer.date_of_birth}" />" /> <br />
		Endereço :	<input
				type="text" name="address"
				value="<c:out value="${customer.address.address}" />" /> <br />
		Bairro :	<input
				type="text" name="neighborhood"
				value="<c:out value="${customer.address.neighborhood}" />" /> <br />
		Cidade :	<input
				type="text" name="city"
				value="<c:out value="${customer.address.city}" />" /> <br />
		CEP :	<input
				type="text" name="cep"
				value="<c:out value="${customer.address.cep}" />" /> <br />
		<input type="submit" value="Submit" />	
	</form>

</body>
</html>