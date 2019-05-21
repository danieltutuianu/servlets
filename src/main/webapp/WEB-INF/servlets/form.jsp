<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
                                <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<title>Login Page</title>
	</head>

	<body>
	<c:if test="${validation == true}">
	        <h3>Validation failed </h3>
	</c:if>

<c:if test="${validation == false}">
	       <h2>Portocale</h2>
	</c:if>

<h1>param=${validation}</h1>

 <p>Today's date: <%= (new java.util.Date()).toLocaleString()%></p>

		<form method="POST" action="sendData">

			Please enter your username

			Please enter your password
			<input type="text" name="username"/>

			<input type="submit" value="submit">

		</form>
	</body>
</html>