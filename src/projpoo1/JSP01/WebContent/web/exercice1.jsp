<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href='<c:url value="css/bootstrap.min.css" />' rel="stylesheet" />
<link href='<c:url value="css/style.css" />' rel="stylesheet" />

<title>Exercice 1</title>
</head>
<body>


	<div>

		<h2>Exercice 1</h2>

		<table border>

			<colgroup>

				<col width=90>

				<col width=300>

			</colgroup>

			<tr>
				<th>Numéro ordre</th>
				<th>Désignation</th>
			</tr>

			<c:forEach begin="1" end="20" var="i">
				<tr>
					<th><c:out value="${i}" /></th>
					<th><c:out value='${"Bonjour"}' /></th>
				</tr>
			</c:forEach>



		</table>
	</div>

<a href='<c:url value="../index.jsp" />'> menu </a>
</body>
</html>