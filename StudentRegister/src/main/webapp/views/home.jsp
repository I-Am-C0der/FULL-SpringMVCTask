<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h1 align="center">Student Corner</h1>
	<br>

	<form align="center" action="/addinfo">
		<button type="submit">Add Student</button>
	</form>
	<br>

	<form align="center" action="/removeinfo">
		<button type="submit">Remove Student</button>
	</form>
	<br>

	<form align="center" action="/updateinfo">
		<button type="submit">Update Student</button>
	</form>
	<br>

	<form align="center" action="/displayinfo">
		<button type="submit">Display Details</button>
	</form>

</body>
</html>