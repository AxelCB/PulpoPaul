<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">${usuario.getNombres()}, ${usuario.getApellido()}</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="listarEventos"><s:property value="getText('menu.events')"/></a></li>
                <li><a href="listarUsuarios"><s:property value="getText('menu.users')"/></a></li>
                <li><a href="listarDenuncias"><s:property value="getText('menu.complaints')"/></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href='<s:url action="logout"/>'><s:property value="getText('default.logout')"/></a></li>
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