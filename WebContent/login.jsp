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
		<input type="text" name="email" placeholder="Email" />
		<br/><br/>
		<input type="password" name="password" placeholder="Senha" />
		<br/><br/>
		<button type="submit" class="btn btn-primary" id="button-login">Entrar</button>
		<br/> <br/><br/>
	</form>
</section>
<%@include file='shared/footer.html'%>
</body>
</html>