<!DOCTYPE html>
<html>
<head>
	<link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home </title>
</head>
<body>

<!-- Comienzo menu barra admin -->
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<div class="navbar-header">
			    	<a class="navbar-brand" href="#">Nombre Admin</a>
		    	</div>
				 <ul class="nav navbar-nav">
				    <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">ABMs <span class="caret"></span></a>
			          <ul class="dropdown-menu" role="menu">
			            <li><a href="abmUsuarios.html">Usuarios</a></li>
			            <li><a href="abmRecorridos.html">Recorridos</a></li>
			            <li><a href="abmMensajes.html">Mensajes</a></li>
			          </ul>
			        </li>
			        <li><a href="abmEventos.html">Eventos acad&eacute;micos</a></li>
			        <li><a href="denuncias.html">Denuncias</a></li>
				 </ul>
				 <ul class="nav navbar-nav navbar-right">
					<li><a href="../index.html">Log Out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Fin del menu barra admin -->
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2>Bandeja de Denuncias</h2>
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'Un viaje' <br>
							Mensaje de Pepe: 'Un desastre.'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Pasó a cualquier hora, y me dejó plantado a la vuelta. No lo recomiendo!
			  	</div>
			</div>
			
			<div class="panel panel-warning">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'Un viaje m&aacute;s' <br>
							Mensaje de Juana: 'Precio'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	El viaje estuvo bastante bien, pero el precio resultó excesivo. No recomiendo para billeteras livianas.
			  	</div>
			</div>
			
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'El super viaje' <br>
							Mensaje de Maria: 'Auto'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	No suelo ser muy detallista, pero la verdad, que no recomiendo mucho este auto, por lo menos por ahora. El auto se paró varias veces, y un par de cuadras antes llegar se le rompió algo y tuvimos que ir caminando!
			  	</div>
			</div>

	
			<div class="panel panel-warning">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'Mi ultimo viaje' <br>
							Mensaje de Hector: 'Espera'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Tuve que esperar un rato largo antes de volver, pero el resto del viaje estuvo bastante aceptable.
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