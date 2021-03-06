<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>

<jsp:include page="header.jsp">
	<jsp:param value="Eventos" name="titulo"/>
</jsp:include>
	<link href="${pageContext.request.contextPath}/resources/datepicker/css/datepicker.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/datatables/media/css/jquery.dataTables.min.css" rel="stylesheet">
	<style>
		.datepicker{
			z-index: 9999;
		}
	</style>
	
<body>

	<jsp:include page="navigation.jsp"/>

	<div class="container">
	    <div class="jumbotron">
	        <h2><s:property value="getText('event.title')"/></h2>
	        
	        <table id="eventosTable">
	            <thead>
		            <tr>
		                <th><s:property value="getText('default.name')"/></th>
		                <th><s:property value="getText('default.place')"/></th>
		                <th><s:property value="getText('event.description')"/></th>
		                <th><s:property value="getText('default.date')"/></th>
		                <th><s:property value="getText('event.starttime')"/></th>
		                <th><s:property value="getText('event.endtime')"/></th>
		                <th></th>
		                <th></th>
		                <th></th>
		            </tr>
	            </thead>
	            
	            <tbody>
	            <s:iterator value="eventos">
	                <tr>
	                    <td><s:property value="nombre" /></td>
	                    <td><s:property value="lugar" /></td>
	                    <td><s:property value="descripcion" /></td>
	                    <td><s:date name="fecha" format="dd-MM-yyyy" /></td>
	                    <td><s:property value="horaComienzo"/></td>
	                    <td><s:property value="horaFin"/></td>
	                    <td>
	                    	<a href="#" onclick="mostrarModalMapa('<s:property value="latLng"/>');">
	                    		<span class="glyphicon glyphicon-map-marker"></span>
	                    	</a>
	                    </td>
	                    <td>
	                    	<a href="#" onclick="mostrarModalNuevoEvento();">
	                    		<span class="glyphicon glyphicon-pencil"></span>
	                    	</a>
	                    </td>
	                    <td>
	                    	<a href="enConstruccion" onclick="mostrarModalEliminar();">
	                    		<span class="glyphicon glyphicon-trash"></span>
	                    	</a>
	                    </td>
	                </tr>
	            </s:iterator>
	            </tbody>
	            
	            <tfoot>
		            <tr>
		                <th><s:property value="getText('default.name')"/></th>
		                <th><s:property value="getText('default.place')"/></th>
		                <th><s:property value="getText('event.description')"/></th>
		                <th><s:property value="getText('default.date')"/></th>
		                <th><s:property value="getText('event.starttime')"/></th>
		                <th><s:property value="getText('event.endtime')"/></th>
		                <th></th>
		                <th></th>
		                <th></th>
		            </tr>
	            </tfoot>
	        </table>
	        
	        <div class="row">
	            <button class="btn btn-primary" onclick="mostrarModalNuevoEvento();"><s:property value="getText('default.addNew')"/></button>
	        </div>
	        
	    </div>
	</div>
	
	<!-- Comienzo Modal Nuevo Evento -->
	<div class="modal fade" id="nuevo-evento" tabindex="-1" role="dialog" aria-labelledby="tituloModalNuevoEvento"
	     aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal">
	                	<span aria-hidden="true">&times;</span>
	                	<span class="sr-only">Close</span>
	                </button>
	                <h4 class="modal-title" id="tituloModalNuevoEvento"><s:property value="getText('event.new')"/></h4>
	            </div>
	            <div class="modal-body">
	                <div class="row">
	                    <s:form action="nuevoEvento" method="post" theme="simple" cssClass="form-horizontal" onsubmit="validateEventoForm();">
	                        <div class="col-sm-6">
	                        
	                            <div class="form-group">
	                                <label class="col-sm-4 control-label" for="nombre"><s:property value="getText('default.name')"/>:</label>
	                                <div class="col-sm-7">
	                                	<input type="text" name="nombre" class="form-control" required/>
	                                    <s:fielderror fieldName="nombreError"/>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-4 control-label control-label" for="lugar"><s:property value="getText('default.place')"/>:</label>
	                                <div class="col-sm-7">
	                                	<input type="text" id="lugar" name="lugar" class="form-control" required>
	                                    <s:fielderror fieldName="lugarError"/>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-4 control-label control-label" for="descripcion"><s:property value="getText('event.description')"/>:</label>
	                                <div class="col-sm-7">
	                                	<textarea id="descripcion" class="form-control" cols="40" rows="3" name="descripcion"></textarea>
	                                    <s:fielderror fieldName="descripcionError"/>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-4 control-label control-label" for="fecha"><s:property value="getText('default.date')"/>:</label>
	                                <div class="col-sm-7">
	                                	<input type="text" name="fecha" id="fecha" class="form-control" autocomplete="off" required/>
	                                    <s:fielderror fieldName="fechaError"/>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-4 control-label control-label" for="horaComienzo"><s:property value="getText('event.starttime')"/>:</label>
	                                <div class="col-sm-7">
	                                	<input type="text" id="comienzo" name="horaComienzo" class="form-control" onchange="formatTime(this)" onblur="checkHora(this);" required/>
	                                    <s:fielderror fieldName="horaComienzoError"/>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label class="col-sm-4 control-label control-label" for="horaFin"><s:property value="getText('event.endtime')"/>:</label>
	                                <div class="col-sm-7">
	                                    <input type="text" id="fin" name="horaFin" class="form-control" onchange="formatTime(this)" onblur="checkHora(this);" required/>
	                                    <s:fielderror fieldName="horaFinError"/>
	                                </div>
	                            </div>
	                            
	                            <div class="row">
	                            	<div class="col-sm-offset-6 col.sm-6">
	                            		<s:submit value="%{getText('default.save')}" theme="simple" cssClass="btn btn-primary" id="guardar"/>
	                        			<button type="button" class="btn btn-default" data-dismiss="modal"><s:property value="getText('default.cancel')"/></button>
	                            	</div>
	                            </div>	                            
	                        </div>
	                        
	                        <div class="col-sm-6">
	                            <div id="map" style="width: 400px;height: 350px;"></div>
	                            <div class="invi" id="puntos"></div>
	                        </div>
	                     
	                    </s:form>
	                </div>
	            </div>
	        </div>>
	    </div>
	</div>
	
	<!-- Comienzo Modal Eliminar -->
	<div class="modal fade" id="eliminar-elemento" tabindex="-1" role="dialog" aria-labelledby="tituloModalEliminarEvento"
	     aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button aria-hidden="true" data-dismiss="modal" class="close" type="button"><span aria-hidden="true">&times;</span></button>
	                <h4 id="tituloModalEliminarEvento" class="modal-title"><s:property value="getText('default.delete')"/></h4>
	            </div>
	            <div class="modal-body"><s:property value="getText('default.confirmDelete')"/>
<!-- 	            ¿Esta seguro de -->
<!-- 	                eliminar este elemento? -->
	            </div>
	            <div class="modal-footer">
	                <button data-dismiss="modal" class="btn btn-primary" type="button"><s:property value="getText('default.delete')"/></button>
	                <button data-dismiss="modal" class="btn btn-default" type="button"><s:property value="getText('default.cancel')"/></button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- Fin Modal Eliminar -->
	
	<!-- Comienzo Modal Mapa -->
	<div class="modal fade" id="detalle-mapa" tabindex="-1" role="dialog" aria-labelledby="tituloModalDetalleMapa"
	     aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button aria-hidden="true" data-dismiss="modal" class="close" type="button"><span aria-hidden="true">&times;</span></button>
	                <h4 id="tituloModalDetalleMapa" class="modal-title"><s:property value="getText('default.mapLocation')"/></h4>
	            </div>
	            <div class="modal-body">
	               <div id="mapDetalle" style="width: 550px; height: 400px"></div>
	            </div>
	            <div class="modal-footer">
	            </div>
	        </div>
	    </div>
	</div>
	<!-- Fin Modal Eliminar -->
	
	
	
	<jsp:include page="scripts.jsp"/>
	
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
	<script src="${pageContext.request.contextPath}/resources/datepicker/js/bootstrap-datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/resources/customJS/funcionesAdmin.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/datatables/media/js/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/customJS/eventos.js"></script>
	
</body>
</html>