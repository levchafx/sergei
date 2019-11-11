<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<h1>Register form</h1>
	<br>
	<br>
	<c:out value="${error}"></c:out>

	<br>
	<br>
	<form method="POST"
		action="${pageContext.request.contextPath}/Register">
		
		name <input type="text" name="name"><br> <br>
		surname <input type="text" name="surname"><br> <br>
		email <input type="email" name="email"><br> <br>
		age <input type="text" name="age"><br> <br>
		login <input type="text" name="login"><br> <br>
		password <input type="password" name="password"><br> <br>
		confirm password<input type="password" name="confirmpassword"><br>
		<br> <input type="submit" value="Register">
	</form>
</body>
</html>