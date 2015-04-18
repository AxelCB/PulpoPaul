<%@ taglib prefix="s" uri="/struts-tags" %>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">${usuario.getNombres()}, ${usuario.getApellido()}</a>
            </div>
            <ul class="nav navbar-nav">
<!--                 <li class="dropdown"> -->
<%--                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">ABMs <span class="caret"></span></a> --%>
<!--                     <ul class="dropdown-menu" role="menu"> -->
<!--                     	<li><a href="usuario/listar">Usuarios</a></li> -->
<!--                         <li><a href="enConstruccion">Recorridos</a></li> -->
<!--                         <li><a href="enConstruccion">Mensajes</a></li> -->
<!--                          <li><a href="/PulpoPaul/admin/abmUsuarios.jsp">Usuarios</a></li> -->
<!--                          <li><a href="/PulpoPaul/admin/abmRecorridos.jsp">Recorridos</a></li> -->
<!--                          <li><a href="/PulpoPaul/admin/abmMensajes.jsp">Mensajes</a></li> -->
<!--                     </ul> -->
<!--                 </li> -->
                <li><a href="listarEventos"><s:property value="getText('menu.events')"/></a></li>
                <li><a href="usuario/listar"><s:property value="getText('menu.users')"/></a></li>
                <li><a href="denuncia/listar"><s:property value="getText('menu.complaints')"/></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href='<s:url action="logout"/>'><s:property value="getText('default.logout')"/></a></li>
            </ul>
        </div>
    </div>
</nav>