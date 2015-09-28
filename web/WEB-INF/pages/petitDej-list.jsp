<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des petits déjeuners</title>
<link href="style/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<header>
		<h1>Liste des petits déjeuners</h1>
	</header>
	<c:if test="${not empty error}">
		<label style="color: red;"><c:out value="${error}" /></label>
	</c:if>
		
	<table class="table-striped table-bordered table-condensed ">
		<tbody>
			<tr>
				<th>Nom</th>
<!-- 				<th>Type</th> -->
				<th>Date</th>
				<th>Prix</th>
				<th>Commentaire</th>
			</tr>
			<c:forEach items="${petitdejs}" var="petitdej">
				<tr>
					<td>${petitdej.nom}</td>
<%-- 					<td>${petitdej.type}</td> --%>
					<td>${petitdej.date}</td>
					<td>${petitdej.prix}</td>
					<td>${petitdej.commentaire}</td>
					<td><a href="edit.html?id=${petitdej.id}">éditer</a> <a
						href="delete.html?id=${petitdej.id}">supprimer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />

	<a href="acceuil.html">new petit dejeuner</a>

</body>
</html>