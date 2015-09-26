<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acceuil</title>
<link href="../../style/bootstrap-3.3.5-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<header>
		<h1>Ajouter un petit dejeuner</h1>
	</header>
	<c:if test="${not empty error}">
		<label style="color: red;"><c:out value="${error}" /></label>
	</c:if>
		<form:form action="save.html" commandName="petitdej" method="POST" class="form-horizontal">
		<form:hidden path="id" />

		<div class="form-group">
			<label class="control-label col-sm-2" for="nom">Nom
				 :</label>
			<div class="col-sm-6">
				<form:input path="nom" id="nom"
					class="form-control" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-sm-2" for="type">Type
				 :</label>
			<div class="col-sm-6">
				<form:input path="type" id="type"
					class="form-control" />
			</div>
		</div>

<!-- 		<div class="form-group"> -->
<!-- 			<label class="control-label col-sm-2" for="membre.id">Membre -->
<!-- 				:</label> -->
<!-- 			<div class="col-sm-6"> -->
<%-- 				<form:select path="membre.id" id="membre" class="form-control"> --%>
<%-- 					<form:options items="${membres}" itemValue="id" itemLabel="firstName" /> --%>
<%-- 				</form:select> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		
		<div class="form-group">
			<label class="control-label col-sm-2" for="commentaire">Commentaire
				 :</label>
			<div class="col-sm-6">
				<form:input path="commentaire" id="commentaire"
					class="form-control" />
			</div>
		</div>

		<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
		<input type="submit" value="valider" class="btn btn-default"/>
		</div>
			</div>
	</form:form>
</body>
</html>