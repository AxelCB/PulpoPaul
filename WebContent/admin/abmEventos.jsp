<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/customCSS/jquery-gmaps-latlon-picker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/customCSS/CustomViajeroStyle.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home Admin</title>
</head>
<body>
<!-- Comienzo menu barra admin -->
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Nombre Admin</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">ABMs <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="/PulpoPaul/admin/abmUsuarios.jsp">Usuarios</a></li>
                        <li><a href="/PulpoPaul/admin/abmRecorridos.jsp">Recorridos</a></li>
                        <li><a href="/PulpoPaul/admin/abmMensajes.jsp">Mensajes</a></li>
                    </ul>
                </li>
                <li><a href="/PulpoPaul/admin/abmEventos.jsp">Eventos acad&eacute;micos</a></li>
                <li><a href="/PulpoPaul/admin/denuncias.jsp">Denuncias</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href='<s:url action="logout"/>'>Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Fin del menu barra admin -->

<!-- Comienzo de pagina -->
<div class="container">
    <div class="jumbotron">
        <h2>Gesti&oacute;n de Eventos Acad&eacute;micos</h2>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Nombre</th>
                <th>Lugar</th>
                <%--<th>Latitud</th>
                <th>Longitud</th>--%>
                <th>Descripci&oacute;n</th>
                <th>Fecha</th>
                <th>Hora comienzo</th>
                <th>Hora fin</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="eventos" var="evento">
                <tr>
                    <td><s:property value="%{#evento.getNombre()}" /></td>
                    <td><s:property value="%{#evento.getLugar()}" /></td>
                    <%--<td><s:property value="%{#evento.getLatitud()}" /></td>
                    <td><s:property value="%{#evento.getLongitud()}" /></td>--%>
                    <td><s:property value="%{#evento.getDescripcion()}" /></td>
                    <td><s:date name="%{#evento.getFecha()}" format="EEEE yyyy-MM-dd" /><hr> </td>
                    <td><s:property value="%{#evento.getHoraComienzo()}" /></td>
                    <td><s:property value="%{#evento.getHoraFin()}" /></td>
                    <td><a href="#" onclick="mostrarModalMapa(<s:property value="%{#evento.getLatLng()}"/>);"><span class="glyphicon glyphicon-map-marker"></span></a>
                    </td>
                    <td><a href="#" onclick="mostrarModalNuevoEvento();"><span
                            class="glyphicon glyphicon-pencil"></span></a>
                    <td><a href="#" onclick="mostrarModalEliminar();"><span class="glyphicon glyphicon-trash"></span></a>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <div class="row">
            <button class="btn btn-primary" onclick="mostrarModalNuevoEvento();">Agregar nuevo</button>
        </div>
    </div>
</div>
<!-- Fin de pagina -->

<!-- Comienzo Modal Nuevo Evento -->
<div class="modal fade" id="nuevo-evento" tabindex="-1" role="dialog" aria-labelledby="tituloModalNuevoEvento"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 class="modal-title" id="tituloModalNuevoEvento">Nuevo evento</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <s:form action="eventos/guardar" method="post" theme="simple" cssClass="form-horizontal" enctype="multipart/form-data">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="nombre">Nombre:</label>
                                <div class="col-sm-7">
                                    <s:textfield name="nombre" theme="simple" cssClass="form-control"/>
                                    <s:fielderror fieldName="nombreError"/>
                                </div>
                            </div>
                            <!-- 					SELECT -->
                            <div class="form-group">
                                <label class="col-sm-4 control-label control-label" for="lugar">Lugar</label>
                                <div class="col-sm-7">
                                    <s:textfield id="lugar" name="lugar" theme="simple" cssClass="form-control"/>
                                    <s:fielderror fieldName="lugarError"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label control-label"
                                       for="descripcion">Descripci&oacute;n</label>

                                <div class="col-sm-7">
						  		    <s:textarea id="descripcion" theme="simple" cssClass="form-control" cols="40"
                                          rows="3" name="descripcion"></s:textarea>
                                    <s:fielderror fieldName="descripcionError"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label control-label" for="fecha">Fecha</label>
                                <div class="col-sm-7">
                                    <s:textfield name="fecha" id="fecha" theme="simple" cssClass="form-control"/>
                                    <s:fielderror fieldName="fechaError"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label control-label" for="horaComienzo">Hora comienzo</label>
                                <div class="col-sm-7">
                                    <s:textfield name="horaComienzo" theme="simple" cssClass="form-control"/>
                                    <s:fielderror fieldName="horaComienzoError"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label control-label" for="horaFin">Hora fin</label>
                                <div class="col-sm-7">
                                    <s:textfield name="horaFin" theme="simple" cssClass="form-control" id="fin"/>
                                    <s:fielderror fieldName="horaFinError"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <!-- Para mostrar un punto poner la lat y la long en el value, para guardar un punto sacarlos de ahi -->
                            <fieldset class="gllpLatlonPicker">
                                <div class="gllpMap">Google Maps</div>
                                <s:textfield type="hidden" class="gllpLatitude" value="-34.921549" name="latitud"/>
                                <s:textfield type="hidden" class="gllpLongitude" value="-57.954512" name="longitud"/>
                                <input type="hidden" class="gllpZoom"/>
                            </fieldset>
                        </div>
                        <s:submit value="Guardar" theme="simple" cssClass="btn btn-primary" />
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>

                    </s:form>
                </div>
            </div>
            <%--<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">Guardar</button>
            </div>--%>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!-- Comienzo Modal Eliminar -->
<div class="modal fade" id="eliminar-elemento" tabindex="-1" role="dialog" aria-labelledby="tituloModalEliminarEvento"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" data-dismiss="modal" class="close" type="button"><span aria-hidden="true">&times;</span></button>
                <h4 id="tituloModalEliminarEvento" class="modal-title">Eliminar</h4>
            </div>
            <div class="modal-body">¿Esta seguro de
                eliminar este elemento?
            </div>
            <div class="modal-footer">
                <button data-dismiss="modal" class="btn btn-primary" type="button">Eliminar</button>
                <button data-dismiss="modal" class="btn btn-default" type="button">Cancelar</button>
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
                <h4 id="tituloModalDetalleMapa" class="modal-title">Ubicaci&oacute;n en Mapa</h4>
            </div>
            <div class="col-sm-6">
                <!-- Para mostrar un punto poner la lat y la long en el value, para guardar un punto sacarlos de ahi -->
                <fieldset class="gllpLatlonPicker">
                    <div class="gllpMap">Google Maps</div>
                    <input type="hidden" class="gllpLatitude" value="-34.921549" name="latitudModal"/>
                    <input type="hidden" class="gllpLongitude" value="-57.954512" name="longitudModal"/>
                    <input type="hidden" class="gllpZoom"/>
                </fieldset>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
<!-- Fin Modal Eliminar -->



<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.min.js"></script>

<script>
    $(function() {
        $( "#fecha" ).datepicker({dateFormat : "dd/mm/yy"});
    });
</script>

<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/customJS/funcionesAdmin.js"></script>

<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script src="${pageContext.request.contextPath}/resources/customJS/jquery-gmaps-latlon-picker.js"></script>
</body>
</html>