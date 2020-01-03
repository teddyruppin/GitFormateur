<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../page/header.jsp">
<jsp:param name="title" value="Info ..." />
</jsp:include>

<div class="container">
<h3>Infos techniques sur notre application</h3>
	<div class="row">
	
		<ul>
			<li>Nom du serveur : <%=getServletConfig().getServletName() %></li>
			<li>Context Serveur : <%=getServletConfig().getServletContext().getServerInfo() %></li>
		</ul>
	
	</div>
</div>

<%-- Fin Body --%>		
<jsp:include page="../page/footer.jsp"/>

