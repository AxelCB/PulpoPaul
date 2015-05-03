<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="header.jsp">
	<jsp:param value="Usuarios" name="titulo"/>
</jsp:include>
	<link href="${pageContext.request.contextPath}/resources/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet">

<body>

	<jsp:include page="navigation.jsp"/>
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2><s:property value="getText('user.title')"/></h2>
			<table class="table table-hover" id="usuarios">
				<thead>
					<tr>
						<th></th>
						<th><s:property value="getText('user.names')"/></th>
						<th><s:property value="getText('user.lastname')"/></th>
						<th><s:property value="getText('user.telephone')"/></th>
						<th><s:property value="getText('user.email')"/></th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="usuarios">
					<tr>
						<td><s:property value="id"/></td>
						<td><s:property value="nombres"/></td>
						<td><s:property value="apellido"/></td>
						<td><s:property value="telefono"/></td>
						<td><s:property value="email"/></td>
						<td><a href="#"><span class="glyphicon glyphicon-envelope"></span></a></td>
						<td><a href="#"><span class="glyphicon glyphicon-warning-sign"></span></a></td>
						<td><a href="#"><span class="glyphicon glyphicon-star"></span></a></td>
						<td><a href="#"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
		</div>
	</div>
	<!-- Fin de pagina -->
	
	<!-- Comienzo Modal Nuevo Usuario -->
	<div class="modal fade" id="nuevo-usuario" tabindex="-1" role="dialog" aria-labelledby="tituloModalNuevoUsuario" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="tituloModalNuevoUsuario"><s:property value="getText('user.new')"/></h4>
	      </div>
	      <div class="modal-body">
			<form method="post" class="form-horizontal" action="">
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label" for="nombre"><s:property value="getText('user.names')"/>:</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="nombre" class="form-control" placeholder="Nombre(s)" required>
					  	</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label control-label" for="apellido"><s:property value="getText('user.lastname')"/>:</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="apellido" class="form-control" placeholder="Apellido" required>
					  	</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label control-label" for="telefono"><s:property value="getText('user.telephone')"/>:</label>
					  	<div class="col-sm-6">
					  		<input type="text" name="telefono" class="form-control" placeholder="N&uacute;mero de tel&eacute;fono" required>
					  	</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 col-sm-offset-2 control-label control-label" for="telefono"><s:property value="getText('user.email')"/>:</label>
					  	<div class="col-sm-6">
					  		<input type="email" name="email" class="form-control" placeholder="Email" required>
					  	</div>
					</div>
					<div class="form-group">
					  <label class="col-sm-2 col-sm-offset-2 control-label control-label" for="clave"><s:property value="getText('user.password')"/>:</label>
					  <div class="col-sm-6">
						  <input type="password" name="clave" class="form-control" placeholder="Contrase&ntilde;a" required>
					  </div>
					</div>
					<div class="form-group">
					  <label class="col-sm-2 col-sm-offset-2 control-label control-label" for="repetirClave"><s:property value="getText('user.repeatPassword')"/>:</label>
					  <div class="col-sm-6">
						  <input type="password" name="repetirClave" class="form-control" placeholder="Repita su Contrase&ntilde;a" required>
					  </div>
					</div>
					<div class="form-group">
					  <label class="col-sm-2 col-sm-offset-2 control-label control-label" for="foto"><s:property value="getText('user.photo')"/>Foto de perfil</label>
					  <div class="col-sm-6">
						  <input type="file" name="foto">
					  </div>
					</div>
				</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal"><s:property value="getText('default.cancel')"/></button>
	        <button type="button" class="btn btn-primary" data-dismiss="modal"><s:property value="getText('default.save')"/></button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

	<!-- Comienzo Modal Eliminar -->	
	<div class="modal fade" id="eliminar-elemento" tabindex="-1" role="dialog" aria-labelledby="tituloModalEliminarUsuario" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button aria-hidden="true" data-dismiss="modal" class="close" type="button">Ã</button>
					<h4 id="tituloModalEliminarUsuario" class="modal-title"><s:property value="getText('default.delete')"/></h4>	
				</div>
				<div class="modal-body"><s:property value="getText('default.confirmDelete')"/></div>
				<div class="modal-footer">
					<button data-dismiss="modal" class="btn btn-primary" type="button"><s:property value="getText('default.delete')"/></button>
					<button data-dismiss="modal" class="btn btn-default" type="button"><s:property value="getText('default.cancel')"/></button>
				</div>
			</div>
		</div>
	</div>
	<!-- Fin Modal Eliminar -->
	
	<!-- Comienzo Modal Enviar Mensaje -->
	<div class="modal fade" id="mensajeEnviar" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  	<div class="modal-dialog modal-lg">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        		<h4 class="modal-title"><s:property value="getText('outbox.receiver')"/>: <span id="nombreDestinatario"></span></h4>
	      		</div>
	      		<form action="enviarDesdeAdmin" method="post">
		      		<div class="modal-body">
						<div class="row">
							<div class="col-lg-12">
								<input type="text" class="invi" id="idDestinatario" name="idRemitente" required>
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
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-default" value="<s:property value="getText('menu.messages.send')"/>"/>
		        		<button type="button" class="btn btn-default" data-dismiss="modal"><s:property value="getText('default.close')"/></button>
		      		</div>
	      		</form>
			</div>
	    </div>
	</div>
	<!-- Fin Modal Enviar Mensaje -->
	
	<jsp:include page="scripts.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/customJS/usuarios.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	
</body>
</html>