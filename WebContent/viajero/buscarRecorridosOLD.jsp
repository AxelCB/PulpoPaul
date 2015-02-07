<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
	<link href="../resources/datepicker/css/datepicker.css" rel="stylesheet">
	<link href="../resources/customCSS/CustomViajeroStyle.css" rel="stylesheet">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Buscar Recorrido </title>
</head>
<body>
	
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
	
	<div class="container">
		<div class="jumbotron">
			<h2>Buscar recorridos</h2>
			<button type="button" class="btn btn-default" name="buscar" onClick="toogleBusqueda();">Buscar    <span class="glyphicon glyphicon-search"></span></button>
			<div class="row" id="parametros">
				<form class="form-horizontal" method="post" >
					<div class="form-group">
						<label class="col-sm-2 control-label" for="tipo">Tipo:</label>
						<div class="col-sm-4">
							<select name="tipo" class="form-control">
								<option value="1">Pasajero</option>
								<option value="2">Conductor</option>
								<option value="3">Ambos</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="desde">Desde:</label>
					  	<div class="col-sm-4">
							<input type="text" name="desde" class="form-control" required placeholder=" 00.00000, 00.00000">
					  	</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="hasta">Hasta:</label>
					  	<div class="col-sm-4">
							<select name="hasta" class="form-control">
								<option value="1">Facultad de Informatica</option>
								<option value="2">Un evento</option>
								<option value="3">Otro evento</option>
								<option value="4">Mas eventos</option>
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
						    <div class="input-append date" id="fechaPuntual">
				    			<input type="date" class="form-control" name="fechaPuntual">
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
				</form>
			</div>
			<br>
			<div class="row" id="viajes">
				<h2>Ultimos recorridos</h2>
				<div class="list-group">
					<a href="#" class="list-group-item">
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						A la facu desde un lado 
					</a>
					<a href="#" class="list-group-item active">
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						A la facu desde otro lado
					</a>
					<a href="#" class="list-group-item">
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						Desde la facu a berisso
					</a>
					<a href="#" class="list-group-item">
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						Desde la facu a ensenada
					</a>
					<a href="#" class="list-group-item">
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star"></span>
						<span class="glyphicon glyphicon-star-empty"></span>
						Congreso CACIC
					</a>
				</div>
				<div class="col-sm-6" id="map_canvas" style="width: 500px;height: 400px;"></div>
				<div class="col-sm-6">
					<p>Informacion del viaje</p>
					<h4>Desde: Un lado</h4>
					<h4>Hasta: La facu</h4>
					<h4>Tipo: Diario - Ida y vuelta</h4>
					<h4>Hora ida: 08:00hs</h4>
					<h4>Hora vuelta: 14:00hs</h4>
					<h4>Lugares disponibles: 3</h4>
					<button type="button" class="btn btn-default">Enviar Peticion    <span class="glyphicon glyphicon-ok"></span></button>
				</div>
				
			</div>
		</div>	
	</div>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="../resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="../resources/customJS/nuevoRecorridoSelects.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js"></script>
    <script src="../resources/customJS/googleMapsInitialization.js"></script>
</body>