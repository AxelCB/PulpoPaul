<%@page import="org.apache.struts2.components.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="header.jsp">
	<jsp:param value="Agregar Recorrido" name="titulo"/>
</jsp:include>
	<link href="${pageContext.request.contextPath}/resources/datepicker/css/datepicker.css" rel="stylesheet">

<body>

	<jsp:include page="navigation.jsp"/>
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">	
			<h2>Nuevo recorrido</h2>
			<div class="row">	
				<form class="form-horizontal col-sm-6" method="post" action="recorridoNuevoAgregar">
				
					<div class="form-group">
						<label class="col-sm-6 control-label" for="nombre">Nombre:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="nombre" required>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-6 control-label" for="destino">Destino:</label>
						<div class="col-sm-6">
							<select name="destino" class="form-control" id="destino" onchange="cambiarDestino();" required>
								<option value="facultad">FI - UNLP</option>
								<option value="evento">Evento</option>
							</select>
						</div>
					</div>
					
					<div class="form-group evento invi">
						<label class="col-sm-6 control-label" for="evento">Evento:</label>
					  	<div class="col-sm-6">
					  		<select name="evento" class="form-control" id="evento" onchange="cambiarEvento();">
					  			<option value="" data-latlng="">Seleccionar</option>
							<s:iterator value="eventos">
								<option value="<s:property value='id'/>" data-latlng="<s:property value='latLng'/>">
									<s:property value='nombre'/>
								</option>
							</s:iterator>
					  		</select>
					  	</div>
					</div>
					
					<div class="form-group frecuencia">
						<label class="col-sm-6 control-label" for="frecuencia">Frecuencia:</label>
					  	<div class="col-sm-6">
					  		<select name="frecuencia" class="form-control" id="frecuencia" onchange="cambiarFrecuencia();" required>
					  			<option value="diario">Diario</option>
					  			<option value="periodico">Peri&oacute;dico</option>
					  			<option value="puntual">Puntual</option>
					  		</select>
					  	</div>
					</div>
					
					<div class="form-group periodico invi">
						<label class="col-sm-6 control-label" for="dias">Elija los d&iacute;as:</label>
					  	<div class="col-sm-6">
					  		<div class="row">
					  			<div class="col-sm-6">Lunes</div>
					  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Lunes"></div>
					  		</div>
					  		<div class="row">
					  			<div class="col-sm-6">Martes</div>
					  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Martes"></div>
					  		</div>
						    <div class="row">
					  			<div class="col-sm-6">Miercoles</div>
					  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Miercoles"></div>
					  		</div> 
							<div class="row">
					  			<div class="col-sm-6">Jueves</div>
					  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Jueves"></div>
					  		</div>
					  		<div class="row">
					  			<div class="col-sm-6">Viernes</div>
					  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Viernes"></div>
					  		</div>			     	
						</div>
					</div>
					
					<div class="form-group puntual invi">
						<label class="col-sm-6 control-label" for="fechaPuntual">Fecha:</label>
					  	<div class="col-sm-6">
							<div class="input-group">
							  <input type="text" class="form-control" id="fechaPuntual" name="fecha" value='<s:date name="fechaActual" format="dd-MM-yyy"/>'>
							  <span class="input-group-addon">
							  	<span class="glyphicon glyphicon-calendar"></span>
							  </span>							
							</div>
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-6 control-label" for="idaOVuelta">Tramos:</label>
					  	<div class="col-sm-6">
					  		<select name="idaOVuelta" class="form-control" id="idaOVuelta" onchange="cambiarIdaOVuelta();" required>
					  			<option value="ida">Ida</option>
					  			<option value="vuelta">Vuelta</option>
					  			<option value="idaYVuelta">Ida y vuelta</option>
					  		</select>
					  	</div>
					</div>
					
					<div class="form-group ida">
						<label class="col-sm-6 control-label" for="partida">Hora de Partida:</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="partida" class="form-control" id="partida" required>
					  	</div>
					</div>
					
					<div class="form-group vuelta invi">
						<label class="col-sm-6 control-label" for="regreso">Hora de Regreso:</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="regreso" class="form-control" id="regreso">
					  	</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-6 control-label" for="asientos">Asientos:</label>
					  	<div class="col-sm-6">
					  		<input type="number" name="asientos" class="form-control" required>
				  		</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-6 control-label" for="precio">Precio por Persona:</label>
						<div class="col-sm-6">
							<input type="number" name="precio" class="form-control" step="0.1" required>
						</div> 
					</div>
					
					<div class="invi" id="puntos"></div>
					
					<div class="row">
						<input type="submit" class="btn btn-default col-sm-4 col-sm-offset-8" id="agregar" value="Agregar">
					</div>
				</form>
				
				<div class="col-sm-6">
					<div id="map" style="width: 500px;height: 400px;"></div>
					<div class="row">
						<div class="form-group">
							<input type="submit" class="btn btn-default col-sm-4 col-sm-offset-8" value="Borrar último punto" onClick="removeHito();">
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
	
	<jsp:include page="scripts.jsp"/>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
	<script src="${pageContext.request.contextPath}/resources/datepicker/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/resources/customJS/nuevoRecorrido.js"></script>
	
</body>
</html>