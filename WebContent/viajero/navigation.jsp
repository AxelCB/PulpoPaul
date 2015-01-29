<%@ taglib prefix="s" uri="/struts-tags" %>

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
				<li>
					<a href="<s:url action="logout"></s:url>">Log Out</a>
				</li>
			</ul>
		</div>
	</div>
</nav>