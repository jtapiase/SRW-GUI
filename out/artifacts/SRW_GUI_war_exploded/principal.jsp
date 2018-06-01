<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: jetae
  Date: 31/5/2018
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Pagina principal</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>Bienvenido</h1>
<div class="navbar">
    <div class="navbar-left">
        <a href="login.jsp">Login</a>
        <a href="index.jsp">Index</a>
    </div>
</div>
<div class="main-div">
    <h1>Bienvenido ${usuario}</h1>
</div>
<table id="t01">
    <thead>
    <tr>
        <th>Codigo</th>
        <th>Principo Activo</th>
        <th>Codigo ATC</th>
        <th>Descripcion</th>
        <th>Cantidad</th>
        <th>Unidad Medida</th>
        <th>Forma Farmaceutica</th>
        <th>Aclaracion</th>
        <th>Calificación</th>
    </tr>
    </thead>
    <tbody>



    <%
        String host ="jdbc:mysql://52.167.225.0:3307/SDRW";
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(host,"userd2r","D2R/user*");
        stat = conn.createStatement();
        String us = (String)request.getAttribute("usuario");
        String data = "SELECT * FROM `medicamentos_pos` mp JOIN medicamentos_users mu ON mp.codigo = mu.idMedicamento JOIN usuarios us ON us.id = mu.idUser WHERE us.username='carlos';";
        res =stat.executeQuery(data);
        while (res.next()){
    %>
    <tr>
        <td name="id"><%= res.getString("codigo")%></td>
        <td><%= res.getString("principio_activo")%></td>
        <td><%= res.getString("codigo_atc")%></td>
        <td><%= res.getString("descripcionatc")%></td>
        <td><%= res.getString("cantidad")%></td>
        <td><%= res.getString("unidad_medida")%></td>
        <td><%= res.getString("forma_farmaceutica")%></td>
        <td><%= res.getString("aclaracion")%></td>
        <td><%= res.getString("mu.calificacion")%></td>
    </tr>

    <%
        }

    %>
    </tbody>
</table>
<div class="main-div">
    <form action="/calificar" method="post">
        Ingrese Calificación: <input type="number" name="calificacion" width="45"/>
        <button class="login-btn" type="submit" value="calificar">calificar</button>
    </form>
</div>
</body>
</html>