<%--
  Created by IntelliJ IDEA.
  User: Batiz
  Date: 11/17/2018
  Time: 1:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
Hello World!
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    if(session.getAttribute("username") == null)
        response.sendRedirect("/login.jsp");
%>
////Probald ki swing buttonokoat igy java kod szerint
</body>
</html>
