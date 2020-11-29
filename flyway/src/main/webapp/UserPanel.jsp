<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Panel</title>
</head>
<body>
	<h2>Welcome ${sessionScope.loggedInUser.username}</h2>
	<h3>You can navigate to following pages</h3>
	<div>
		<a id="linkId" href="<%=request.getContextPath()%>/bookingDetail">View
			My Bookings</a>
	</div>
	<div style="padding-top: 30px">
		<a id="linkId" href="<%=request.getContextPath()%>/flightSearch"> Search And Book Flights </a>
	</div>
</body>
</html>