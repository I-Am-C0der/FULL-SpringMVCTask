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
	<h1 align="center">Student Record</h1>
	<br>
	<br>
	<form method="get" action="/home">
		<button type="submit">Home</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="submit" formaction="/displayinfo">Back</button>
	</form>
	
		<table border="1" align="center">
			<col width="130">
			<col width="130">
			<col width="130">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
			</tr>

			<c:forEach var="student" items="${student}">
				<tr>
					<td style="text-align: center">${student.getId()}</td>
					<td style="text-align: center">${student.getName()}</td>
					<td style="text-align: center">${student.getAge()}</td>
				</tr>
				<br>

			</c:forEach>

		</table>

</body>
</html>