<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Customers</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>Code</th>
				<th>Nome</th>
				<th>Raça</th>
				<th>Idade</th>
				<th>Sexo</th>
				<th colspan=1>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${animalsList}" var="animal">
				<tr>
					<td><c:out value="${animal.code}"/></td>
					<td><c:out value="${animal.name}" /></td>
					<td><c:out value="${animal.breed}" /></td>
					<td><c:out value="${animal.age}" /></td>
					<td><c:out value="${animal.sex}" /></td>
					<td><a href="AnimalServlet?action=deleteAnimal&code=<c:out value="${animal.code}"/>">Delete</a></td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p><a href="AnimalServlet?action=insert&code=<c:out value="${customer.code}"/>">Cadastrar Animal</a></p>		
</body>
</html>