<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceuil</title>
<link href="../style/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${not empty error}">
		<label style="color: red;"><c:out value="${error}" /></label>
	</c:if>
		
	<table class="table-striped table-bordered table-condensed ">
		<tbody>
			<tr>
				<th>Nom</th>
				<th>Prenom</th>
			</tr>
			<c:forEach items="${membres}" var="membre">
				<tr>
					<td>${membre.firstName}</td>
					<td>${membre.lastName}</td>
					<td><a href="edit.html?id=${membre.id}">éditer</a> <a
						href="delete.html?id=${membre.id}">supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />

	<a href="new.html">new membre</a>

</body>
</html>