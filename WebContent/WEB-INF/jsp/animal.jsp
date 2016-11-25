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
	<form method = "POST" action='AnimalServlet' name="formAddAnimal">
		<label for ="code"> Code: </label>	<br>
		<input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${customer.code}"/>" /> <br />
		<label for ="name"> Nome: </label>	<br>
		<input
				id = "name" type="text" required="required" pattern="[a-zA-Z\s]+$" name="name" title="Apenas letras maiúsculas e minúsculas"
				value="<c:out value="${animal.name}" />" /> <br />
		<label for ="breed"> Raça: </label>	<br>
		<input
				type="text" required="required" pattern="[a-zA-Z\s]+$" name="breed" title="Apenas letras maiúsculas e minúsculas"
				value="<c:out value="${animal.breed}" />" /> <br />
		<label for ="age"> Idade: </label>	<br>
		<input
				type="text" required="required"  pattern="[0-9]+$" name="age" title="Apenas caracteres numéricos"
				value="<c:out value="${animal.age}" />" /> <br />
		<label for ="sex"> Sexo: </label>	<br>
		<input
				type="text" required="required" pattern="[a-zA-Z\s]+$" maxlength = "1" name="sex" title="Apenas uma letra M ou F"
				value="<c:out value="${animal.sex}" />" /> <br /> <br />
				
		<input type="submit" class="btn btn-primary" value="Submit" />	
	</form>
</div>
<%@include file='../../shared/footer.html'%>
</body>
</html>