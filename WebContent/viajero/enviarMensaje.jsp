<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>

<jsp:include page="header.jsp">
	<jsp:param value="Bandeja Salida" name="titulo"/>
</jsp:include>

</head>
<body>

	<jsp:include page="navigation.jsp"/>
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2>Nuevo mensaje</h2>
			<form action="enviarMensaje" method="post">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<select class="form-control" name="idRemitente" required>
					<s:if test="%{!usuarios.isEmpty()}" >
					<s:iterator value="usuarios">
						<option value='<s:property value="id"/>'><s:property value="nombres"/></option>
					</s:iterator>				
					</s:if>
					</select>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-info-sign"></span>
					</span>
					<input type="text" class="form-control" placeholder="Asunto" name="asunto" required>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-envelope"></span>
					</span>
					<input type="text" class="form-control" placeholder="Mensaje" name="mensaje" required>
				</div>
				<br>
				<div class="row">
					<div class="col-md-2 col-md-offset-10">
						<button type="submit" class="btn btn-default form-control" >Enviar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!-- Fin de pagina -->
	

	<jsp:include page="scripts.jsp"/>
	
</body>
</html>