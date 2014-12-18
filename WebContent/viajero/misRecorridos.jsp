<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mis Recorridos</title>
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
					<li><a href="buscarRecorridos.jsp">Buscar Recorridos</a></li>
					<li class="dropdown">
			        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Recorridos Propios<span class="caret"></span></a>
			       		<ul class="dropdown-menu" role="menu">
				            <li><a href="nuevoRecorrido.jsp">Nuevo</a></li>
				            <li><a href="misRecorridos.jsp">Ver</a></li>
				    	</ul>
			        </li>
					<li class="dropdown">
			        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Mensajes<span class="caret"></span></a>
			       		<ul class="dropdown-menu" role="menu">
				            <li><a href="enviarMensaje.jsp">Enviar</a></li>
				            <li><a href="verMensajes.jsp">Bandeja de entrada</a></li>
				    	</ul>
			    	</li>
					<li><a href="historial.jsp">Historial</a></li>
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
			<h2>Mis recorridos</h2>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							<span class="glyphicon gliphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							Un recorrido
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-pencil"></span>
							<span class="glyphicon glyphicon-trash"></span>
						</div>
					</div>
				</div>
				<div class="panel panel-body">
					<div class="row">
						<div class="col-sm-6" id="map_canvas" style="width: 500px;height: 400px;"></div>
						<div class="col-sm-6">
							<p>Informacion del viaje</p>
							<h4>Desde: Un lado</h4>
							<h4>Hasta: La facu</h4>
							<h4>Tipo: Diario - Ida y vuelta</h4>
							<h4>Hora ida: 08:00hs</h4>
							<h4>Hora vuelta: 14:00hs</h4>
							<br>
							<p>Viajeros</p>
							<div class="list-group">
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-9">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-3">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-trash"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-9">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-3">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-trash"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-9">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-3">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-trash"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-9">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-3">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-trash"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
							</div>
						</div>
					</div>				
				</div>
			</div>
			<div class="list-group">
					<a href="#" class="list-group-item active">
						<div class="row">
							<div class="col-md-11">
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								Un recorrido
							</div>
							<div class="col-md-1">
								<span class="glyphicon glyphicon-pencil"></span>
								<span class="glyphicon glyphicon-trash"></span>
							</div>
						</div>
					</a>
					<a href="#" class="list-group-item active">
						<div class="row">
							<div class="col-md-11">
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								Un recorrido
							</div>
							<div class="col-md-1">
								<span class="glyphicon glyphicon-pencil"></span>
								<span class="glyphicon glyphicon-trash"></span>
							</div>
						</div>
					</a>	
				</div>
		</div>
	</div>
	<!-- Fin de pagina -->

	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="../resources/customJS/nuevoRecorridoSelects.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js"></script>
    <script src="../resources/customJS/googleMapsInitialization.js"></script>
</body>
</html>