<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
	    	<a class="navbar-brand" href="#">${usuario.getNombres()}, ${usuario.getApellido()}</a>
	    	<div class="invi" id="idUsuario">${usuario.getId()}</div>
    	</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="buscarRecorridos"><s:property value="getText('menu.searchTravels')"/></a></li>
				<li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:property value="getText('menu.myTravels.name')"/><span class="caret"></span></a>
		       		<ul class="dropdown-menu" role="menu">
			            <li><a href="recorridoNuevoInit"><s:property value="getText('menu.myTravels.new')"/></a></li>
			            <li><a href="misRecorridos"><s:property value="getText('menu.myTravels.list')"/></a></li>
			    	</ul>
		        </li>
				<li class="dropdown">
		        	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:property value="getText('menu.messages.name')"/><span class="caret"></span></a>
		       		<ul class="dropdown-menu" role="menu">
						<li><a href="enConstruccion"><s:property value="getText('menu.messages.send')"/></a></li>
<!-- 			            <li><a href="/PulpoPaul/viajero/enviarMensaje.jsp">Enviar</a></li> -->
			            <li><a href="bandejaEntrada"><s:property value="getText('menu.messages.inbox')"/></a></li>
			    	</ul>
		    	</li>
		    	<li><a href="historial"><s:property value="getText('menu.historic')"/></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="<s:url action="logout"></s:url>"><s:property value="getText('default.logout')"/></a>
				</li>
			</ul>
		</div>
	</div>
</nav>

<s:if test="%{mensajeError!=''}">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-1">
			<h2><s:property value="getText('default.error')"/></h2>
			<div class="alert alert-danger" role="alert">
				<s:property value="mensajeError"></s:property>
			</div>
		</div>
	</div>
</s:if>
<s:if test="%{mensajeOk!=''}">
	<div class="row">
		<div class="col-sm-8 col-sm-offset-1">
			<h2><s:property value="getText('default.success')"/></h2>
			<div class="alert alert-success" role="alert">
				<s:property value="mensajeOk"></s:property>
			</div>
		</div>
	</div>
</s:if>
