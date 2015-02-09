<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="Bandeja Entrada" name="titulo"/>
</jsp:include>
<link href="${pageContext.request.contextPath}/resources/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet">
<body>
	
	<jsp:include page="navigation.jsp"/>
	
	<div class="container">
		<div class="jumbotron">
			<h2>Bandeja Entrada</h2>
			<table id="mensajesTable">
				<thead>
					<tr>
						<th>id</th>
						<th>Fecha</th>
						<th>Remitente</th>
						<th>Asunto</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
				<s:if test="%{!mensajes.isEmpty()}">
				<s:iterator value="mensajes">
					<tr>
						<td><s:property value='id'/></td>
						<td><s:property value='fecha'/></td>
						<td><s:property value='emisor'/></td>
						<td><s:property value='asunto'/></td>
	                    <td>
	                    	<a href="#">
	                    		<span class="glyphicon glyphicon-eye-open"></span>
	                    	</a>
	                    </td>
	                    <td>
	                    	<a href="#">
	                    		<span class="glyphicon glyphicon-trash"></span>
	                    	</a>
	                    </td>
	                    <td><s:property value="contenido"/></td>
					</tr>
				</s:iterator>
				</s:if>
				</tbody>
				
				<tfoot>
					<tr>
						<th>id</th>
						<th>Fecha</th>
						<th>Remitente</th>
						<th>Asunto</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>
			</table>
			
		</div>
	</div>
	
	
	<jsp:include page="scripts.jsp"/>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>   
	<script src="${pageContext.request.contextPath}/resources/customJS/bandejaEntrada.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	 
    
</body>