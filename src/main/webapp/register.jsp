<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Register Page</title>
</head>

<body>

<form method="POST" class="form-signin" action="./doRegister">
    Please enter username*

    <input type="text" name="username"  class="form-control"/>
    Please enter email*

    <input type="text" name="email"  class="form-control"/>
	<br/>
	<br/>
    Please enter password*

    <input type="text" name="password"  class="form-control"/>
	<br/>
	<br/>

    <label for="firstname">Please enter first name*</label>
    <input type="text" name="firstname"  id="firstname" class="form-control"/>
    <label for="lastname">Please enter last name*</label>


    <input type="text" name="lastname"  id="lastname" class="form-control"/>
    <br/>
    <br/>
    Please enter date of birth*

    <input type="date" name="dob"  class="form-control"/>

    <br/>
    <br/>
    <input type="submit" class="btn btn-primary" value="Register">
    <br/>
    <br/>
    <c:if test="${false}">
    <div class="alert alert-danger" role="alert">
           de ce se afiseaza asta ? ${errorMessage}
    </div>
    </c:if>
    <br/>
    <br/>
    <a href="./">Sum</a>
    &nbsp;
    &nbsp;
    <a href="login.jsp">Login</a>
</form>
</body>
</html>