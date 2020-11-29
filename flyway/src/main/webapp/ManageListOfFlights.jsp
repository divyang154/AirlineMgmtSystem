<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2 style="margin-top: 2%; margin-left: 4%">Manage List Of Flights</h2>
	<form action="manageFlight" method="Post">
		<div style="margin-top: 2%; margin-left: 4%">
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
			<div style="margin-left: 7%; margin-top: 1%">
				Select Airline :&nbsp; <select name="airlinesSelect">
					<c:forEach items="${airlinesList}" var="airlines">
						<option value="${airlines.airlineId}">${airlines.name}</option>
					</c:forEach>
				</select>
			</div>
			<div style="margin-top: 1%">
				<span> Please enter your ticket price : </span><span><input
					type="text" name="ticketPrice" placeholder="Enter ticket Price"></span>
			</div>
			<div style="margin-top: 1%">
				<span style="margin-left: 6%;"> Please enter date: </span><span><input
					type="date" name="dateOfTravel" placeholder="Enter date of travrl"></span>
			</div>
			<br />
			<div style="margin-left: 10%; margin-top: 1%">
				<input type="submit" value="Submit" />
			</div>
		</div>
		<div style="color: red;">${errors }</div>
	</form>
	<div style="padding-top: 20px">
		<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<th>Airlines</th>
				<th>Source Place</th>
				<th>Destination Place</th>
				<th>Price</th>
				<th>Date</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="flight" items="${flightList}">
				<tr>
					<td>${flight.airlines.name }</td>
					<td>${flight.sourcePlace.placeName }</td>
					<td>${flight.destinationPlace.placeName }</td>
					<td>${flight.price }</td>
					<td>${flight.arrivalDate }</td>
					<td><a id="linkId"
						href="<%=request.getContextPath()%>/manageFlight?edit=${flight.flightId}">Update</a></td>
					<td><a id="linkId1"
						href="<%=request.getContextPath()%>/manageFlight?delete=${flight.flightId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>