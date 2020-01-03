<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ceci est la JSP2</title>
</head>
<body>
<a href = "S1">Ce lien appelle la Servlet 1</a>
<form action = "S1" method="post">
<label> Nom:</label>
<input type = "text" name = "UnCertainNom">
<input type = "submit" value ="C'est aussi un doPost">
</form>

<hr/>

<%=session.getAttribute("UnCertainNom2") %>


</body>
</html>