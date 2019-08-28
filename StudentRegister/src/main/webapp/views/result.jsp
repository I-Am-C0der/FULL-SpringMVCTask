<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form align=right action=/logout>
		<button type=submit>Logout</button>
	</form>
	<br>
	<br>
	<form method=get action=/home>
		<button type=submit>Home</button>
	</form><br><br>
	${message}
</body>
</html>