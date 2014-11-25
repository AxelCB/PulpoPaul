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
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css" rel="stylesheet">
  <title>Tests</title>
</head>
<body>
  <table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>Nombre del Test</th>
        <th>Resultado</th>
      </tr>
    </thead>
    <tbody>
      <% List<String> tests = (List<String>) config.getServletContext().getAttribute("testList");
        for(String test : tests){ %>
          <tr>
            <td><%=test %></td>
            <%--<td><a id="<%=test %>" href="../TestServlet?<%=test %>">Probar</a></td>--%>
            <td ></td>
          </tr>
        <% } %>
    </tbody>
  </table>

  <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
  <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
  <script src="//code.jquery.com/ui/1.11.0/jquery-ui.min.js"></script>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
