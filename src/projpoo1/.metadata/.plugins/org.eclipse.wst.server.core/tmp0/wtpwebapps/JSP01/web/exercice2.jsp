<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<ol>
		<li><a href='<c:url value="printemps.jsp" />'> printemps </a>
		<li><a href='<c:url value="ete.jsp" />'> ete </a>
		<li><a href='<c:url value="automne.jsp" />'> automne </a>
		<li><a href='<c:url value="hiver.jsp" />'> hiver </a>
	</ol>

<br/><br/><br/> 
<a href='<c:url value="../index.jsp" />'> menu </a>
</body>
</html>