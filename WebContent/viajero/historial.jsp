<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="header.jsp">
	<jsp:param value="Historial" name="titulo"/>
</jsp:include>

<body>

	<jsp:include page="navigation.jsp"/>
	
	<!-- Comienzo de pagina -->
	<div class="container">
		<div class="jumbotron">
			<h2>Recorridos en los que participo</h2>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-11">
							<span class="glyphicon gliphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							Un recorrido
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-trash"></span>
							<span class="glyphicon glyphicon-warning-sign"></span>
						</div>
					</div>
				</div>
				<div class="panel panel-body">
					<div class="row">
						<div class="col-sm-6" id="map_canvas" style="width: 500px;height: 400px;"></div>
						<div class="col-sm-6">
							<p>Informacion del viaje</p>
							<h4>Desde: Un lado</h4>
							<h4>Hasta: La facu</h4>
							<h4>Tipo: Diario - Ida y vuelta</h4>
							<h4>Hora ida: 08:00hs</h4>
							<h4>Hora vuelta: 14:00hs</h4>
							<br>
							<p>Viajeros</p>
							<div class="list-group">
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-10">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-2">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-10">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-2">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-10">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-2">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
								<a href="#" class="list-group-item">
									<div class="row">
										<div class="col-md-10">
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-star-empty"></span>
											Juan
										</div>
										<div class="col-md-2">
											<span class="glyphicon glyphicon-star-empty"></span>
											<span class="glyphicon glyphicon-warning-sign"></span>
										</div>
									</div>
								</a>
							</div>
						</div>
					</div>			
				</div>
			</div>
			<div class="list-group">
				<a href="#" class="list-group-item active">
					<div class="row">
						<div class="col-md-11">
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							Un recorrido
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-trash"></span>
							<span class="glyphicon glyphicon-warning-sign"></span>
						</div>
					</div>
				</a>
				<a href="#" class="list-group-item active">
					<div class="row">
						<div class="col-md-11">
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-star-empty"></span>
							Un recorrido
						</div>
						<div class="col-md-1">
							<span class="glyphicon glyphicon-star-empty"></span>
							<span class="glyphicon glyphicon-trash"></span>
							<span class="glyphicon glyphicon-warning-sign"></span>
						</div>
					</div>
				</a>	
			</div>	
			<br>
			<h2>Recorridos en los que participe</h2>
			<div class="list-group">
				<a href="#" class="list-group-item active">
						<div class="row">
							<div class="col-md-11">
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								Un recorrido
							</div>
							<div class="col-md-1">
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-warning-sign"></span>
							</div>
						</div>
					</a>
					<a href="#" class="list-group-item active">
						<div class="row">
							<div class="col-md-11">
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								Un recorrido
							</div>
							<div class="col-md-1">
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-warning-sign"></span>
							</div>
						</div>
					</a>
					<a href="#" class="list-group-item active">
						<div class="row">
							<div class="col-md-11">
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								Un recorrido
							</div>
							<div class="col-md-1">
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-warning-sign"></span>
							</div>
						</div>
					</a>
					<a href="#" class="list-group-item active">
						<div class="row">
							<div class="col-md-11">
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-star-empty"></span>
								Un recorrido
							</div>
							<div class="col-md-1">
								<span class="glyphicon glyphicon-star-empty"></span>
								<span class="glyphicon glyphicon-warning-sign"></span>
							</div>
						</div>
					</a>
				</div>
		</div>
	</div>
	<!-- Fin de pagina -->
	
	<jsp:include page="scripts.jsp"/>
	
</body>
</html>