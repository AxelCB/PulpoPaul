<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
	    	<a class="navbar-brand" href="#">${usuario.getNombres()}</a>
	    	<div class="invi" id="idUsuario">${usuario.getId()}</div>
    	</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="buscarRecorridos">Buscar Recorridos</a></li>
				<li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Recorridos Propios<span class="caret"></span></a>
		       		<ul class="dropdown-menu" role="menu">
			            <li><a href="recorridoNuevoInit">Nuevo</a></li>
			            <li><a href="misRecorridos">Ver</a></li>
			    	</ul>
		        </li>
				<li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Mensajes<span class="caret"></span></a>
		       		<ul class="dropdown-menu" role="menu">
			            <li><a href="/PulpoPaul/viajero/enviarMensaje.jsp">Enviar</a></li>
			            <li><a href="bandejaEntrada">Bandeja de entrada</a></li>
			    	</ul>
		    	</li>
		    	<li><a href="/PulpoPaul/viajero/historial.jsp">Historial</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="<s:url action="logout"></s:url>">Log Out</a>
				</li>
			</ul>
		</div>
	</div>
</nav>

<s:if test="%{mensajeError!=''}">
	<div class="row">
		<h2>Error</h2>
		<div class="alert alert-danger" role="alert">
			<s:property value="mensajeError"></s:property>
		</div>
	</div>
</s:if>
<s:if test="%{mensajeOk!=''}">
	<div class="row">
		<h2>Operación exitosa</h2>
		<div class="alert alert-success" role="alert">
			<s:property value="mensajeOk"></s:property>
		</div>
	</div>
</s:if>