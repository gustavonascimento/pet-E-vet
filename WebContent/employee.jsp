<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<form method = "POST" action='EmployeeServlet' name="formAddEmployee">
		Código do Funcionário : <input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${employee.code}"/>" /> <br />
		Nome :	<input
				type="text" name="name"
				value="<c:out value="${employee.name}" />" /> <br />
		CPF :	<input
				type="text" name="cpf"
				value="<c:out value="${employee.cpf.cpf}" />" /> <br />
		Email :	<input
				type="text" name="email"
				value="<c:out value="${employee.email.email}" />" /> <br />
		Telefone :	<input
				type="text" name="telephone"
				value="<c:out value="${employee.telephone.telephone}" />" /> <br />
		Cargo/Função:	<input
				type="text" name="role"
				value="<c:out value="${employee.role}" />" /> <br />
		<input type="submit" value="Submit" />	
	</form>
<%@include file='shared/footer.html'%>
</body>
</html>