<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="users">

		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>

			<tr>
				<td>Location</td>
				<td><form:input path="location" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register">
				</td>
			</tr>
		</table>

	</form:form>


</body>
</html>