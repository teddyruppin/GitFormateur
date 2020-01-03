<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<%--
<jsp:include page="../page/header.jsp">
<jsp:param name="title" value="Login" />
</jsp:include>
--%>

<c:import url="../page/header.jsp" >
<c:param name="title" value="Login"></c:param>
</c:import>


<%-- Début body --%>
<%--Balise form pour pouvoir gérer des saisies en HTML --%>
<div class="container">
	<div class="row">
		<form action="Login" method="post">
			
			<label>Login :</label><input type="text" size="15" 
			name="login" required="required">
			<br/>	
			<label>Mdp :</label><input type="password" size="15" 
			name="mdp" required="required">
			<br/>
			<%-- Bouton Valider pour envoyer à la page TraitementPersonne.jsp nos données --%>
			<input type="submit" value="Valider">
		</form> 
	</div>
</div>
	

<%-- Fin Body 		
<jsp:include page="../page/footer.jsp"/>
--%>
<c:import url="../page/footer.jsp"/>