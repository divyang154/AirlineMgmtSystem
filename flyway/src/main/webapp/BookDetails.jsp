<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<h2>Flight Details</h2>
	<form action="bookingDetail" method="Post">
	<div style="padding-top: 20px; margin-left: 7%;">
		Airlines Name : <input type="text" readonly
			value="${sessionScope.flight.airlines.name}">
	</div>
	<div style="padding-top: 20px; margin-left: 8%;">
		Source Place : <input type="text" readonly
			value="${sessionScope.flight.sourcePlace.placeName}">
	</div>
	<div style="padding-top: 20px; margin-left: 6%;">
		Destination Place : <input type="text" readonly
			value="${sessionScope.flight.destinationPlace.placeName}">
	</div>
	<div style="padding-top: 20px; margin-left: 7%;">
		Date of Travel : <input type="text" readonly
			value="${sessionScope.flight.arrivalDate}">
	</div>
	<div style="padding-top: 20px; margin-left: 11.5%;">
		Price : <input type="text" readonly
			value="${sessionScope.flight.price}">
	</div>
	<div style="margin-left: 10%; margin-top: 3%">
		<input type="submit" value="Make Payment" />
	</div>
	</form>
</body>
</html>