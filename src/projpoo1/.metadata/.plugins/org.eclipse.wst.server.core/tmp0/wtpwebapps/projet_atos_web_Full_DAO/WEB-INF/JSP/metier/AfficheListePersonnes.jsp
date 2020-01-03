<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%@ page import="projet_atos_web.app.*"%>
<c:import url="../page/header.jsp">
<c:param name="title" value="Liste des Personnes" />
</c:import >
	<%-- Début body --%>
	<h3>Listes des Personnes</h3>
	<ol>
		<%
		    ListePersonne listepersonnes = (ListePersonne)session.getAttribute("listepersonne");
			if(listepersonnes == null ) listepersonnes = new ListePersonne();
			for(Personne 
					p:listepersonnes.getPersonnes()) {
				out.append("<li>"+p.getNom()+
						"-"+p.getPrenom()+"</li>");
			}
		%>
	</ol>
	<%--Fin body --%>
<c:import url="../page/footer.jsp"/>