<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Employees</title>
</head>
<body>
	<table border=1>
		<thead>
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
		</tbody>
	</table>
	<p><a href="EmployeeServlet?action=insert">Cadastrar Funcionário</a></p>		
</body>
</html>