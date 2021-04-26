<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">
<head>
<title>${page.title}</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/Assginment_v2/">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/css/detailcss.css">
<link rel="stylesheet" href="/css/aboutus.css">
<link rel="stylesheet" href="/css/contact.css">
<link rel="stylesheet" href="/css/cssLogin.css">
<link rel="stylesheet" href="css/login.css">
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shop-homepage.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/shop-homepage.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<main class="container">
		<header class="row pt-5 pb-2    ">
			
			<div class="col-3 text-center">
				<img src="images/logo.jpg" alt="" class="mr-4">
			</div>

		</header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container">
				<a class="navbar-brand" href="HomePage">MINHPHUC_PS13568</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarResponsive" aria-controls="navbarResponsive"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarResponsive">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item active"><a class="nav-link" href="HomePage">Home
								<span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="AboutUs">About
								Us</a></li>
						<li class="nav-item"><a class="nav-link" href="ContactUs">Contact
								Us</a></li>
						<li class="nav-item"><a class="nav-link" href="favorite">Favorite</a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fa fa-user" aria-hidden="true"></i> My Account
						</a>
							<div class="dropdown-menu" aria-labelledby="dropdownId">
								<c:if test="${!isLogin}">
									<a class="dropdown-item" href="Login"><i
										class="fa fa-sign-in" aria-hidden="true"></i> Login</a>
									<a class="dropdown-item" href="ForgotPassword"><i
										class="fa fa-question" aria-hidden="true"></i> Forgot Password</a>
									<a class="dropdown-item" href="Registration"><i
										class="fa fa-registered" aria-hidden="true"></i> Resgistration</a>
								</c:if>
								<c:if test="${isLogin}">
									<a class="dropdown-item" href="LogOff"><i
										class="fa fa-sign-out" aria-hidden="true"></i> Log Off</a>
									<a class="dropdown-item" href="ChangePassword"><i
										class="fa fa-pencil" aria-hidden="true"></i> Change Password</a>
									<a class="dropdown-item" href="EditProfile"><i
										class="fa fa-pencil-square-o" aria-hidden="true"></i> Edit
										Profile</a>
								</c:if>
							</div></li>
					</ul>
				</div>
			</div>
		</nav>
		<!--  <jsp:include page="/common/inform.jsp"></jsp:include>-->
		<section class="row">
			<jsp:include page="${page.contentUrl}" />

		</section>
		<footer class="row">
			<div class="col text-center  border-top">
				<strong>Fpt Poly &copy;2020.All rights reserved.</strong>

			</div>
		</footer>

	</main>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<c:if test="${not empty page.scriptUrl}">
		<!-- Sua day 1 xiu -->
		<jsp:include page="${page.scriptUrl}" />


	</c:if>
</body>
</html>