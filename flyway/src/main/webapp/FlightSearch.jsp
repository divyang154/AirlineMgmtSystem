<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Flight Search</title>
</head>
<body>
	<h2 style="margin-top: 2%; margin-left: 4%">Flight Search</h2>
	<form action="flightSearch" method="Post">
		<div style="margin-left: 4%">
			Select Source Place :&nbsp; <select name="placeSelect">
				<c:forEach items="${placeList}" var="place">
					<option value="${place.placeId}">${place.placeName}</option>
				</c:forEach>
			</select>
		</div>
		<div style="margin-left: 2%; margin-top: 1%">
			Select Destination Place :&nbsp; <select
				name="placeSelectDestination">
				<c:forEach items="${placeList}" var="place">
					<option value="${place.placeId}">${place.placeName}</option>
				</c:forEach>
			</select>
		</div>
		<div style="margin-top: 1%">
			<span style="margin-left: 6%;"> Please enter date: </span><span><input
				type="date" name="dateOfTravel" placeholder="Enter date of travel"></span>
		</div>
		<div style="margin-left: 1%; margin-top: 1%">
			Enter the number of person: <input type="number" required min="1" max="100" name="noOfPerson">
		</div>
		<div style="margin-left: 10%; margin-top: 1%">
			<input type="submit" value="Search">
		</div>
	</form>
</body>
</html>