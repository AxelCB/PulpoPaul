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
                <li><a href="listarEventos">Eventos acad&eacute;micos</a></li>
                <li><a href="usuario/listar">AB Usuarios</a></li>
                <li><a href="denuncia/listar">Denuncias</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href='<s:url action="logout"/>'>Log Out</a></li>
            </ul>
        </div>
    </div>
</nav>