<%@page import="org.hibernate.mapping.Value"%>
<%@page import="dao.userdao"%>
<%@page import="model.usermodel"%>
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
<% int id = Integer.parseInt(request.getParameter("id"));
usermodel um = userdao.getdatabyid(id); %>
		<input type="hidden" name="id" value="<%= um.getId()%>">
		Fname:<input type="text" name="fname" value="<%= um.getFname()%>"> <br> <br>
		Lname:<input type="text" name="lname" value="<%= um.getLname()%>"> <br> <br>
		Email:<input type="email" name="email" value="<%= um.getEmail()%>"> <br> <br>
		Contact:<input type="text" name="contact" value="<%=um.getContact()%>"> <br> <br>
		Gender:<input type="radio" name="gender" value="male" <%= (um.getGender().equals("male") ? "checked" : "") %>/>
		<lable for="male">Male</lable>
		<input type="radio" name="gender" value="female" <%= (um.getGender().equals("female") ? "checked" : "") %> />
		<label for="female">Female</label>
		
		<br> <br> <input type="submit" name="action"
			value="edit">
	</form>
</body>
</html>