<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%@ page import="net.atos.englishbattle.service.impl.*" %> 
<%@ page import="net.atos.englishbattle.service.*" %>
<%@ page import="net.atos.englishbattle.business.*"%>
<c:import url="../page/header.jsp">
<jsp:param name="title" value="Gestion des Verbes" />
</c:import >
<%
VerbeServiceImpl valeur = null;
pageContext.setAttribute("valeur", new VerbeServiceImpl());
%>
<div class="container">
	<c:if test="${SverbeService==null}"> 
	<span  class="col-form-label">La session "SverbeService" n'existe pas !</span>
	
	 
	</c:if>
	<%-- le else n'existe pas  --%>
	<c:if test="${SverbeService!=null}"> 
	<span  class="col-form-label">La session "SverbeService" existe maintenant !</span>
		 
	</c:if>

	<%-- # rappel la page --%>
	<a class="btn btn-info" href="Menu?choix=52">Reload</a>
	<c:choose>
	<c:when test="${SverbeService==null}"><c:set scope="session" var="SverbeService" value="${valeur}"/></c:when>
	<c:when test="${SverbeService!=null}"><c:remove scope="session" var="SverbeService" /></c:when>
	</c:choose>
</div>




<%-- Fin Body --%>		
<c:import url="../page/footer.jsp"/>

