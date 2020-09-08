<%--
  Created by IntelliJ IDEA.
  User: danieltu
  Date: 06/09/2020
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Post Login</title>
</head>
<body>
<div class="form-signin">
    <br/>
    <br/>
    <div class="alert alert-success" role="alert">
        Hello ${user.firstname}-${user.lastname}
    </div>
    <br/>
    <br/>
    <div><a href="./">Sum</a></div>
    <br/>
    <div><a href="./doLogout">Logout</a></div>
</div>
</body>
</html>
