<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="Buscar Recorridos" name="titulo"/>
</jsp:include>
<link href="${pageContext.request.contextPath}/resources/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet">
<body>
	
	<jsp:include page="navigation.jsp"/>
	
	<div class="container">
		<div class="jumbotron">
						
		</div>
	</div>
	
	
	<jsp:include page="scripts.jsp"/>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>   
	<script src="${pageContext.request.contextPath}/resources/customJS/misRecorridos.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	 
    
</body>