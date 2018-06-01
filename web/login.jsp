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
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="navbar">
        <div class="navbar-left">
            <a href="login.jsp">Login</a>
            <a href="index.jsp">Index</a>
        </div>
    </div>
    <div class="main-div">
        <h1>Por favor, inicie sesión</h1>
        <form action="/login" method="post">
            Ingrese usuario: <input type="text" name="usuario" width="45"/>
            <p></p>
            Ingrese Contraseña: <input type="password" name="password" width="45"/>
            <p></p>
            <button class="login-btn" type="submit" value="log-In">login</button>
        </form>
        <p>${confirmation}</p>
    </div>


</body>
</html>
