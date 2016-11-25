<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<%@include file='../../shared/head.html'%>
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
<%@include file='../../shared/navbar.html'%>
<br></br>
<br></br>
<div style="width:200px;margin:auto;">
	<form method = "POST" action='EmployeeServlet' name="formAddEmployee">
		<label for ="code"> Code: </label>	<br>
		<input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${employee.code}"/>" /> <br />
		<label for ="name"> Name: </label>	<br>
		<input
				type="text" required="required" pattern="[A-Za-z�-�0-9., -]{5,}+$" name="name" title="Apenas letras mai�sculas e min�sculas"
				value="<c:out value="${employee.name}" />" /> <br />
		<label for ="cpf"> CPF: </label>	<br>
		<input
				type="text" required="required" pattern="[0-9]+$" name="cpf" title="Digite um CPF no formato: xxxxxxxxxxx"
				value="<c:out value="${employee.cpf.cpf}" />" /> <br />
		<label for ="email"> Email: </label>	<br>
		<input
				type="email" required="required" class="input-text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" title="Digite um EMAIL no formato: email@valido.com"
				value="<c:out value="${employee.email.email}" />" /> <br />
		<label for ="telepfone"> Telefone: </label>	<br>
		<input
				type="text" required="required" pattern="\([0-9]{2}\)? ?[0-9]{4,5}?-?[0-9]{4}$" maxlength="15" name="telephone" title="Digite um TELEFONE no formato: (xx) xxxx-xxxx"
				value="<c:out value="${employee.telephone.telephone}" />" /> <br />
		<label for ="role"> Cargo/Fun��o: </label>	<br>
		<input
				type="text" required="required" pattern="[A-Za-z�-�0-9., -]{5,}+$" name="role" title="Apenas letras mai�sculas e min�sculas"
				value="<c:out value="${employee.role}" />" /> <br /> <br />
				
		<input type="submit" class="btn btn-primary" value="Submit" />	
	</form>
</div>
<%@include file='../../shared/footer.html'%>
</body>
</html>