<%@page import="java.lang.module.ResolutionException"%>
<%@page import="dao.userdao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int id = Integer.parseInt(request.getParameter("sid"));
userdao.deleteuser(id);
response.sendRedirect("HomePage.jsp");
%>
</body>
</html>