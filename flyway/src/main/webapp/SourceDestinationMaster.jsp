<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="com.flyway.pojo.Places"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Master list of places for source and destination</h2>
	<form action="sourceDestinationPlace" method="Post">
		<div>
			Enter the name of place for source and destination : <input type="text" name="place" />
		</div>
		<div>
			</br> <input type="submit" value="Submit">
		</div>
	</form>
	<div style="color: red;">${errors }</div>
	<div style="padding-top: 20px">
		<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<th>Place Name</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="place" items="${listPlaces}">
				<tr>
					<td>${place.placeName }</td>
					<td><a id="linkId"
						href="<%=request.getContextPath()%>/sourceDestinationPlace?edit=${place.placeId}">Update</a>
					</td>
					<td><a id="linkId1"
						href="<%=request.getContextPath()%>/sourceDestinationPlace?delete=${place.placeId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>