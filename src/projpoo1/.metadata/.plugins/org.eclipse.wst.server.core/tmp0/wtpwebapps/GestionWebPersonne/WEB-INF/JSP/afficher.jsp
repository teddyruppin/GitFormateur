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

		if (op == null) {
			out.append("pas de personnes");
		} else {
	%>


	<ul>
		<li><%=op.getNom()%></li>
		<li><%=op.getPrenom()%></li>
		<li><%=op.getAge()%></li>
	</ul>

	<%
		}
	%>

	<a href="index.jsp"> accueil </a>

</body>
</html>