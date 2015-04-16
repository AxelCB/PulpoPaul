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
			<h2><s:property value="getText('newTravel.title')"/>Nuevo recorrido</h2>
			<div class="row">	
				<form class="form-horizontal col-sm-6" method="post" action="recorridoNuevoAgregar">
					
					<input type="text" class="invi" value="<s:property value='idRecorrido'/>" name="idRecorrido">
				
					<div class="form-group">
						<label class="col-sm-6 control-label" for="nombre"><s:property value="getText('default.name')"/>:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" name="nombre" required value="<s:property value="nombre"></s:property>">
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-6 control-label" for="destino"><s:property value="getText('default.destination')"/>:</label>
						<div class="col-sm-6">
							<select name="destino" class="form-control" id="destino" onchange="cambiarDestino();" required>
								<s:if test="%{destino=='facultad'}">
								<option value="facultad" selected>FI - UNLP</option>
								<option value="evento"><s:property value="getText('default.event')"/></option>								
								</s:if>
								<s:else>
								<option value="facultad">FI - UNLP</option>
								<option value="evento" selected><s:property value="getText('default.event')"/></option>								
								</s:else>

							</select>
						</div>
					</div>
					
					<div class="form-group evento invi">
						<label class="col-sm-6 control-label" for="evento"><s:property value="getText('default.event')"/>:</label>
					  	<div class="col-sm-6">
					  		<select name="evento" class="form-control" id="evento" onchange="cambiarEvento();">
					  			<option value="" data-latlng=""><s:property value="getText('default.choose')"/></option>
							<s:iterator value="eventos">
								<s:if test="%{evento==id}">
								<option value="<s:property value='id'/>" data-latlng="<s:property value='latLng'/>" selected>
								</s:if>
								<s:else>
								<option value="<s:property value='id'/>" data-latlng="<s:property value='latLng'/>">
								</s:else>
									<s:property value='nombre'/>
								</option>
							</s:iterator>
					  		</select>
					  	</div>
					</div>
					
					<div class="form-group frecuencia">
						<label class="col-sm-6 control-label" for="frecuencia"><s:property value="getText('default.frequency')"/>:</label>
					  	<div class="col-sm-6">
					  		<select name="frecuencia" class="form-control" id="frecuencia" onchange="cambiarFrecuencia();" required>
					  			<s:if test="%{frecuencia=='DIARIO'}"><option value="diario" selected><s:property value="getText('default.daily')"/></option></s:if>
					  			<s:else><option value="diario"><s:property value="getText('default.daily')"/></option></s:else>
					  			
					  			<s:if test="%{frecuencia=='PERIODICO'}"><option value="periodico" selected><s:property value="getText('default.periodic')"/></option></s:if>
					  			<s:else><option value="periodico"><s:property value="getText('default.periodic')"/></option></s:else>
					  			
					  			<s:if test="%{frecuencia=='PUNTUAL'}"><option value="puntual" selected><s:property value="getText('default.oneTime')"/></option></s:if>
					  			<s:else><option value="puntual"><s:property value="getText('default.oneTime')"/></option></s:else>
					  		</select>
					  	</div>
					</div>
					
					<div class="form-group periodico invi">
						<label class="col-sm-6 control-label" for="dias">Elija los d&iacute;as:</label>
					  	<div class="col-sm-6">
					  		<div class="row">
					  			<div class="col-sm-6">Lunes</div>
					  			<div class="col-sm-1">
					  				<s:if test="%{'Lunes' in dias}"><input type="checkbox" name="dias" value="Lunes" checked></s:if>
					  				<s:else><input type="checkbox" name="dias" value="Lunes"></s:else>
					  			</div>
					  		</div>
					  		<div class="row">
					  			<div class="col-sm-6">Martes</div>
					  			<div class="col-sm-1">
					  				<s:if test="%{'Martes' in dias}"><input type="checkbox" name="dias" value="Martes" checked></s:if>
					  				<s:else><input type="checkbox" name="dias" value="Martes"></s:else>
					  			</div>
					  		</div>
						    <div class="row">
					  			<div class="col-sm-6">Miercoles</div>
					  			<div class="col-sm-1">
					  				<s:if test="%{'Miercoles' in dias}"><input type="checkbox" name="dias" value="Miercoles" checked></s:if>
					  				<s:else><input type="checkbox" name="dias" value="Miercoles"></s:else>
					  			</div>
					  		</div> 
							<div class="row">
					  			<div class="col-sm-6">Jueves</div>
					  			<div class="col-sm-1">
					  				<s:if test="%{'Jueves' in dias}"><input type="checkbox" name="dias" value="Jueves" checked></s:if>
					  				<s:else><input type="checkbox" name="dias" value="Jueves"></s:else>
					  			</div>
					  		</div>
					  		<div class="row">
					  			<div class="col-sm-6">Viernes</div>
					  			<div class="col-sm-1">
					  				<s:if test="%{'Viernes' in dias}"><input type="checkbox" name="dias" value="Viernes" checked></s:if>
					  				<s:else><input type="checkbox" name="dias" value="Viernes"></s:else>
					  			</div>
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
					  			<s:if test="%{idaOVuelta=='IDA'}"><option value="ida" selected>Ida</option></s:if>
					  			<s:else><option value="ida">Ida</option></s:else>
					  			
					  			<s:if test="%{idaOVuelta=='VUELTA'}"><option value="vuelta" selected>Vuelta</option></s:if>
					  			<s:else><option value="vuelta">Vuelta</option></s:else>
					  			
					  			<s:if test="%{idaOVuelta=='IDAYVUELTA'}"><option value="idaYVuelta" selected>Ida y vuelta</option></s:if>
					  			<s:else><option value="idaYVuelta">Ida y vuelta</option></s:else>
					  		</select>
					  	</div>
					</div>
					
					<div class="form-group ida">
						<label class="col-sm-6 control-label" for="partida">Hora de Partida:</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="partida" class="form-control" id="partida" value="<s:property value='partida'/>"required onchange="formatTime(this);" onblur="checkHora(this);">
					  	</div>
					</div>
					
					<div class="form-group vuelta invi">
						<label class="col-sm-6 control-label" for="regreso">Hora de Regreso:</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="regreso" class="form-control" id="regreso" value="<s:property value='regreso'/>" onchange="formatTime(this);" onblur="checkHora(this);">
					  	</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-6 control-label" for="asientos">Asientos:</label>
					  	<div class="col-sm-6">
					  		<input type="number" name="asientos" class="form-control" required value="<s:property value='asientos'/>">
				  		</div>
					</div>
					
					<div class="form-group">
						<label class="col-sm-6 control-label" for="precio">Precio por Persona:</label>
						<div class="col-sm-6">
							<input type="number" name="precio" class="form-control" step="0.1" required value="<s:property value='precio'/>">
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
	<script>
		function ini(){
			window.startPoint = "<s:property value='start'/>";
			window.endPoint = "<s:property value='end'/>";
			var waypoints = "<s:property value='waypoints'/>";
			window.waypointsOints = [];
			waypoints = waypoints.substring(1, waypoints.length - 1);
			waypoints = waypoints.split(", ");
			for(i = 0; i < waypoints.length ; i=i+2){
    			var lat = waypoints[i].substring(1, waypoints[i].length);
    			var lng = waypoints[i+1].substring(0, waypoints[i+1].length - 1);
    			window.waypointsOints.push({
    				location: new google.maps.LatLng(parseFloat(lat), parseFloat(lng)),
    				stopover: true
    			});
    		}
		}
		ini();
	</script>
	<script src="${pageContext.request.contextPath}/resources/customJS/nuevoRecorrido.js"></script>
	
</body>
</html>