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
		Código do animal : <input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${animal.code}"/>" /> <br />
		Nome :	<input
				type="text" name="name"
				value="<c:out value="${animal.name}" />" /> <br />
		Raça :	<input
				type="text" name="breed"
				value="<c:out value="${animal.breed.breed}" />" /> <br />
		Idade :	<input
				type="text" name="age"
				value="<c:out value="${animal.age.age}" />" /> <br />
		Sexo :	<input
				type="text" name="sex"
				value="<c:out value="${animal.sex.sex}" />" /> <br />
		<input type="submit" value="Submit" />	
	</form>

</body>
</html>