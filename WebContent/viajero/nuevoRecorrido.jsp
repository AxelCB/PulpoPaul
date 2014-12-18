<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<!-- 	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- 	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet"> -->
	<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="../resources/datepicker/css/datepicker.css" rel="stylesheet">
	<link href="../resources/customCSS/CustomViajeroStyle.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Agregar Recorrido </title>
</head>
<body>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
<!-- 	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script> -->
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../resources/datepicker/js/bootstrap-datepicker.js"></script>
	<script src="../resources/customJS/nuevoRecorridoSelects.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js"></script>
    <script src="../resources/customJS/googleMapsInitialization.js"></script>

	<!-- Comienzo barra de navegacion del traveler -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
		    	<a class="navbar-brand" href="#">Nombre Viajero</a>
	    	</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/PulpoPaul/viajero/buscarRecorridos.jsp">Buscar Recorridos</a></li>
					<li class="dropdown">
			        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Recorridos Propios<span class="caret"></span></a>
			       		<ul class="dropdown-menu" role="menu">
				            <li><a href="/PulpoPaul/viajero/nuevoRecorrido.jsp">Nuevo</a></li>
				            <li><a href="/PulpoPaul/viajero/misRecorridos.jsp">Ver</a></li>
				    	</ul>
			        </li>
					<li class="dropdown">
			        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Mensajes<span class="caret"></span></a>
			       		<ul class="dropdown-menu" role="menu">
				            <li><a href="/PulpoPaul/viajero/enviarMensaje.jsp">Enviar</a></li>
				            <li><a href="/PulpoPaul/viajero/verMensajes.jsp">Bandeja de entrada</a></li>
				    	</ul>
			    	</li>
			    	<li><a href="/PulpoPaul/viajero/historial.jsp">Historial</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href='<s:url action="logout"/>'>Log Out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Fin barra de navegacion del traveler -->
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">	
			<h2>Agregando recorrido</h2>
				
			<form class="form-horizontal" method="post">
				<div class="form-group">
					<label class="col-sm-2 control-label" for="rolViaje">Seleccione una de las opciones:</label>
				  	<div class="col-sm-4">
				  		<select name="rolViaje" class="form-control" id="rolViaje" onchange="cambiarRolViaje();">
				  			<option value="pasajero">Pasajero</option>
				  			<option value="conductor">Conductor</option>
				  			<option value="ambos">Ambos</option>
				  		</select>
				  	</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="frecuenciaViaje">Seleccione:</label>
				  	<div class="col-sm-4">
				  		<select name="frecuenciaViaje" class="form-control" id="frecuenciaViaje" onchange="cambiarFrecuencia();">
				  			<option value="diario" selected="selected">Diario</option>
				  			<option value="periodico">Peri&oacute;dico</option>
				  			<option value="puntual">Puntual</option>
				  		</select>
				  	</div>
				</div>
				<div class="form-group periodico">
					<label class="col-sm-2 control-label" for="dias">Elija los d&iacute;as:</label>
				  	<div class="col-sm-4">
				  		<div class="row">
				  			<div class="col-sm-3">Lunes</div>
				  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Lunes"></div>
				  		</div>
				  		<div class="row">
				  			<div class="col-sm-3">Martes</div>
				  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Martes"></div>
				  		</div>
					    <div class="row">
				  			<div class="col-sm-3">Miercoles</div>
				  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Miercoles"></div>
				  		</div> 
						<div class="row">
				  			<div class="col-sm-3">Jueves</div>
				  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Jueves"></div>
				  		</div>
				  		<div class="row">
				  			<div class="col-sm-3">Viernes</div>
				  			<div class="col-sm-1"><input type="checkbox" name="dias" value="Viernes"></div>
				  		</div>			     	
					</div>
				</div>
				<div class="form-group puntual">
					<label class="col-sm-2 control-label" for="fechaPuntual">Fecha:</label>
				  	<div class="col-sm-4">
						<div class="input-append date" id="fechaPuntual" data-date="12-02-2012" data-date-format="dd-mm-yyyy">
							<input class="span2" size="16" type="text" value="12-02-2012">
							<span class="add-on"><i class="icon-th"></i></span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="idaOVuelta">Seleccione:</label>
				  	<div class="col-sm-4">
				  		<select name="idaOVuelta" class="form-control" id="idaOVuelta" onchange="cambiarIdaOVuelta();">
				  			<option value="ida">Ida</option>
				  			<option value="vuelta">Vuelta</option>
				  			<option value="idaYVuelta">Ida y vuelta</option>
				  		</select>
				  	</div>
				</div>
				<div class="form-group ida">
					<label class="col-sm-2 control-label" for="partida">Hora de Partida:</label>
				  	<div class="col-sm-4">
				  		<input type="time" name="partida" class="form-control" required>
				  	</div>
				</div>
				<div class="form-group vuelta">
					<label class="col-sm-2 control-label" for="regreso">Hora de Regreso:</label>
				  	<div class="col-sm-4">
				  		<input type="time" name="regreso" class="form-control" required>
				  	</div>
				</div>
				<div class="form-group asientos">
					<label class="col-sm-2 control-label" for="asientos">Cantidad de asientos disponibles:</label>
				  	<div class="col-sm-4">
				  		<input type="number" name="asientos" class="form-control" required>
				  	</div>
				</div>
				<div id="map_canvas" style="width: 500px;height: 400px;"></div>
			</form>
		</div>
	</div>
</body>
</html>