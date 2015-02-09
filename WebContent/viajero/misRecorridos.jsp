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
			<h2>Mis Recorridos</h2>
			<table id="recorridosTable">
				<thead>
					<tr>
						<th>id</th>
						<th>Nombre</th>
						<th>Destino</th>
						<th>Frecuencia</th>
						<th>Tramos</th>
						<th>Lugares</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
				<s:if test="%{!recorridos.isEmpty()}">
				<s:iterator value="recorridos">
					<tr data-toogle="modal" data-target="#detalleRecorrido">
						<td><s:property value='id'/></td>
						<td><s:property value='nombre'/></td>
						<td><s:property value='evento == null?"FI - UNLP":evento.getNombre()'/></td>
						<td><s:property value='tipo'/></td>
						<td><s:property value='tramo'/></td>
						<td><s:property value='lugares'/></td>
	                    <td>
	                    	<a href="#">
	                    		<span class="glyphicon glyphicon-pencil"></span>
	                    	</a>
	                    </td>
	                    <td>
	                    	<a href="#">
	                    		<span class="glyphicon glyphicon-trash"></span>
	                    	</a>
	                    </td>
					</tr>
				</s:iterator>
				</s:if>
				</tbody>
				
				<tfoot>
					<tr>
						<th>id</th>
						<th>Nombre</th>
						<th>Destino</th>
						<th>Frecuencia</th>
						<th>Tramos</th>
						<th>Lugares</th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>
			</table>
			
		</div>
	</div>
	
	
	<jsp:include page="scripts.jsp"/>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>   
	<script src="${pageContext.request.contextPath}/resources/customJS/misRecorridos.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	 
    
</body>