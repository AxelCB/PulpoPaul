<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>