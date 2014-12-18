<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home </title>
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
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2>Nuevo mensaje</h2>
			<form action="/PulpoPaul/viajero/enviarMensaje.jsp" method="post">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="Destinatario" required>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-info-sign"></span>
					</span>
					<input type="text" class="form-control" placeholder="Asunto" required>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-envelope"></span>
					</span>
					<input type="text" class="form-control" placeholder="Mensaje" required>
				</div>
				<br>
				<div class="row">
					<div class="col-md-2 col-md-offset-10">
						<button type="submit" class="btn btn-default form-control" >Enviar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Fin de pagina -->
	

	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>