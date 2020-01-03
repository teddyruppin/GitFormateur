<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>PAGE D'ACCUEIL</h1>
	<div class="row">
		<div class="col-auto">
			<form action="SaisirUtil" method="post" class="form">
				<label for="Nom" class="col-6 col-form-label"> Pseudo : </label> 
				<div class="col-7">
				<input type="text" class="form-control" size="50"
					placeholder="Nom d'utilisateur" id="Mdp" name="Mdp" required>
				</div>
				
				<label for="Mdp" class="col-6 col-form-label">Mot de Passe :</label>
				<div class="col-7">
				<input type="password" class="form-control" size="50" placeholder="Entrer votre mot de passe"
				id="Mdp"
				name="Mdp" required>
				</div>

				<br />
				<input type="submit" value="Valider" class="btn btn-primary">


			</form>
		</div>
	</div>



	<br />
	<br />
	<a href='<c:url value="../index.jsp" />'> menu </a>
</body>
</html>