<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html>
<html lang = "pt-br">
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
</head>
<body>
<%@include file='shared/navbar.html'%>
<br></br>
<br></br>

<div style="width:200px;margin:auto;">
	<form method = "POST" action='CustomerServlet' name="formAddCustomer">
		<label for ="code"> Code: </label>	<br>
	 	<input 
				type="text" readonly="readonly" name="code"	
				value="<c:out value="${customer.code}"/>" /> <br />
		<label for ="name"> Nome :	</label><br>
		<input
				id = "name" type="text" required="required" pattern="[A-Za-zÀ-ú0-9., -]{5,}+$" name="name" title="Apenas letras maiúsculas e minúsculas"
				value="<c:out value="${customer.name}" />" /> <br />
		<label for ="cpf"> 	CPF : </label><br>
		<input
				type="text" required="required" pattern="[0-9]+$" name="cpf" title="Digite um CPF no formato: xxxxxxxxxxx"
				value="<c:out value="${customer.cpf.cpf}" />" /> <br />
		<label for ="email"> 	Email :	</label><br>
		<input
				type="email" required="required" class="input-text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" title="Digite um EMAIL no formato: email@valido.com"
				value="<c:out value="${customer.email.email}" />" /> <br />
		<label for ="Telephone"> 	Telefone :	</label><br>
		<input
				type="text" required="required" pattern="\([0-9]{2}\)?\s?[0-9]{4,5}-[0-9]{4}$" maxlength="15" name="telephone" title="Digite um TELEFONE no formato: (xx) xxxx-xxxx"
				value="<c:out value="${customer.telephone.telephone}" />" /> <br />
		<label for ="dob"> 	Data de Nascimento :	</label><br>
		<input
				type="date" required="required" name="date_of_birth"
				value="<c:out value="${customer.date_of_birth}" />" /> <br />
		<label for ="address"> 	Endereço :	 </label><br>
		<input
				type="text" required="required" name="address" title="Apenas caracteres alfanuméricos"
				value="<c:out value="${customer.address.address}" />" /> <br />
		<label for ="neighborhood"> 	Bairro :	</label><br>
		<input
				type="text" required="required" name="neighborhood" title="Apenas caracteres alfanuméricos"
				value="<c:out value="${customer.address.neighborhood}" />" /> <br />
		<label for ="city"> 	Cidade : </label><br>
		<input
				type="text" required="required" name="city" title="Apenas letras"
				value="<c:out value="${customer.address.city}" />" /> <br />
		<label for ="cep"> 	CEP :	 </label><br>
		<input
				type="text" required="required"  pattern="[0-9]+$" name="cep" title="Apenas caracteres numéricos"
				value="<c:out value="${customer.address.cep}" />" /> <br /><br>
				
		<button type="submit"> Cadastrar</button>	
	</form>
	</div>
	<br><br><br><br><br><br>
<%@include file='shared/footer.html'%>
</body>
</html>