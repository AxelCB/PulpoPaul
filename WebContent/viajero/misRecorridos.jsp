<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="Mis Recorridos" name="titulo"/>
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
						<th class="invi">Propietario</th>
						<th>Destino</th>
						<th>Frecuencia</th>
						<th>Tramos</th>
						<th>Lugares</th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
				<s:if test="%{!recorridos.isEmpty()}">
				<s:iterator value="recorridos">
					<tr>
						<td><s:property value='id'/></td>
						<td><s:property value='nombre'/></td>
						<td class="invi"><s:property value='propietario.getNombres()'/></td>
						<td><s:property value='evento == null?"FI - UNLP":evento.getNombre()'/></td>
						<td><s:property value='tipo'/></td>
						<td><s:property value='tramo'/></td>
						<td><s:property value='lugares'/></td>
						<td>
	                    	<a href="#">
	                    		<span class="glyphicon glyphicon-plus"></span>
	                    	</a>
	                    </td>
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
						<th class="invi">Propietario</th>
						<th>Destino</th>
						<th>Frecuencia</th>
						<th>Tramos</th>
						<th>Lugares</th>
						<th></th>
						<th></th>
						<th></th>
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
	        		<h4 class="modal-title" id="nombre">Detalle del Recorrido</h4>
	      		</div>
	      		<div class="modal-body">
					<div class="row">
						<div class="col-sm-6">
							<div id="map" style="width: 400px;height: 400px;"></div>
						</div>
						<div class="col-sm-6">
							<p><b>Propietario:</b> <span id="propietario"></span></p>
							<p><b>Destino:</b> <span id="destino"></span></p>
							<p><b>Lugares:</b> <span id="lugares"></span></p>
							<p><b>Tipo:</b> <span id="tipo"></span></p>
							<p class="fecha"><b>Fecha:</b> <span id="fecha"></span></p>
							<p class="dias"><b>Dias:</b> <span id="dias"></span></p>
							<p><b>Tramos:</b> <span id="tramos"></span></p>
							<p class="horaIda"><b>Hora ida:</b> <span id="horaIda"></span></p>
							<p class="horaVuelta"><b>Hora vuelta:</b> <span id="horaVuelta"></span></p>
							<p><b>Precio:</b> <span id="precio"></span></p>
							<p><b>Participantes:</b><br><span id="pasajeros"></span></p>
						</div>
					</div>
				</div>
				<div class="modal-footer">
	        		<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
	      		</div>
			</div>
	    </div>
	</div>
	
	<div class="modal fade" id="denuncia" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  	<div class="modal-dialog modal-lg">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        		<h4 class="modal-title">Denunciando a un <span id="tipoDenuncia"></span></h4>
	      		</div>
	      		<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<p><b>Motivo:</b></p>
							<p><textarea id="motivo" placeholder="Detalle el motivo de la denuncia" style="width: 100%;"></textarea></p>	
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="denunciar">Denunciar</button>
	        		<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
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