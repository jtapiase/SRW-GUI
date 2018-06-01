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
        String data = "select * from medicamentos_pos";
        res =stat.executeQuery(data);
        while (res.next()){
    %>
    <tr>
        <td><%= res.getString("codigo")%></td>
        <td><%= res.getString("principio_activo")%></td>
        <td><%= res.getString("codigo_atc")%></td>
        <td><%= res.getString("descripcionatc")%></td>
        <td><%= res.getString("cantidad")%></td>
        <td><%= res.getString("unidad_medida")%></td>
        <td><%= res.getString("forma_farmaceutica")%></td>
        <td><%= res.getString("aclaracion")%></td>
    </tr>

    <%
        }

    %>
    </tbody>
</table>
</body>
</html>