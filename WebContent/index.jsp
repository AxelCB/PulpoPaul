<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css"
	rel="stylesheet">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inicio de PulpoPaul Infop@@l</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-sm-offset-2 col-sm-10">Login</h2>
		</div>
		<br>

		<s:form action="login" method="post" theme="simple" cssClass="form-horizontal">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="usuario">Usuario</label>
				<div class="col-sm-4">
					<s:textfield name="usuario" theme="simple" cssClass="form-control" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="usuario">Contrase&ntilde;a</label>
				<div class="col-sm-4">
					<s:password name="clave" theme="simple" cssClass="form-control"/>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit value="Acceder" theme="simple" cssClass="btn btn-default"/>
				</div>
			</div>
			
		</s:form>

	</div>
	
	<a href="viajero/registrar.html" class="col-sm-offset-3 col-sm-9">¿No esta registrado? Registrese aqui­.</a>
		
	<script type="text/javascript">
		var homeUsuario = function() {
			if (window.location.hostname != 'localhost') {
				$(location).attr(
						'href',
						window.location.protocol + '//' + window.location.host
								+ '/viajero/verMensajes.html');
			} else {
				$(location).attr(
						'href',
						window.location.protocol + '//' + window.location.host
								+ '/PulpoPaul/viajero/verMensajes.html');
			}
		};
	</script>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>