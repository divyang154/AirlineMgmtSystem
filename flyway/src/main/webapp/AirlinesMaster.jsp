<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.List"%>
<%@ page import="com.flyway.pojo.Airlines"%>
<%@ page import="com.flyway.pojo.Airlines"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Airlines Master</title>
</head>
<body>
	<h2>Master list of airlines</h2>
	<form action="airlinesMaster" method="Post">
		<div>
			Enter the name of Airlines : <input type="text" name="airlinesName" />
		</div>
		<div>
			</br> <input type="submit" value="Submit">
		</div>
	</form>
	<div style="color: red;">${errors }</div>
	<div style="padding-top: 20px">
		<table border="1" cellpadding="2" cellspacing="2">
			<tr>
				<th>Airlines Name</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="listAir" items="${listAir }">
				<tr>
					<td>${listAir.name }</td>
					<td><a id="linkId"
						href="<%=request.getContextPath()%>/airlinesMaster?edit=${listAir.airlineId}">Update</a>
					</td>
					<td><a id="linkId1"
						href="<%=request.getContextPath()%>/airlinesMaster?delete=${listAir.airlineId}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>