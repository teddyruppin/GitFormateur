<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="gestionWebPersonne.classes.Personne"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%
		Personne p = new Personne();
		p.setNom("ruppin");
		p.setPrenom("teddy");
		p.setAge(23);
		session.setAttribute("mapersonne", p);
	%>
	<ul>
		<li><%=p.getNom()%></li>
		<li><%=p.getPrenom()%></li>
		<li><%=p.getAge()%></li>
	</ul>
--%>

	<form action="MenuController" method="post">
		<label> Nom : </label>
		<input type="text" value="" name="nom" required>
		<label> Prenom : </label>
		<input type="text" value="" name="prenom" required>
		<label> Age : </label>
		<input type="number" value="18" name="age">
		<button type="submit">Envoie</button>
	</form>

	<a href="index.jsp"> accueil </a>

</body>
</html>