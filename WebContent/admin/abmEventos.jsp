<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="../resources/customCSS/CustomViajeroStyle.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Admin</title>
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
			            <li><a href="/PulpoPaul/admin/abmUsuarios.jsp">Usuarios</a></li>
			            <li><a href="/PulpoPaul/admin/abmRecorridos.jsp">Recorridos</a></li>
			            <li><a href="/PulpoPaul/admin/abmMensajes.jsp">Mensajes</a></li>
			          </ul>
			        </li>
			        <li><a href="/PulpoPaul/admin/abmEventos.jsp">Eventos acad&eacute;micos</a></li>
			        <li><a href="/PulpoPaul/admin/denuncias.jsp">Denuncias</a></li>
				 </ul>
				 <ul class="nav navbar-nav navbar-right">
					<li><a href='<s:url action="logout"/>'>Log Out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Fin del menu barra admin -->
	
		<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2>Gesti&oacute;n de Eventos Acad&eacute;micos</h2>
			<table class="table table-hover">
				<thead><tr>
					<th>Nombre</th>
<!-- 					<th>Tipo</th> -->
					<th>Lugar</th>
					<th>Descripci&oacute;n</th>
					<th>D&iacute;a y hora comienzo</th>
					<th>D&iacute;a y hora fin</th>
					<th></th>
					<th></th>
				</tr></thead>
				<tbody>
					<tr>
						<td>JAIO</td>
<!-- 						<td>Acad&eacute;mico</td> -->
						<td>Facultad de Inform&aacute;tica UBA</td>
						<td>Jornadas Argentinas de Inform&aacute;tica</td>
						<td>28/10/2014 10:00 a.m.</td>
						<td>30/10/2014 4:00 p.m.</td>
						<td><a href="#" onclick="mostrarModalNuevoEvento();"><span class="glyphicon glyphicon-pencil"></span></a>
						<td><a href="#" onclick="mostrarModalEliminar();"><span class="glyphicon glyphicon-trash"></span></a>
					</tr>
					<tr>
						<td>PHP Conference</td>
<!-- 						<td>??¡</td> -->
						<td>UTN Berisso</td>
						<td>Conferencia anual sobre el lenguaje PHP</td>
						<td>10/11/2014 11:00 a.m.</td>
						<td>12/11/2014 6:00 p.m.</td>
						<td><a href="#" onclick="mostrarModalNuevoEvento();"><span class="glyphicon glyphicon-pencil"></span></a>
						<td><a href="#" onclick="mostrarModalEliminar();"><span class="glyphicon glyphicon-trash"></span></a>
					</tr>
				</tbody>
			</table>
			<div class="row">
				<button class="btn btn-primary" onclick="mostrarModalNuevoEvento();">Agregar nuevo</button>
			</div>
		</div>
	</div>
	<!-- Fin de pagina -->
	
	<!-- Comienzo Modal Nuevo Evento -->
	<div class="modal fade" id="nuevo-evento" tabindex="-1" role="dialog" aria-labelledby="tituloModalNuevoEvento" aria-hidden="true">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="tituloModalNuevoEvento">Nuevo evento</h4>
	      </div>
	      <div class="modal-body">
		      <div class="row">
				<form method="post" class="form-horizontal" action="">
					<div class="col-sm-6">
						<div class="form-group">
							<label class="col-sm-4 control-label" for="nombre">Nombre:</label>
						  	<div class="col-sm-7">
						  		<input type="text" name="nombre" class="form-control" placeholder="Nombre" required>
						  	</div>
						</div>
		<!-- 					SELECT -->
						<div class="form-group">
							<label class="col-sm-4 control-label control-label" for="lugar">Lugar</label>
						  	<div class="col-sm-7">
						  		<input type="text" name="lugar" class="form-control" placeholder="Lugar" required>
						  	</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label control-label" for="descripcion">Descripci&oacute;n</label>
						  	<div class="col-sm-7">
						  		<textarea id="descripcion" class="form-control" required="required" cols="40" 
						  		rows="3" placeholder="Descripci&oacute;n"  name="descripcion"></textarea>
						  	</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label control-label" for="comienzo">D&iacute;a y hora comienzo</label>
						  	<div class="col-sm-7">
						  		<input type="datetime-local" name="comienzo" class="form-control" placeholder="D&iacute;a y hora comienzo" required>
						  	</div>
						</div>
						<div class="form-group">
						  <label class="col-sm-4 control-label control-label" for="clave">D&iacute;a y hora fin</label>
						  <div class="col-sm-7">
							  <input type="datetime-local" name="fin" class="form-control" placeholder="D&iacute;a y hora fin" required>
						  </div>
						</div>
					</div>
					<div class="col-sm-6">
						<div id="map_canvas" style="width: 400px;height: 300px;"></div>
					</div>
				</form>
			</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	        <button type="button" class="btn btn-primary" data-dismiss="modal">Guardar</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<!-- Comienzo Modal Eliminar -->	
	<div class="modal fade" id="eliminar-elemento" tabindex="-1" role="dialog" aria-labelledby="tituloModalEliminarEvento" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
					<h4 id="tituloModalEliminarEvento" class="modal-title">Eliminar</h4>	
				</div>
				<div class="modal-body">¿Está seguro de
					eliminar este elemento?</div>
				<div class="modal-footer">
					<button data-dismiss="modal" class="btn btn-primary" type="button">Eliminar</button>
					<button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin Modal Eliminar -->
	
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="../resources/customJS/funcionesAdmin.js"></script>
	<script src="https://maps.googleapis.com/maps/api/js"></script>
    <script src="../resources/customJS/googleMapsInitialization.js"></script>
</body>
</html>