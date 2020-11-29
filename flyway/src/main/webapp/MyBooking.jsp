<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Bookings</title>
</head>
<body>
	<h2>Booked Flight Details</h2>
	<div style="padding-top: 20px">
		<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<th>Airlines</th>
				<th>Source Place</th>
				<th>Destination Place</th>
				<th>Price</th>
				<th>Date</th>
				<th>Number of Person</th>
			</tr>
			<c:forEach var="bookDetail" items="${bookingDetail}">
				<tr>
					<td>${bookDetail.flight.airlines.name }</td>
					<td>${bookDetail.flight.sourcePlace.placeName }</td>
					<td>${bookDetail.flight.destinationPlace.placeName }</td>
					<td>${bookDetail.flight.price }</td>
					<td>${bookDetail.flight.arrivalDate }</td>
					<td>${bookDetail.noOfPerson }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>