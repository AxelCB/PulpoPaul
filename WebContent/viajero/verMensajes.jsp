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
			<h2>Bandeja de Entrada</h2>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Mensaje de Pepe: 'Te llevo'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Lorem ipsum dolor sit amet, essent nonumes cu sea, in mei invidunt recusabo principes, has cu fuisset maluisset accommodare. Vel harum deseruisse eu, nibh elitr senserit ad has. Duo ex option saperet legendos, eos in errem fierent. Amet iisque expetenda vix ad, sed id verear consequat definiebas.
			  	</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Mensaje de Maria: 'Auto'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Liber veniam feugait no vim. Vis quis blandit deseruisse ut, simul scripta ut eam, an nisl vulputate qui. At sit tantas phaedrum moderatius, at epicuri lucilius per. Alia aeque feugiat mei cu, vidit indoctum laboramus ex mel. Ut ullum tincidunt contentiones eos.
			  	</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Mensaje de Juana: 'Precio'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Exerci quidam ad vel, qui ut sanctus admodum interesset. Ut option blandit eum, et mel vide commodo. Mel porro exerci feugiat te. Ea sed rebum everti sensibus, id usu diceret accusam.
			  	</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Mensaje de Julieta: 'Lugares'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Cu duo congue diceret, his ad labores perfecto hendrerit, vix ea oblique iuvaret. Partem volumus vim ei. Ius et nemore eruditi, eos affert platonem ad. Antiopam persecuti id duo, cu pri dicta deleniti tincidunt, et nec mentitum dissentias dissentiet. Veritus mentitum forensibus eu ius.
			  	</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Mensaje de Hector: 'Me llevas'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Sed odio moderatius consequuntur ea. Viris nusquam mentitum pro ex, no sit tollit insolens vulputate. Ut electram abhorreant vim. Duo an prima atomorum, ridens principes iracundia nam ea, summo iracundia consequuntur pri te. Pro dictas luptatum efficiendi no, vocent corrumpit euripidis eos in.
			  	</div>
			</div>
			<div class="btn-toolbar" role="toolbar">
	  			<div class="btn-group">
	  				<button type="button" class="btn btn-default">1</button>
	  				<button type="button" class="btn btn-default">2</button>
	  				<button type="button" class="btn btn-default">3</button>	
	  			</div>
			</div>
		</div>
	</div>
	<!-- Fin de pagina -->
	

	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>