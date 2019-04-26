<%--
  Created by IntelliJ IDEA.
  User: Павел
  Date: 24.04.2019
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<form action="registration" method="post">
    UserName <input type="text" name="login"/>
    Password <input type="text" name="password"/>
    <input value="Register" type="submit"/>
</form>

<form action="login" method="post">
    UserName <input type="text" name="login"/>
    Password <input type="text" name="password"/>
    <input value="Login" type="submit"/>
</form>
<br/>
<a href="view.jsp">View all users</a>
</body>
</html>

