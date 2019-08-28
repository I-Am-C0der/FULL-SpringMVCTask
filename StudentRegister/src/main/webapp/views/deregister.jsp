<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Corner</title>
</head>
<body>

	<br>
	<form align="right" action="/logout">
		<button type="submit">Logout</button>
	</form>
	<h2 align="center">Remove Student Details</h2>
	<br>
	<br>
	<form>
		<button type="submit" formaction="removeinfo">Back</button>
	</form>
	<br>

	<form action="deregister" method="post">

		<table border="1" align="center">
			<col width="130">
			<col width="130">
			<col width="130">
			<col width="130">
			<tr>
				<th>Choose</th>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>

			<c:forEach var="student" items="${student}">
				<tr>
					<td style="text-align: center">
					<input type="radio" name="remove" value="${student.getId()}" required /></td>
					<td style="text-align: center">${student.getId()}</td>
					<td style="text-align: center">${student.getName()}</td>
					<td style="text-align: center">${student.getAge()}</td>
				</tr>
				<br>

			</c:forEach>

		</table>
		<br>
		<div align="center"><button type="submit">Remove Details</button></div>

	</form>

</body>
</html>