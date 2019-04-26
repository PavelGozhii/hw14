<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 24.04.2019
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All information</title>
</head>
<body>
<table>
    <%
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hw14", "postgres", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                out.write("<tr><td>" + login + "</td><td>" + password + "</td></tr>");
            }
        } catch (SQLException e) {
        }
    %>
</table>
<br/>
<a href="index.jsp">Home</a>
</body>
</html>
