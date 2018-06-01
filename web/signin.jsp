<%--
  Created by IntelliJ IDEA.
  User: jetae
  Date: 31/5/2018
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrar</title>
</head>
<body>
<h1>Por favor, registrate</h1>

<form action="/signin" method="post">
    Ingrese su usuario: <input type="text" name="usuario" width="45"/>
    <p></p>
    Ingrese su Contraseña: <input type="password" name="password" width="45"/>
    <p></p>
    <input type="submit" value="Sign-In"/>
</form>
<p>${confirmation}</p>

</body>
</html>
