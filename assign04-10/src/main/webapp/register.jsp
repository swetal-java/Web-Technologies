<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<form method="post" action="usercontoller">
		FirstName:<input type="text" name="fname"> <br> <br>
		LastName:<input type="text" name="lname"> <br> <br>
		Email:<input type="email" name="email"> <br> <br>
		Mobile:<input type="text" name="contact"> <br> <br>
		Gender :<input type="radio" name="gender" value="male"> <label
			for="male">Male</label><br> <input type="radio" name="gender"
			value="female"> <label for="css">Female</label><br> <br>
		Pasword:<input type="password" name="password"> <br> <br>
		<input type="submit" name="action" value="register">
	</form>
</body>
</html>