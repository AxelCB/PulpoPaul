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
			<h2><s:property value="getText('complaints.title')"/></h2>
			<table id="denuncias">
				
				<thead>
					<tr>
						<th>id</th>
						<th><s:property value="getText('complaints.subject')"/></th>
						<th><s:property value="getText('default.reason')"/></th>
						<th></th>
						<th></th>
					</tr>
				</thead>
			
				<tbody>
					<s:if test="%{!denuncias.isEmpty()}" >
					<s:iterator value="denuncias">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="asunto"/></td>
							<td><s:property value="contenido"/></td>
							<td>
								<a href="#">
	                    			<span class="glyphicon glyphicon-eye-open"></span>
	                    		</a>
	                    	</td>
	                    	<td>
								<a href="enConstruccion">
	                    			<span class="glyphicon glyphicon-trash"></span>
	                    		</a>
	                    	</td>													
						</tr>
					</s:iterator>				
					</s:if>
				</tbody>
			
				<tfoot>
					<tr>
						<th>id</th>
						<th><s:property value="getText('complaints.subject')"/></th>
						<th><s:property value="getText('default.reason')"/></th>
						<th></th>
						<th></th>
					</tr>
				</tfoot>
				
			</table>
		</div>
	</div>
	
	
	<div class="modal fade" id="denuncia" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  	<div class="modal-dialog modal-lg">
	    	<div class="modal-content">
	      		<div class="modal-header">
	        		<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        		<h4 class="modal-title"><s:property value="getText('complaints.details')"/></h4>
	      		</div>
	      		<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<p><b><s:property value="getText('complaints.subject')"/>:</b> <span id="asunto"></span></p>
							<p><span id="motivo"></span></p>
						</div>
					</div>
				</div>
				<div class="modal-footer">
	        		<button type="button" class="btn btn-default" data-dismiss="modal"><s:property value="getText('default.close')"/></button>
	      		</div>
			</div>
	    </div>
	</div>
	
	<jsp:include page="scripts.jsp"/>
	<script src="${pageContext.request.contextPath}/resources/customJS/denuncias.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	
</body>
</html>