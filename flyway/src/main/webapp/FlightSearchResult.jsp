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
	<div style="padding-top: 20px">
		<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<th>Airlines</th>
				<th>Source Place</th>
				<th>Destination Place</th>
				<th>Price</th>
				<th>Date</th>
				<th>Book Flight</th>
			</tr>
			<c:forEach var="flight" items="${flightList}">
				<tr>
					<td>${flight.airlines.name }</td>
					<td>${flight.sourcePlace.placeName }</td>
					<td>${flight.destinationPlace.placeName }</td>
					<td>${flight.price }</td>
					<td>${flight.arrivalDate }</td>
					<td><a id="linkId"
						href="<%=request.getContextPath()%>/registerUser?fNo=${flight.flightId}">Book Flight</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>