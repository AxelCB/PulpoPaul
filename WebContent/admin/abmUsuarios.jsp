<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet">
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
			            <li><a href="abmUsuarios.jsp">Usuarios</a></li>
			            <li><a href="abmRecorridos.jsp">Recorridos</a></li>
			            <li><a href="abmMensajes.jsp">Mensajes</a></li>
			          </ul>
			        </li>
			        <li><a href="abmEventos.jsp">Eventos acad&eacute;micos</a></li>
			        <li><a href="denuncias.jsp">Denuncias</a></li>
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
			<h2>Gesti&oacute;n de Usuarios</h2>
			<table class="table table-hover">
				<thead><tr>
					<th>Nombres</th>
					<th>Apellido</th>
					<th>Tel&eacute;fono</th>
					<th>Email</th>
					<th>Contrase&ntilde;a</th>
					<th></th>
					<th></th>
					<th></th>
				</tr></thead>
				<tbody>
					<tr>
						<td>Axel</td>
						<td>Collard Bovy</td>
						<td>2964 611519</td>
						<td>axelcollardbovy@gmail.com</td>
						<td>1234</td>
						<td><a href="#" ><span class="glyphicon glyphicon-ban-circle"></span></a>
						<td><a href="#" onclick="mostrarModalNuevoUsuario();"><span class="glyphicon glyphicon-pencil"></span></a>
						<td><a href="#" onclick="mostrarModalEliminar();"><span class="glyphicon glyphicon-trash"></span></a>
					</tr>
					<tr>
						<td>Santiago</td>
						<td>Ruta</td>
						<td>3401 2230456</td>
						<td>santiagoruta@gmail.com</td>
						<td>4321</td>
						<td><a href="#" ><span class="glyphicon glyphicon-ban-circle"></span></a>
						<td><a href="#" onclick="mostrarModalNuevoUsuario();"><span class="glyphicon glyphicon-pencil"></span></a>
						<td><a href="#" onclick="mostrarModalEliminar();"><span class="glyphicon glyphicon-trash"></span></a>
					</tr>
				</tbody>
			</table>
			<div class="row">
				<button class="btn btn-primary" onclick="mostrarModalNuevoUsuario();">Agregar nuevo</button>
			</div>
		</div>
	</div>
	<!-- Fin de pagina -->
	
	<!-- Comienzo Modal Nuevo Usuario -->
	<div class="modal fade" id="nuevo-usuario" tabindex="-1" role="dialog" aria-labelledby="tituloModalNuevoUsuario" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="tituloModalNuevoUsuario">Nuevo usuario</h4>
	      </div>
	      <div class="modal-body">
			<form method="post" class="form-horizontal" action="">
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label" for="nombre">Nombre(s):</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="nombre" class="form-control" placeholder="Nombre(s)" required>
					  	</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label control-label" for="apellido">Apellido</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="apellido" class="form-control" placeholder="Apellido" required>
					  	</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label control-label" for="telefono">Tel&eacute;fono</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="telefono" class="form-control" placeholder="N&uacute;mero de tel&eacute;fono" required>
					  	</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label control-label" for="telefono">E-mail</label>
					  	<div class="col-sm-6">
					  		<input type="email" name="email" class="form-control" placeholder="Email" required>
					  	</div>
					</div>
					<div class="form-group">
					  <label class="col-sm-2 col-sm-offset-2 control-label control-label" for="clave">Contrase&ntilde;a</label>
					  <div class="col-sm-6">
						  <input type="password" name="clave" class="form-control" placeholder="Contrase&ntilde;a" required>
					  </div>
					</div>
					<div class="form-group">
					  <label class="col-sm-2 col-sm-offset-2 control-label control-label" for="repetirClave">Repetir Contrase&ntilde;a</label>
					  <div class="col-sm-6">
						  <input type="password" name="repetirClave" class="form-control" placeholder="Repita su Contrase&ntilde;a" required>
					  </div>
					</div>
					<div class="form-group">
					  <label class="col-sm-2 col-sm-offset-2 control-label control-label" for="foto">Foto de perfil</label>
					  <div class="col-sm-6">
						  <input type="file" name="foto">
					  </div>
					</div>
				</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
	        <button type="button" class="btn btn-primary" data-dismiss="modal">Guardar</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<!-- Comienzo Modal Eliminar -->	
	<div class="modal fade" id="eliminar-elemento" tabindex="-1" role="dialog" aria-labelledby="tituloModalEliminarUsuario" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close" type="button">×</button>
					<h4 id="tituloModalEliminarUsuario" class="modal-title">Eliminar</h4>	
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
</body>
</html>