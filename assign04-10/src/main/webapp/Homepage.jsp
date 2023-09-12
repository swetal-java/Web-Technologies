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
	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	usermodel um = null;
	if (session.getAttribute("data") != null) {
		um = (usermodel) session.getAttribute("data");
	}
	%>
	<h1>Welcome to homePage</h1>
	<h3><%=um.getFname()%></h3>
	<h3><%=um.getLname()%></h3>
	<h3><%=um.getEmail()%></h3>
	<h3><%=um.getGender()%></h3>
	<h3><%=um.getContact()%></h3>
	<h3><img src="images/<%= um.getImage()%>"></h3>
	<a href="editprofile.jsp?id=<%=um.getId()%>">Edit</a>
	<a href="logout.jsp">Log-out</a>
</body>
</html>