<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a new owner</title>
</head>
<body>
		<form method = "POST" action='OwnerServlet' name="formAddOwner">
		Code : <input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${owner.code}"/>" /> <br />
		Nome :	<input
				type="text" name="name"
				value="<c:out value="${owner.name}" />" /> <br />
		CPF :	<input
				type="text" name="cpf"
				value="<c:out value="${owner.cpf.cpf}" />" /> <br />
		Email :	<input
				type="text" name="email"
				value="<c:out value="${owner.email.email}" />" /> <br />
		Telefone :	<input
				type="text" name="telephone"
				value="<c:out value="${owner.telephone.telephone}" />" /> <br />
		Senha :	<input
				type="text" name="password"
				value="<c:out value="${owner.password}" />" /> <br />
		<input type="submit" value="Submit" />	
	</form>
</body>
</html>