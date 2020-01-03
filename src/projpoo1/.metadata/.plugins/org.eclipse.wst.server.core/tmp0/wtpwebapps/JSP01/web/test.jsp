
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="JSP01.classes.Personne"%>
    
    
	<%
	Personne p = new Personne();
	p.setNom("ruppin");
	p.setPrenom("teddy");
	session.setAttribute("mapersonne", p);
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> choix : <%= request.getParameter("choix") %></h1>
	

	<ul>
		<li> <%= p.getNom() %> </li>
		<li> <%= p.getPrenom() %> </li>
	</ul>
</body>
</html>