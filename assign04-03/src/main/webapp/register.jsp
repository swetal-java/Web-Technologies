<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="studcontroller">
		Fname:<input type="text" name="fname"> <br> <br>
		Lname:<input type="text" name="lname"> <br> <br>
		Email:<input type="email" name="email"> <br> <br>
		Contact:<input type="text" name="contact"> <br> <br>
		Gender:<input type="radio" name="gender" value="male">
		<lable for="male">Male</lable>
		<input type="radio" name="gender" value="female">
		<lable for="female">Female</lable>
		<br> <br> Pasword:<input type="password" name="password">
		<br> <br> <input type="submit" name="action"
			value="register">
	</form>
</body>
</html>