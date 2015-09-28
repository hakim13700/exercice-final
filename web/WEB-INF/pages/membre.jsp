<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Membre</title>
<link href="../style/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<header>
		<h1>Ajouter un membre</h1>
	</header>
	<c:if test="${not empty error}">
		<label style="color: red;"><c:out value="${error}" /></label>
	</c:if>
		<form:form action="save.html" commandName="membre" method="POST" class="form-horizontal">
		<form:hidden path="id" />

		<div class="form-group">
			<label class="control-label col-sm-2" for="firstName">Nom
				 :</label>
			<div class="col-sm-6">
				<form:input path="firstName" id="firstName"
					class="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="lastName">Prenom
				 :</label>
			<div class="col-sm-6">
				<form:input path="lastName" id="lastName"
					class="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="login">Login
				 :</label>
			<div class="col-sm-6">
				<form:input path="login" id="login"
					class="form-control" />
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="encryptPassword">Mot de passe
				 :</label>
			<div class="col-sm-6">
				<form:input type="password" path="encryptPassword" id="encryptPassword"
					class="form-control" />
			</div>
		</div>

		<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
		<input type="submit" value="valider" class="btn btn-default"/>
		</div>
			</div>
	</form:form>
	
	<br />

	<a href="../demarage.html">Ecran d'acceuil</a>
	
</body>
</html>