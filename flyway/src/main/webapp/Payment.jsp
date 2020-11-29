<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Make Payment</h2>
	<form action="registerUser" method="Post">
		<div style="padding-top: 2%; margin-left: 1%;">
			Credit Card Number : <input type="text" pattern="[0-9.]+" name="username" />
		</div>
		<div style="padding-top: 2%; margin-left: 4%;">
			CVV Number : <input type="text" name="password" />
		</div>
		<div style="padding-top: 2%; margin-left: 5%;">
			Expiry Date : <input type="month" name="email" />
		</div>
		<div style="padding-top: 2%; margin-left: 15%;">
			<input type="submit" value="Submit">
		</div>
	</form>
</body>
</html>