<%--
  Created by IntelliJ IDEA.
  User: jetae
  Date: 31/5/2018
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Por favor, inicie sesión</h1>

    <form action="/login" method="post">
        Ingrese usuario: <input type="text" name="usuario" width="45"/>
        <p></p>
        Ingrese Contraseña: <input type="password" name="password" width="45"/>
        <p></p>
        <input type="submit" value="log-In"/>
    </form>

    <p style="color:red">${errorMessage}</p>
</body>
</html>
