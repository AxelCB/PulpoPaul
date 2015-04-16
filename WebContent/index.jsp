<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- 
/struts-jquery-tags
/struts-jquery-grid-tags
-->

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
<title><s:property value="getText('index.title')"/></title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h2 class="col-sm-offset-2 col-sm-10"><s:property value="getText('index.login')"/></h2>
		</div>
		<br>
		
		<s:if test="%{mensajeError!=''}">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-1">
					<div class="alert alert-danger" role="alert">
						<s:property value="mensajeError"></s:property>
					</div>
				</div>
			</div>
		</s:if>
		<s:if test="%{mensajeOk!=''}">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-1">
					<div class="alert alert-success" role="alert">
						<s:property value="mensajeOk"></s:property>
					</div>
				</div>
			</div>
		</s:if>

		<s:fielderror fieldName="nologedError"/>		
		<s:fielderror fieldName="loginError"/>

		<s:form action="login" method="post" theme="simple" cssClass="form-horizontal">

			<div class="form-group">
				<label class="col-sm-2 control-label" for="usuario"><s:property value="getText('index.user')"/></label>
				<div class="col-sm-4">
					<s:textfield name="usuario" theme="simple" cssClass="form-control" />
					<s:fielderror fieldName="usuarioError"/>
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="usuario"><s:property value="getText('index.password')"/></label>
				<div class="col-sm-4">
					<s:password name="clave" theme="simple" cssClass="form-control"/>
					<s:fielderror fieldName="claveError"/>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<s:submit value="%{getText('index.access')}" theme="simple" cssClass="btn btn-default"/>
				</div>
			</div>
		</s:form>

	</div>
	
	<a href="viajero/registrar.jsp" class="col-sm-offset-3 col-sm-9"><s:property value="getText('index.register')"/></a>
	<br>
	<br>
	<br>
	<div class="row">
		<div class="col-sm-10 col-sm-offset-1">
			<div class="alert alert-danger" role="alert">
				<h3><s:property value="getText('index.beforeAnything')"/><a href="https://github.com/AxelCB/PulpoPaul"><s:property value="getText('index.readReadme')"/></a></h3>
			</div>
		</div>
	</div>
		
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>