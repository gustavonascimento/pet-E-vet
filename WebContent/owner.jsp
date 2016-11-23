<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html >
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
<div style="width:200px;margin:auto;">
		<form method = "POST" action='OwnerServlet' name="formAddOwner">
		<label for ="code"> Code: </label>	<br>
		<input 
				type="text" readonly="readonly" name="code"
				value="<c:out value="${owner.code}"/>" /> <br />
		<label for ="name"> Name: </label>	<br>
		<input
				type="text" required="required" pattern="[A-Za-zÀ-ú0-9., -]{5,}+$" name="name" title="Apenas letras maiúsculas e minúsculas"
				value="<c:out value="${owner.name}" />" /> <br />
		<label for ="cpf"> CPF: </label>	<br>
		<input
				type="text" required="required" pattern="[0-9]+$" name="cpf" title="Digite um CPF no formato: xxxxxxxxxxx"
				value="<c:out value="${owner.cpf.cpf}" />" /> <br />
		<label for ="email"> Email: </label>	<br>
		<input
				type="email" required="required" class="input-text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" title="Digite um EMAIL no formato: email@valido.com"
				value="<c:out value="${owner.email.email}" />" /> <br />
		<label for ="telephone"> Telefone: </label>	<br>
		<input
				type="text" required="required" pattern="\([0-9]{2}\)? ?[0-9]{4,5}-[0-9]{4}$" maxlength="15" name="telephone" title="Digite um TELEFONE no formato: (xx) xxxx-xxxx "
				value="<c:out value="${owner.telephone.telephone}" />" /> <br />
		<label for ="password"> Senha: </label>	<br>
		<input
				type="password" name="password"
				value="<c:out value="${owner.password}" />" /> <br /><br />
				
		<input type="submit" value="Submit" />	
	</form>
</div>
<%@include file='shared/footer.html'%>
</body>
</html>