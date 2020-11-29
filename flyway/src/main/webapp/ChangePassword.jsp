<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<div style="margin-top: 2%;">
		<h2 style="margin-left: 1%;">Change Password</h2>
		<form action="userChangePassword" method="Post">
			<div style="margin-top: 1%">
				<span style="margin-left: 5%;"> Please enter your old
					password: </span><span style="margin-left: 2%"><input type="text"
					name="oldPassword" placeholder="Enter your old password"></span>
			</div>
			<div style="margin-top: 1%">
				<span style="margin-left: 4%;"> Please enter your new
					password: </span><span style="margin-left: 2%"><input type="text"
					name="newPassword" placeholder="Enter your new password"></span>
			</div>
			<div style="margin-top: 1%">
				<span style="margin-left: 2%;">Please enter your new password
					again:</span><span style="margin-left: 2%"><input type="text"
					name="reNewPassword" placeholder="Enter your new password again"></span>
			</div>
			<div style="padding-top: 20px;margin-left: 15%;">
				<input type="submit" value="Submit">
			</div>
		</form>
		<div style="color: red;">${error}</div>
	</div>
</body>
</html>