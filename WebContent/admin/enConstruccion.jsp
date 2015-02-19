<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="FuncionalidadNoImplementada" name="titulo"/>
</jsp:include>
<body>

	<jsp:include page="navigation.jsp"/>
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2>Funcionalidad No Implementada</h2>
			<br>
			<img src="${pageContext.request.contextPath}/resources/enConstruccion.jpg">
		</div>
	</div>

	<jsp:include page="scripts.jsp"/>	
</body>
</html>