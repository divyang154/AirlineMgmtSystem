<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2 style="margin-top: 2%; margin-left: 4%">Update List Of Flights</h2>
	<form action="manageFlight?edit=${flight.flightId}" method="Post">
		<div style="margin-top: 2%; margin-left: 4%">
			<div style="margin-left: 4%">
				Select Source Place :&nbsp; <select name="placeSelect">
					<c:forEach items="${placeList}" var="place">
						<option value="${place.placeId}"
							${place.placeId == flight.sourcePlace.placeId ? 'selected="selected"' : ''}>${place.placeName}</option>
					</c:forEach>
				</select>
			</div>
			<div style="margin-left: 2%; margin-top: 1%">
				Select Destination Place :&nbsp; <select
					name="placeSelectDestination">

					<c:forEach items="${placeList}" var="place">
						<option value="${place.placeId}"
							${place.placeId == flight.destinationPlace.placeId ? 'selected="selected"' : ''}>${place.placeName}</option>
					</c:forEach>
				</select>
			</div>
			<div style="margin-left: 7%; margin-top: 1%">
				Select Airline :&nbsp; <select name="airlinesSelect">
					<c:forEach items="${airlinesList}" var="airlines">
						<option value="${airlines.airlineId}"
							${airlines.airlineId == flight.airlines.airlineId ? 'selected="selected"' : ''}>${airlines.name}</option>
					</c:forEach>
				</select>
			</div>
			<div style="margin-top: 1%">
				<span> Please enter your ticket price : </span><span><input
					value="${flight.price}" type="text" id="ticketId"
					name="ticketPrice" placeholder="Enter ticket Price"></span>
			</div>
			<div style="margin-top: 1%">
				<span style="margin-left: 6%;"> Please enter date: </span><span><input
					id="dateId" type="date" name="dateOfTravel" value="${date}"
					placeholder="Enter date of travrl"></span>
			</div>
			<br />
			<div style="margin-left: 10%; margin-top: 1%">
				<input type="submit" value="Update" />
			</div>
		</div>
		<div style="color: red;">${errors }</div>
	</form>
</body>
</html>