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
<title>Products</title>
<link rel="stylesheet" href="bootstrap/css/style.css">
</head>
</head>
<body>
<%@include file='shared/navbar.html'%>
<br></br>
<br></br>
	<form method = "POST" action='ProductServlet' name="formAddProduct">
		Code : <input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${product.code}"/>" /> <br />
		Nome :	<input
				type="text" name="name"
				value="<c:out value="${product.name}" />" /> <br />
		Valor :	<input
				type="text" name="value"
				value="<c:out value="${product.value}" />" /> <br />
		Quantidade :	<input
				type="text" name="quantity"
				value="<c:out value="${product.quantity}" />" /> <br />
		Descrição :	<input
				type="text" name="description"
				value="<c:out value="${product.description}" />" /> <br />
		
		<input type="submit" value="Submit" />	
	</form>
<%@include file='shared/footer.html'%>
</body>
</html>