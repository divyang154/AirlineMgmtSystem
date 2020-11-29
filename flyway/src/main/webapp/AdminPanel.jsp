<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome ${sessionScope.loggedInUser.username}</h2>
<h3>You can navigate to following pages</h3>
<div>
<a id="linkId" href="<%=request.getContextPath()%>/airlinesMaster">Airlines Master</a>
</div>
</br>
<div>
<a id="linkId" href="<%=request.getContextPath()%>/sourceDestinationPlace">Source Destination Master</a>
</div>
</br>
<div>
<a id="linkId" href="<%=request.getContextPath()%>/manageFlight">Manage List Of Flights</a>
</div>
</br>
<div>
<a id="linkId" href="<%=request.getContextPath()%>/userChangePassword">Change Password</a>
</div>
</br>
</body>
</html>