<%@page import="dao.userdao"%>
<%@page import="model.usermodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body.my-login-page {
	background-color: #f7f9fb;
	font-size: 14px;
}

.my-login-page .brand {
	width: 90px;
	height: 90px;
	overflow: hidden;
	border-radius: 50%;
	margin: 40px auto;
	box-shadow: 0 4px 8px rgba(0, 0, 0, .05);
	position: relative;
	z-index: 1;
}

.my-login-page .brand img {
	width: 100%;
}

.my-login-page .card-wrapper {
	width: 400px;
}

.my-login-page .card {
	border-color: transparent;
	box-shadow: 0 4px 8px rgba(0, 0, 0, .05);
}

.my-login-page .card.fat {
	padding: 10px;
}

.my-login-page .card .card-title {
	margin-bottom: 30px;
}

.my-login-page .form-control {
	border-width: 2.3px;
}

.my-login-page .form-group label {
	width: 100%;
}

.my-login-page .btn.btn-block {
	padding: 12px 10px;
}

.my-login-page .footer {
	margin: 40px 0;
	color: #888;
	text-align: center;
}

@media screen and (max-width: 425px) {
	.my-login-page .card-wrapper {
		width: 90%;
		margin: 0 auto;
	}
}

@media screen and (max-width: 320px) {
	.my-login-page .card.fat {
		padding: 0;
	}
	.my-login-page .card.fat .card-body {
		padding: 15px;
	}
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
<body class="my-login-page">
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="img/logo.jpg" alt="bootstrap 4 login page">
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">Register</h4>
							<form method="POST" class="my-login-validation"
								action="usercontroller" id="registrationForm">
								<%
								int cid = Integer.parseInt(request.getParameter("cid"));
								String gen = request.getParameter("gender");
								out.print(gen);
								usermodel um = userdao.getAllUserById(cid);
								
								%>
								<div class="form-group">
									<input type="hidden" value="<%= um.getId() %>" name="id"> <label
										for="name">First Name</label> <input id="fname" type="text"
										class="form-control" name="name"
										value="<%=um.getFname()%>">
									<div class="invalid-feedback">What's your name?</div>
								</div>

								<div class="form-group">
									<label for="name">Last Name</label> <input id="lname"
										type="text" class="form-control" name="name"
										value="<%=um.getLname()%>">
									<div class="invalid-feedback">What's your name?</div>
								</div>

								<div class="form-group">
									<label for="email">E-Mail Address</label> <input id="email"
										type="email" class="form-control" name="email"
										value="<%=um.getEmail()%>">
									<div class="invalid-feedback">Your email is invalid</div>
								</div>

								<div class="form-group">
									<label for="email">Mobile</label> <input id="email" type="text"
										class="form-control" name="contact"
										value="<%=um.getContact()%>">
									<div class="invalid-feedback">Your email is invalid</div>
								</div>

								<div class="form-group">
									<label> Gender: </label> <br> <input type="radio" name="gender" value="male" <%= (um.getGender().equals("male") ? "checked" : "") %>/> Male <br> 
									<input type="radio" name="gender" value="female" <%= (um.getGender().equals("female") ? "checked" : "") %> />
									Female <br />
								</div>



								<div class="form-group"></div>

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block"
										style="margin: 12px;" name="action" value="register">Register</button>
								</div>

							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>



	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="js/my-login.js"></script>
</body>
</html>