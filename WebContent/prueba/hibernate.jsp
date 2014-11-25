<%@ page import="unlp.ttpsInfoPoolCBR.dao.usuario.IUsuarioDao" %>
<%@ page import="unlp.ttpsInfoPoolCBR.dao.usuario.UsuarioDaoJPAImpl" %>
<%@ page import="unlp.ttpsInfoPoolCBR.model.Usuario" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Axel
  Date: 23/11/2014
  Time: 04:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

  <% IUsuarioDao usuarioDao = new UsuarioDaoJPAImpl();
    List<Usuario> usuarioList = usuarioDao.listar();
    for (Usuario user : usuarioList) {
        out.print(user.getEmail());
    }
  %>

</body>
</html>
