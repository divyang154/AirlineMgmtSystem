<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<h2>Register User</h2>
	<form action="registerUser" method="Post">
		<div style="margin-top: 2%; margin-left: 2%">
			Enter the username : <input type="text" name="username"  value="${username}"/>
		</div>
		<div style="margin-top: 2%; margin-left: 2%">
			Enter the password : <input type="text" name="password" value="${password}"/>
		</div>
		<div style="margin-top: 2%; margin-left: 4%">
			Enter the email : <input type="text" name="email" value="${email}"/>
		</div>
		<div style="padding-top: 20px; margin-left: 15%;">
			<input type="submit" value="Submit">
		</div>
		<div style="color: red; margin-left: 1%;">
		${error}
		</div>
	</form>
</body>
</html>
