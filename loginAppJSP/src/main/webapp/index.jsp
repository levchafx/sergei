<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<body>
	<h1>Welcome to my wonderful LoginApp</h1>
	<br>
	<c:if test="${user==null }">
	<a href="register.jsp">Register</a>
	</c:if>
	<br>


	<c:if test="${user!=null }">
Welcome <c:out value="${sessionScope.user} "></c:out>
		<br>
Your access is <c:out value="${sessionScope.role}"></c:out>
<c:if test="${'ADMIN'==sessionScope.role }">
<br>
<br>
<c:out value="${requestScope.error }" ></c:out>
<form action="AddAdmin" method = "post">
        name <input type="text" name="name"><br> <br>
		surname <input type="text" name="surname"><br> <br>
		email <input type="email" name="email"><br> <br>
		age <input type="text" name="age"><br> <br>
		login<input type="text" name="login"  >
			<br>
		password<input type="password" name="password"  >
			<br>
		role<select name="role" >
			<option>ADMIN</option>
			<option>USER</option>
			</select>
			<br>
<input type="submit" value="AddUser">
</form>
</c:if>
		<br>

		<c:forEach items="${sessionScope.users }" var="user">
			<c:out value="${user }"></c:out>
			<br>
			<c:if test="${sessionScope.user ne user.login}">
			<form action="Delete" method = "post">
			<input type="hidden" name="login" value="${user.login}" />
<input type="submit" value="Delete">
</form>
<form action="Update" method = "post">
			<input type="hidden" name="login" value="${user.login}" />
<input type="submit" value="Update">
</form>
			</c:if>
			<br>
		</c:forEach>
		<br>
		<a href="Logout">Logout</a>
	</c:if>
	<c:if test="${user==null}">
		<a href="login.jsp">Login</a>
	</c:if>
</body>
</html>