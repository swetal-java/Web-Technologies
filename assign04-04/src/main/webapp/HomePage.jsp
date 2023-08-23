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
<% usermodel um = (usermodel)request.getAttribute("data"); %>
<p><%= um.getFname() %></p>
<p><%= um.getLname() %></p>
<p><%= um.getEmail() %></p>
<p><%= um.getContact() %></p>
<p><%= um.getGender() %></p>
</body>
</html>