
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.flyway.pojo.Airlines"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Airlines Name</title>
</head>
<body>
	<form action="airlinesMaster?edit=${airline.airlineId}" method="Post">
		<tr>
			<th>Airline Name:</th>
			<td><input type="text" name="airlineName" size="45"
				value="${airline.name}" /></td>
		</tr>
		<div>
			</br> <input type="submit" value="Update">
		</div>
		<div style="color: red;">${errors }</div>
	</form>
</body>
</html>