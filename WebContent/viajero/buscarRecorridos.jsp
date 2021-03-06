<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="searchTravels" name="titulo"/>
</jsp:include>
<link href="${pageContext.request.contextPath}/resources/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet">
<body>
	
	<jsp:include page="navigation.jsp"/>
	
	<div class="container">
		<div class="jumbotron">
			<h2><s:property value="getText('searchTravels.title')"/></h2>
			<table id="recorridosTable">
				<thead>
					<tr>
						<th>id</th>
						<th><s:property value="getText('default.name')"/></th>
						<th><s:property value="getText('default.owner')"/></th>
						<th><s:property value="getText('default.destination')"/></th>
						<th><s:property value="getText('default.frequency')"/></th>
						<th><s:property value="getText('default.sections')"/></th>
						<th></th>
						<th class="invi"></th>
						<th class="invi"></th>
						<th class="invi"></th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator value="recorridos">
						<tr data-toogle="modal" data-target="#detalleRecorrido">
							<td><s:property value='id'/></td>
							<td><s:property value='nombre'/></td>
							<td><s:property value='propietario.getNombres()'/></td>
							<td><s:property value='evento == null?"FI - UNLP":evento.getNombre()'/></td>
							<td><s:property value="tipo"/></td>
							<td><s:property value="tramo"/></td>
	                    <td>
	                    	<a href="#">
	                    		<span class="glyphicon glyphicon-plus"></span>
	                    	</a>
	                    </td>
	                    <td class="invi"></td>
	                    <td class="invi"></td>
	                    <td class="invi"></td>
						</tr>
					</s:iterator>
				</tbody>
				
				<tfoot>
					<tr>
						<th>id</th>
						<th><s:property value="getText('default.name')"/></th>
						<th><s:property value="getText('default.owner')"/></th>
						<th><s:property value="getText('default.destination')"/></th>
						<th><s:property value="getText('default.frequency')"/></th>
						<th><s:property value="getText('default.sections')"/></th>
						<th></th>
						<th class="invi"></th>
						<th class="invi"></th>
						<th class="invi"></th>				
					</tr>
				</tfoot>
			</table>
	
		</div>
	</div>
	
	<div class="modal fade" id="detalleRecorrido" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  	<div class="modal-dialog modal-lg">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        		<h4 class="modal-title" id="nombre"><s:property value="getText('default.travelDetails')"/></h4>
	      		</div>
	      		<div class="modal-body">
					<div class="row">
						<div class="col-sm-6">
							<div id="map" style="width: 400px;height: 400px;"></div>
						</div>
						<div class="col-sm-6">
							<p><b><s:property value="getText('default.owner')"/>:</b> <span id="propietario"></span></p>
							<p><b><s:property value="getText('default.destination')"/>:</b> <span id="destino"></span></p>
							<p><b><s:property value="getText('default.places')"/>:</b> <span id="lugares"></span></p>
							<p><b><s:property value="getText('default.type')"/>:</b> <span id="tipo"></span></p>
							<p class="fecha"><b><s:property value="getText('default.date')"/>:</b> <span id="fecha"></span></p>
							<p class="dias"><b><s:property value="getText('default.days')"/>:</b> <span id="dias"></span></p>
							<p><b><s:property value="getText('default.sections')"/>:</b> <span id="tramos"></span></p>
							<p class="horaIda"><b><s:property value="getText('default.departureTime')"/>:</b> <span id="horaIda"></span></p>
							<p class="horaVuelta"><b><s:property value="getText('default.arrivalTime')"/>:</b> <span id="horaVuelta"></span></p>
							<p><b><s:property value="getText('default.price')"/>:</b> <span id="precio"></span></p>
							<div class="row" id="participar">
							</div>
						</div>
					</div>
				</div>
	      		<div class="modal-footer">
	        		<button type="button" class="btn btn-default" data-dismiss="modal"><s:property value="getText('default.close')"/></button>
	      		</div>
	    	</div>
	  	</div>
	</div>
	
	
	<jsp:include page="scripts.jsp"/>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>   
	<script src="${pageContext.request.contextPath}/resources/customJS/recorridos.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	 
    
</body>