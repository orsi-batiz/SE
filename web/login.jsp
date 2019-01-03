<%--
  Created by IntelliJ IDEA.
  User: Batiz
  Date: 11/17/2018
  Time: 12:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>

</head>
<body>

<div style="text-align: center;">
    <h1> WELCOME </h1>
</div>

<jsp:useBean id="user" class="Models.User" scope="request"/>

<div>
    <form action="/login.do" method="POST">
        <table>
            <tr>
                <td>
                    User name:
                </td>
                <td>
                    <input type="text" name="username" value=<%= user.getUsername() %>>
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <input type="password" name="password" value=<%= user.getPassword() %>>
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" name="Submit">
    </form>

    <p style="color:red"><%= user.getError() %></p>
</div>

</body>
</html>
