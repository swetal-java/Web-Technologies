<%@page import="dao.userdao"%>
<%@page import="model.usermodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRATION-PAGEs</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
<style>
body {
	padding: 2rem 0;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row mx-0 justify-content-center">
			<div class="col-md-7 col-lg-5 px-lg-2 col-xl-4 px-xl-0 px-xxl-3">
				<form class="w-100 rounded-1 p-4 border bg-white"
					action="usercontroller" method="post" id="reg">
					<h2 class="text-center">Edit Form</h2>
					<%
					int id = Integer.parseInt(request.getParameter("id"));
					usermodel um = userdao.getalldata(id);
					%>

					<input type="hidden" name="id" value="<%=um.getId()%>"> <label
						class="d-block mb-4"> <span class="form-label d-block">User
							Name</span> <input name="name" type="text" class="form-control"
						value="<%=um.getName()%>" required />
					</label> <label class="d-block mb-4"> <span
						class="form-label d-block">Email address</span> <input
						name="email" type="email" class="form-control"
						value="<%=um.getEmail()%>" required />
					</label> <label class="d-block mb-4"> <span
						class="form-label d-block">Contact Number </span> <input
						name="contact" type="contact" class="form-control"
						value="<%=um.getContact()%>" required />
					</label>

					<div class="mb-3">
						<input type="submit" name="action" value="update"
							class="btn btn-primary px-3 rounded-3" onclick="confirmInsert()">

					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>