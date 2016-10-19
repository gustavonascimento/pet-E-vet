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
<p><h2>Administradores</h2></p>
	<table style="width:100%">
		<thead>
			<tr>
				<th>Code</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th>Telefone</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ownersList}" var="employee">
				<tr>
					<td><c:out value="${owner.code}"/></td>
					<td><c:out value="${owner.name}" /></td>
					<td><c:out value="${owner.cpf.cpf}" /></td>
					<td><c:out value="${owner.email.email}" /></td>
					<td><c:out value="${owner.telephone.telephone}" /></td>
	
					<td><a href="OwnerServlet?action=edit&code=<c:out value="${owner.code}"/>">Update</a></td>
					<td><a href="OwnerServlet?action=delete&code=<c:out value="${owner.code}"/>">Delete</a></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br></br>
	<p><a href="OwnerServlet?action=insert">Cadastrar Administrador</a></p>	
	<%@include file='shared/footer.html'%>	
</body>
</html>