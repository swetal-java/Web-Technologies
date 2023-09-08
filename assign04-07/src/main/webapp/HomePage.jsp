<%@page import="model.usermodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<%
	usermodel m = (usermodel)request.getAttribute("data");
    int id = m.getId();
    
	%>



	<div class="text-center">
		<h1>Welcome to Home Page</h1>
	</div>

	<div class="container">
		<table class="table table-dark">
			<thead>
				<tr>
					<th scope="col">FNAME</th>
					<th scope="col">LNAME</th>
					<th scope="col">EMAIL</th>
					<th scope="col">CONTACTNO</th>
					<th scope="col">GENDER</th>

					<th scope="col">EDIT</th>
					<th scope="col">DELETE</th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<th scope="row"><%=m.getFname() %></th>
					<td><%= m.getLname() %></td>
					<td><%= m.getEmail() %></td>
					<td><%= m.getContact() %></td>
					<td><%= m.getGender() %></td>
					<td><a href="regis-user-edit.jsp?cid=<%= m.getId()%>&gender=<%= m.getGender()%>">EDIT</a></td>

					<td><a href="regis-user-delete.jsp?sid=<%= m.getId()%>">Delete</a></td>
				</tr>

			</tbody>
		</table>
	</div>

	<h1 class="text-center">
		<a href="">LOGOUT</a>
	</h1>
</body>
</html>