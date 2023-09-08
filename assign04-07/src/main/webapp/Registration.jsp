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
								<div class="form-group">
									<label for="name">First Name</label> <input id="fname"
										type="text" class="form-control" name="fname" value="<%if(request.getAttribute("fname") != null){request.getParameter("fname");} %>" 
										>
									<div class="invalid-feedback">What's your name?</div>
								</div>

								<div class="form-group">
									<label for="name">Last Name</label> <input id="lname"
										type="text" class="form-control" name="lname" value="<%if(request.getAttribute("lanme") != null){request.getParameter("lname");} %>" 
										>
									<div class="invalid-feedback">What's your name?</div>
								</div>

								<div class="form-group">
									<label for="email">E-Mail Address</label> <input id="email"
										type="email" class="form-control" name="email" >
									<div class="invalid-feedback">Your email is invalid</div>
								</div>

								<div class="form-group">
									<label for="email">Mobile</label> <input id="email" type="text"
										class="form-control" name="contact" >
									<div class="invalid-feedback">Your email is invalid</div>
								</div>

								<div class="form-group">
									<label> Gender: </label> <br> <input type="radio"
										id="gender" name="gender" value="male" /> Male <br> <input
										type="radio" id="gender" name="gender" value="female" />
									Female <br />

								</div>

								<div class="form-group">
									<label for="password">Password</label> <input id="password"
										type="password" class="form-control" name="password"
										id="password"  data-eye>
									<div id="password-strength"></div>
									<div class="invalid-feedback">Password is required</div>
								</div>

								<div class="form-group"></div>

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block"
										style="margin: 12px;" name="action" value="register">Register</button>
								</div>
								<div class="mt-4 text-center">
									Already have an account? <a href="index.html">Login</a>
								</div>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>
	</section>

	<script type="text/javascript">
		const passwordInput = document.getElementById("password");
		const passwordStrengthIndicator = document
				.getElementById("password-strength");

		passwordInput.addEventListener('input', updatePasswordStrength);

		function updatePasswordStrength() {
			const password = passwordInput.value;
			const strength = calculatePasswordStrength(password);
			const strengthText = getStrengthText(strength);

			passwordStrengthIndicator.textContent = strengthText;
			passwordStrengthIndicator.style.color = getColorForStrength(strength);
		}

		function calculatePasswordStrength(password) {
			// Implement your password strength calculation logic here
			// This could involve checking for uppercase letters, lowercase letters,
			// numbers, special characters, and overall length.
			// Return a strength value (e.g., on a scale from 0 to 100).
			// You can customize this function according to your needs.
			// For this example, let's use a simple scale from 0 to 4.
			const lengthStrength = Math.min(password.length / 4, 1);
			const uppercaseStrength = /[A-Z]/.test(password) ? 1 : 0;
			const lowercaseStrength = /[a-z]/.test(password) ? 1 : 0;
			const digitStrength = /\d/.test(password) ? 1 : 0;
			const specialCharStrength = /[^A-Za-z0-9]/.test(password) ? 1 : 0;

			return (lengthStrength + uppercaseStrength + lowercaseStrength
					+ digitStrength + specialCharStrength) / 5 * 100;
		}

		function getStrengthText(strength) {
			if (strength >= 80) {
				return 'Strong';
			} else if (strength >= 60) {
				return 'Moderate';
			} else if (strength >= 30) {
				return 'Weak';
			} else {
				return 'Very Weak';
			}
		}

		function getColorForStrength(strength) {
			if (strength >= 80) {
				return 'green';
			} else if (strength >= 60) {
				return 'orange';
			} else if (strength >= 30) {
				return 'red';
			} else {
				return 'gray';
			}
		}

		
	</script>

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