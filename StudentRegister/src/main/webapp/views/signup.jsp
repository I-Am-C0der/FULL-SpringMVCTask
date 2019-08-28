<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.alert {
	padding: 20px;
	background-color: #f44336;
	color: white;
}

.closebtn {
	margin-left: 15px;
	color: white;
	font-weight: bold;
	float: right;
	font-size: 22px;
	line-height: 20px;
	cursor: pointer;
	transition: 0.3s;
}

.closebtn:hover {
	color: black;
}
</style>
<title>Student Corner</title>
</head>
<body>
	<c:if test="${not empty message}">
		<div class="alert">
			<span class="closebtn"
				onclick="this.parentElement.style.display='none';">&times;</span> <strong>${message}</strong>
		</div>
	</c:if>
	<br>
	<h1 align="center">Student Corner</h1>
	<br>
	<h2 align="center">Sign Up</h2>
	<br>
	<br>
	<form align="center" action="signuppage" method="post">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Name: <input type="text"
			name="name" required /><br /> <br /> Username: <input type="text"
			name="username" required /><br /> <br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Email: <input type="email" name="email" required /><br /> <br />&nbsp;
		Password: <input type="password" name="password" required /><br /> <br />
		<input type="submit" value="Sign Up" /> <br> <br> Already
		have a Account? <a href="/login">Log In </a>
	</form>

</body>
</html>