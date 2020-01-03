<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="projet_atos_web.app.*" %> 
<jsp:include page="../page/header.jsp">
<jsp:param name="title" value="Instanciation du Beans Personne" />
</jsp:include>
	<%-- Début body --%>
	<%
	Personne personne = (Personne)session.getAttribute("personne");
	if(personne == null) personne = new Personne();
	%>
	<p>Nom initial = 
	<%= personne.getNom() %></p>
	<p>Prénom initial = 
	<%= personne.getPrenom() %></p>
	
<%--Fin body --%>
<jsp:include page="../page/footer.jsp"/>