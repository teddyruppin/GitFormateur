<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<%-- 
<jsp:include page="../page/header.jsp">
<jsp:param name="title" value="Info ..." />
</jsp:include>
--%>

<c:import url="../page/header.jsp" >
<c:param name="title" value="Login"></c:param>
</c:import>

<div class="container">
<h3>Infos techniques sur notre application</h3>
	<div class="row">
	
		<ul>
			<li>Nom du serveur : <%=getServletConfig().getServletName()%></li><%--<%=getServletConfig().getServletName() %> --%>
			<li>Context Serveur : <%=getServletConfig().getServletContext().getServerInfo() %></li>
		</ul>
	
	</div>
</div>

<%-- Fin Body --%>		
<%-- <jsp:include page="../page/footer.jsp"/> --%>
<c:import url="../page/footer.jsp"></c:import>

