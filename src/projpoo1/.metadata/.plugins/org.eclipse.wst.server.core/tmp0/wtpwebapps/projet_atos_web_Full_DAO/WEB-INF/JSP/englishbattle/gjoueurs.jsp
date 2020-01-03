<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%@ page import="net.atos.englishbattle.service.impl.*" %> 
<%@ page import="net.atos.englishbattle.service.*" %>
<%@ page import="net.atos.englishbattle.business.*"%>
 <c:import url="../page/header.jsp">
<c:param name="title" value="Gestion des joueurs" />
</c:import>
<div class="container">
<h3>Liste des joueurs</h3>
	<table class="table">
	<tr>
		<th>Pseudo</th>
		<th>Mail</th>
		<th>Niveau</th>
	</tr>
	<c:forEach items="${SjoueurService.recupererJoueurs()}" var="jo">
	  <tr>
	  	<td><c:out value="${jo.getPseudo()}"/></td>
	  	<td><c:out value="${jo.getEmail()}"/></td>
	  	<td>
	  	 <c:choose>
	  	  <c:when test="${jo.getNiveau().getNom() == 'Débutant'}">Choix cool :) </c:when>
	  	  <c:when test="${jo.getNiveau().getNom() == 'Intermédiaire'}">Choix un peu audacieux :) </c:when>
	  	  <c:when test="${jo.getNiveau().getNom() == 'Expert'}">Houlala il y a du risque ! </c:when>
	  	 </c:choose>
	  	</td>
	  </tr> 
	</c:forEach>
	</table>
</div>

<div class="container">
	<div class="row">
	<div class="col-auto">
		<form action="SaisirJoueur" method="post" class="form" >
			
			<div class="form-group row">
            <label for="Pseudo" class="col-5 col-form-label">Pseudo :</label>
	            <div class="col-7">
	            <input type="text" class="form-control" size="30" placeholder="Entrer votre pseudo"
	            id="Pseudo"
				name="Pseudo" required="required">
				</div>
			</div>
			
			<div class="form-group row">
			<label for="Mdp" class="col-5 col-form-label">Mot de Passe :</label>
				<div class="col-7">
				<input type="password" class="form-control" size="30" placeholder="Entrer votre mot de passe"
				id="Mdp"
				name="Mdp" required="required">
				</div>
			</div>
			
			<div class="form-group row">
				
				<label for="Email" class="col-5 col-form-label">Email :</label>
				<div class="col-7">
				<input type="email" class="form-control" size="30" placeholder="Entrer votre émail"
				id="Email"
				name="Email" required="required">
				</div>
			</div>
			
			<div class="form-group row">
			<label for="Niveau" class="col-5 col-form-label">Choisir un Niveau:</label>
				<div class="col-7">
					<select class="form-control" name="Niveau" id="niveau" size="3"> 
					<c:forEach items="${SniveauService.recupererNiveaux()}" var="niveau">
					  <option value="<c:out value="${niveau.getId()}"/>"><c:out value="${niveau.getNom()}"/></option>
					  	
					</c:forEach>
					</select>
				</div>
			</div>
			
			
			<%-- Bouton Valider pour envoyer à la page TraitementPersonne.jsp nos données --%>
			<input type="submit" value="Valider" class="btn btn-primary" >
			
		</form> 
		</div>
	</div>
</div>



                            

                            
<%-- Fin Body --%>		
<c:import url="../page/footer.jsp"/>

