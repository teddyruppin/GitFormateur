<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%@ page import="net.atos.englishbattle.service.impl.*" %> 
<%@ page import="net.atos.englishbattle.service.*" %>
<%@ page import="net.atos.englishbattle.business.*"%>
 <jsp:include page="../page/header.jsp">
<jsp:param name="title" value="Gestion des joueurs" />
</jsp:include>
<div class="container">
<h3>Liste des joueurs</h3>
	<table class="table">
	<tr>
		<th>Pseudo</th>
		<th>Mail</th>
	</tr>
	<c:forEach items="${SjoueurService.recupererJoueurs()}" var="jo">
	  <tr>
	  	<td><c:out value="${jo.getPseudo()}"/></td>
	  	<td><c:out value="${jo.getEmail()}"/></td>
	  </tr> 
	</c:forEach>
	</table>
</div>

<div class="container">
	<div class="row">
		<form action="SaisirJoueur" method="post">
			
			<label>Pseudo :</label><input type="text" size="15" 
			name="Pseudo" required="required">
			<br/>	
			<label>Mot de Passe :</label><input type="password" size="15" 
			name="Mdp" required="required">
			<br/>
			<label>Email :</label><input type="email" size="15" 
			name="Email" required="required">
			<br/>
			<%-- Bouton Valider pour envoyer à la page TraitementPersonne.jsp nos données --%>
			<input type="submit" value="Valider">
		</form> 
	</div>
</div>

<%-- Fin Body --%>		
<jsp:include page="../page/footer.jsp"/>

