<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Sum Page</title>
</head>

<body>
<form method="POST" class="form-signin" action="./sendData">
    Please enter number 1*

    <input type="text" name="number1" id="number1" required class="form-control"/>
    <br/>
    <br/>
    Please enter number 2*

    <input type="text" name="number2" id="number2" required class="form-control"/>

    <br/>
    <br/>
    <input type="submit" class="btn btn-primary" value="Get sum ${sum}">
    <c:choose>
        <c:when test="${requestScope.user == null }">
            <br/>
            <br/>
            <a href="./doLogout">Logout</a>
        </c:when>
        <c:otherwise>
            <br/>
            <br/>
            <a href="./register.jsp">Register</a>
            &nbsp;
            &nbsp;
            <a href="./login.jsp">Login</a>
        </c:otherwise>
    </c:choose>

</form>
</body>
</html>