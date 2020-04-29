<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Thank you your details are saved</p>

	<table>
		<tr>
			<td>Name</td>
			<td>${ user.name}</td>
		</tr>

		<tr>
			<td>Location</td>
			<td>${ user.location}</td>
		</tr>
		<tr>
			<td><a href="/users-PRG/registration">Home page</a></td>
		</tr>

	</table>
</body>
</html>