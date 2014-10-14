<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicio de PulpoPaul Infop@@l</title>
</head>
<body>
<br>
	<form class="form-horizontal" action="admin/homeAdmin.jsp">
		<div class="form-group">
			<label class="col-sm-2 control-label" for="usuario">Usuario</label>
		  	<div class="col-sm-4">
		  		<input type="text" name="usuario" class="form-control" placeholder="Nombre de Usuario">
		  	</div>
		</div>
		<div class="form-group">
		  <label class="col-sm-2 control-label" for="usuario">Contrase&ntilde;a</label>
		  <div class="col-sm-4">
			  <input type="password" name="clave" class="form-control" placeholder="Contrase&ntilde;a">
		  </div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Acceder">
			</div>
		</div>
	</form>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>