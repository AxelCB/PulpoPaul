<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Viajero</title>
</head>
<body>
<div class="container">
	<div class="row">
		<h2 class="col-sm-offset-2 col-sm-10">Datos personales:</h2>
	</div>
	
	<br>

	<s:form action="registrarUsuario" method="post" theme="simple" cssClass="form-horizontal" enctype="multipart/form-data">
		
		<div class="form-group">
			<label class="col-sm-2 control-label" for="nombre">Nombre:</label>
		  	<div class="col-sm-4">
		  		<s:textfield name="nombre" theme="simple" cssClass="form-control"/>
				<s:fielderror fieldName="nombreError"/>
		  	</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label" for="apellido">Apellido:</label>
		  	<div class="col-sm-4">
		  		<s:textfield name="apellido" theme="simple" cssClass="form-control"/>
		  		<s:fielderror fieldName="apellidoError"/>
		  	</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label" for="telefono">Tel&eacute;fono:</label>
		  	<div class="col-sm-4">
		  		<s:textfield name="telefono" theme="simple" cssClass="form-control"/>
		  		<s:fielderror fieldName="telefonoError" />
		  	</div>
		</div>				
		
		<div class="form-group">
			<label class="col-sm-2 control-label" for="telefono">E-mail:</label>
		  	<div class="col-sm-4">
		  		<s:textfield name="email" theme="simple" cssClass="form-control"/>
		  		<s:fielderror fieldName="emailError"/>
		  		<s:fielderror fieldName="emailError2"/>
		  	</div>
		</div>
		
		<div class="form-group">
		  <label class="col-sm-2 control-label" for="clave">Contrase&ntilde;a:</label>
		  <div class="col-sm-4">
			  <s:password name="clave" theme="simple" cssClass="form-control"/>
			  <s:fielderror fieldName="claveError"/>
		  </div>
		</div>

		<div class="form-group">
		  <label class="col-sm-2 control-label" for="repetirClave">Repetir Contrase&ntilde;a:</label>
		  <div class="col-sm-4">
			  <s:password name="repetirClave" theme="simple" cssClass="form-control"/>
			  <s:fielderror fieldName="repetirClaveError"/>
			  <s:fielderror fieldName="repetirClaveError2"/>
		  </div>
		</div>
		
		<div class="form-group">
		  <label class="col-sm-2 control-label" for="foto">Foto de perfil:</label>
		  <div class="col-sm-4">
			  <input type="file" name="foto" class="form-control"/>
		  </div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<s:submit value="Registrarse" theme="simple" cssClass="btn btn-default"/>
			</div>
		</div>
	</s:form>
	
</div>		

	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>