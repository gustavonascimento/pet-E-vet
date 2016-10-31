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
<title>List of Products</title>
<link rel="stylesheet" href="bootstrap/css/style.css">

</head>
<body>
<%@include file='shared/navbar.html'%>
<br></br>
<br></br>
<p><h2>Produtos</h2></p>
	<table align="center" style="width:100%" title="Produtos">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nome</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th>Descricao</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td><c:out value="${product.code}"/></td>
					<td><c:out value="${product.name}" /></td>
					<td><c:out value="${product.value}" /></td>
					<td><c:out value="${product.quantity}" /></td>
					<td><c:out value="${product.description}" /></td>	
					<td><a href="ProductServlet?action=edit&code=<c:out value="${product.code}"/>">Update</a></td>
					<td><a href="ProductServlet?action=delete&code=<c:out value="${product.code}"/>">Delete</a></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br></br>
	<p><a href="ProductServlet?action=insert">Cadastrar Produto</a></p>		
	<%@include file='shared/footer.html'%>
</body>
</html>