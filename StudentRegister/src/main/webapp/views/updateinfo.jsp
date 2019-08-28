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
<br><form align="right" action="/logout"><button type="submit">Logout</button></form>
<h2 align="center">Update Student Details</h2>
	<br>
	<br>
<form><button type=submit formaction=/home>Back</button><br><br>
</form>
	<form action="modify" method="get" align="center">
		Name: <input type="text" name="name" ><br> <br> 
		<button type="submit">Get Details</button>
		
	</form>

</body>
</html>