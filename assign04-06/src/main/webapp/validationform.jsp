<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
	<form method="post" name="regisform" action="validateserver">
		Fname:<input type="text" name="fname" required> <br> <br>
		Lname:<input type="text" name="lname" required> <br> <br>
		Email:<input type="email" name="email" required> <br> <br>
		Contact:<input type="text" name="contact" required> <br> <br>
		<br> <br> Pasword:<input type="password" name="password" required>
		<br> <br> <input type="submit" name="action"
			value="register">
	</form>
</body>
</html>