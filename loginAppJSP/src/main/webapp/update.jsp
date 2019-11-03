<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
</head>
<body>
<h2>Update</h2>

<c:out value="${error}"></c:out>
	<form method="POST"
		action="${pageContext.request.contextPath}/Save">
        id<input type="text" readonly name="id" value="${user.id }"><br> <br>
		name <input type="text" name="name" value="${user.name }"><br> <br>
		surname <input type="text" name="surname" value = "${user.surname}"><br> <br>
		email <input type="email" name="email" value = "${user.email}"><br> <br> age
		<input type="text" name="age" value = "${user.age}"><br> <br> login <input
			type="text" name="login" value = "${user.login}"><br> <br> password <input
			type="text" name="password" value = "${user.password}"><br> <br> 
			profile enabled<input type="text" readonly name="profile_enable" value = "${user.profile_enable}"><br><br>
			role<input type="text" readonly name="role" value = "${user.role}">
	<br>
		<br> <input type="submit" value="Update">
	</form>
</body>
</html>