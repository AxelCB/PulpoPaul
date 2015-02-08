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
			<h2>Buscar recorridos</h2>
			<table id="recorridosTable">
				<thead>
					<tr>
						<th>id</th>
						<th>Nombre Recorrido</th>
						<th>Nombre Propietario</th>
						<th>Destino</th>
					</tr>
				</thead>
				
				<tbody>
					<s:iterator value="recorridos">
						<tr data-toogle="modal" data-target="#detalleRecorrido">
							<td><s:property value='id'/></td>
							<td><s:property value='nombre'/></td>
							<td><s:property value='propietario.getNombres()'/></td>
							<td><s:property value='evento == null?"FI - UNLP":evento.getNombre()'/></td>
						</tr>
					</s:iterator>
				</tbody>
				
				<tfoot>
					<tr>
						<th>id</th>
						<th>Nombre Recorrido</th>
						<th>Nombre Propietario</th>
						<th>Destino</th>				
					</tr>
				</tfoot>
			</table>
			
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#detalleRecorrido" onClick="initialize();">
		  Launch demo modal
		</button>
		</div>
	</div>
	
	<div class="modal fade" id="detalleRecorrido" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  	<div class="modal-dialog modal-lg">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        		<h4 class="modal-title" id="myModalLabel">Detalle del Recorrido</h4>
	      		</div>
	      		<div class="modal-body">
					<div class="row">
						<div class="col-sm-6">
							<div id="map" style="width: 400px;height: 400px;"></div>
						</div>
						<div class="col-sm-6">
							<p>Nombre: ########</p>
							<p>Destino: ########</p>
							<p>Propietario: ########</p>
							<p>Tipo: Diario - Ida y Vuelta</p>
							<p>Hora ida: ########</p>
							<p>Hora vuelta: ########</p>
							<p>Precio: ########</p>
							<div class="row">
								<button type="button" class="btn btn-default col-sm-offset-8 col-sm-3">Participar!</button>
							</div>
						</div>
					</div>
				</div>
	      		<div class="modal-footer">
	        		<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	      		</div>
	    	</div>
	  	</div>
	</div>
	
	
	<jsp:include page="scripts.jsp"/>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>   
	<script src="${pageContext.request.contextPath}/resources/customJS/buscarRecorridos.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	 
    
</body>