<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="header.jsp">
	<jsp:param value="Denuncias" name="titulo"/>
</jsp:include>

<body>

	<jsp:include page="navigation.jsp"/>
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2>Bandeja de Denuncias</h2>
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'Un viaje' <br>
							Mensaje de Pepe: 'Un desastre.'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	PasÃ³ a cualquier hora, y me dejÃ³ plantado a la vuelta. No lo recomiendo!
			  	</div>
			</div>
			
			<div class="panel panel-warning">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'Un viaje m&aacute;s' <br>
							Mensaje de Juana: 'Precio'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	El viaje estuvo bastante bien, pero el precio resultÃ³ excesivo. No recomiendo para billeteras livianas.
			  	</div>
			</div>
			
			<div class="panel panel-danger">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'El super viaje' <br>
							Mensaje de Maria: 'Auto'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	No suelo ser muy detallista, pero la verdad, que no recomiendo mucho este auto, por lo menos por ahora. El auto se parÃ³ varias veces, y un par de cuadras antes llegar se le rompiÃ³ algo y tuvimos que ir caminando!
			  	</div>
			</div>

	
			<div class="panel panel-warning">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							Viaje: 'Mi ultimo viaje' <br>
							Mensaje de Hector: 'Espera'
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-remove"></span>
							<span class="glyphicon glyphicon-envelope"></span>
							<span class="glyphicon glyphicon-user"></span>
						</div>
					</div>
				</div>
			  	<div class="panel-body">
			    	Tuve que esperar un rato largo antes de volver, pero el resto del viaje estuvo bastante aceptable.
			  	</div>
			</div>
			<div class="btn-toolbar" role="toolbar">
	  			<div class="btn-group">
	  				<button type="button" class="btn btn-default">1</button>
	  				<button type="button" class="btn btn-default">2</button>
	  				<button type="button" class="btn btn-default">3</button>	
	  			</div>
			</div>
		</div>
	</div>
	<!-- Fin de pagina -->
	
	<jsp:include page="scripts.jsp"/>
	
</body>
</html>