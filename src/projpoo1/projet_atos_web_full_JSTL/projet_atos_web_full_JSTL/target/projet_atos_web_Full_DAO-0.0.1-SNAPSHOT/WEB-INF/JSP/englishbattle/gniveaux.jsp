<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="net.atos.englishbattle.service.impl.*" %> 
<%@ page import="net.atos.englishbattle.service.*" %>
<%@ page import="net.atos.englishbattle.business.*"%>
<jsp:include page="../page/header.jsp">
<jsp:param name="title" value="Gestion des Niveaux" />
</jsp:include>
<%
	NiveauService niveauService = new NiveauServiceImpl();
%>

<div class="container">
<ul>
	<%
	for (Niveau niveau : niveauService.recupererNiveaux()) {
		out.println("<li>"+niveau.getId() + " - " + niveau.getNom()+"</li>");
	}
	%>
</ul>
</div>

<%-- Fin Body --%>		
<jsp:include page="../page/footer.jsp"/>

