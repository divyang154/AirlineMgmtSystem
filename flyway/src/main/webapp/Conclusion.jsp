<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Booked Flight Details</h2>
	<form action="bookingDetail" method="Post">
		<div style="padding-top: 20px; margin-left: 90px;">
			Airlines Name : <input type="text" readonly
				value="${sessionScope.flight.airlines.name}">
		</div>
		<div style="padding-top: 20px; margin-left: 100px;">
			Source Place : <input type="text" readonly
				value="${sessionScope.flight.sourcePlace.placeName}">
		</div>
		<div style="padding-top: 20px; margin-left: 70px">
			Destination Place   : <input type="text" readonly
				value="${sessionScope.flight.destinationPlace.placeName}">
		</div>
		<div style="padding-top: 20px; margin-left: 90px;">
			Date of Travel : <input type="text" readonly
				value="${sessionScope.flight.arrivalDate}">
		</div>
		<div style="padding-top: 20px; margin-left: 150px;">
			Price : <input type="text" readonly
				value="${sessionScope.flight.price}">
		</div>
		<div style="padding-top: 20px; margin-left: 120px;">
			Username : <input type="text" readonly
				value="${sessionScope.loggedInUser.username}">
		</div>
		<div style="padding-top: 20px; margin-left: 154px;">
			Mail : <input type="text" readonly
				value="${sessionScope.loggedInUser.userEmail}">
		</div>
		<div style="padding-top: 20px; margin-left: 56px;">
			Number Of Persons : <input type="text" readonly
				value="${booking.noOfPerson}">
		</div>
		<div style="padding-top: 20px; margin-left: 100px;">
			<a id="linkId" href="<%=request.getContextPath()%>/bookingDetail">View
				My Bookings</a>
		</div>
	</form>
</body>
</html>