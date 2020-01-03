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
	<%
		Personne op = (Personne) session.getAttribute("mapersonne");
	%>
	<ul>
		<li><a href="MenuController?choix=1"> Creer une personne </a></li>
		<li><a href="MenuController?choix=2"> Afficher la personne </a></li>
		<li><a href="MenuController?choix=3"> Supprimer la personne </a></li>
	</ul>
</body>
</html>