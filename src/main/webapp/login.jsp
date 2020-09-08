<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <jsp:include page="head.jsp" />
    <title>Login Page</title>
</head>

<body>
<form method="POST" class="form-signin" action="doLogin">
    Please enter username / email*

    <input type="text" name="username"   class="form-control"/>
    <br />
    <br />
    Please enter password*

    <input type="text" name="password"  class="form-control"/>
    <br />
    <br />
    <input type="submit" class="btn btn-primary" value="Login">

    <br />
    <br />
    <c:if test="${false}">
        <div class="alert alert-danger" role="alert">
            ${errorMessage}
        </div>
    </c:if>
    <c:if test="${userID != null}">
        <div class="alert alert-info" role="alert">
                Account created. Now you can login.
        </div>
    </c:if>
    <br />
    <br />
    <a href="./">Sum</a>
    &nbsp;
    &nbsp;
    <a href="register.jsp">Register</a>
</form>
</body>
</html>