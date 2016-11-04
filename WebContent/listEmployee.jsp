<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
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
	<table align="center" style="width:90%" class="table">
		<thead>
			<tr>
				<th><h2>Funcionários</h2></th>
			</tr>
			<tr>
				<th>Code</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Email</th>
				<th>Telefone</th>
				<th>Atribuição</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${employeesList}" var="employee">
				<tr>
					<td><c:out value="${employee.code}"/></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.cpf.cpf}" /></td>
					<td><c:out value="${employee.email.email}" /></td>
					<td><c:out value="${employee.telephone.telephone}" /></td>
					<td><c:out value="${employee.role}" /></td>
	
					<td><a href="EmployeeServlet?action=edit&code=<c:out value="${employee.code}"/>">Update</a></td>
					<td><a href="EmployeeServlet?action=delete&code=<c:out value="${employee.code}"/>">Delete</a></td>	
				</tr>
			</c:forEach>
		<tr>
			<td><a href="EmployeeServlet?action=insert">Cadastrar Funcionário</a></td>
		</tr>	
		</tbody>
		
	</table>
	<br></br>
	<%@include file='shared/footer.html'%>	
</body>
</html>