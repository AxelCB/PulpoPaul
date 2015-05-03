<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>

<jsp:include page="header.jsp">
	<jsp:param value="Denuncias" name="titulo"/>
</jsp:include>
<link href="${pageContext.request.contextPath}/resources/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet">

<body>

	<jsp:include page="navigation.jsp"/>
	
	<div class="container">
		<div class="jumbotron">
			<h2><s:property value="getText('qualify.title')"/> <s:property value="usuario.getNombres()"/>, <s:property value="usuario.getApellido()"/></h2>	
			<table id="calificaciones">
	
				<thead>
					<tr>
						<th><s:property value="getText('qualify.qualifier')"/></th>
						<th><s:property value="getText('qualify.qualify')"/></th>
					</tr>
				</thead>
			
				<tbody>
					<s:if test="%{!calificaciones.isEmpty()}" >
					<s:iterator value="calificaciones">
						<tr>
							<td><s:property value="calificador.nombres"/>, <s:property value="calificador.apellido"/></td>											
							<td><s:property value="calificacion"/></td>
						</tr>
					</s:iterator>				
					</s:if>
				</tbody>
				
			</table>
		</div>
	</div>
	
	
	
	<jsp:include page="scripts.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/customJS/calificaciones.js"></script>
</body>
</html>