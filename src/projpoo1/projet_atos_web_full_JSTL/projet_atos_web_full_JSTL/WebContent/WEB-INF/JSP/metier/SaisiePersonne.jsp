<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<c:import url="../page/header.jsp">
<c:param name="title" value="Saisie d'une Personne" />
</c:import >
<%-- Début body --%>
<%--Balise form pour pouvoir gérer des saisies en HTML --%>
<div class="container">
	<div class="row">
		<form action="TraitementPersonne" method="post">
			<%-- Il faut mettre le nom du champ de saisie dans name="" --%>
			<label>Nom :</label><input type="text" size="15" name="nom">
			<br/>	
			<label>Prénom :</label><input type="text" size="15" name="prenom">
			<br/>
			<%-- Bouton Valider pour envoyer à la page TraitementPersonne.jsp nos données --%>
			<input type="submit" value="Valider">
		</form> 
	</div>
</div>
	

<%-- Fin Body --%>		
<c:import url="../page/footer.jsp"/>