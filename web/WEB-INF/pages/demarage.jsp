<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceuil</title>
<link href="style/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:if test="${not empty error}">
		<label style="color: red;"><c:out value="${error}" /></label>
	</c:if>

	<a href="acceuil.html">new petit dejeuner</a>
	<br /><br />

	<a href="membre/new.html">new membre</a>
	

</body>
</html>