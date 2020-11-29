<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.flyway.pojo.Airlines"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Source Destination Master Name</title>
</head>
<body>
<h2>Update Source Destination Master Name</h2>
	<form action="sourceDestinationPlace?edit=${place.placeId}" method="Post">
		<tr>
			<th>Place Name:</th>
			<td><input type="text" name="placeName" size="45"
				value="${place.placeName}" /></td>
		</tr>
		<div>
			</br> <input type="submit" value="Update">
		</div>
		<div style="color: red;">${errors }</div>
	</form>
</body>
</html>