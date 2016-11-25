<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file='shared/head.html'%>
<title>Login</title>
</head>
<body>
<!-- Page Content -->
<br/><br/>
<section class="container" id="login">
	<h1 class="page-header">
		Login
	</h1>
	<form action="LoginServlet" method="POST">
		<input 
		type="email" required="required" class="input-text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" name="email" title="Digite um EMAIL cadastrado no formato: email@valido.com" placeholder="Email" />
		<br/><br/>
		<input 
		type="password" name="password" required="required" pattern="[A-Za-zÀ-ú0-9.,-_%+-@#$*&]+$" maxlength="15" placeholder="Senha" />
		<br/><br/>
		<button type="submit" class="btn btn-primary" id="button-login">Entrar</button>
		<br/> <br/><br/>
	</form>
</section>
<%@include file='shared/footer.html'%>
</body>
</html>