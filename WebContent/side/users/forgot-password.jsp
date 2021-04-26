<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<form action="ForgotPassword" method="post">
		<div class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div class="card card-signin flex-row my-5">
					<div class="card-img-left d-none d-md-flex">
						<!-- Background image for card set in CSS! -->
					</div>
					<div class="card-body">
					<jsp:include page="/common/inform.jsp"></jsp:include>
						<h5 class="card-title text-center">Forgot Password</h5>
						<form class="form-signin">
							<div class="form-label-group">
								<input type="text" name="username" id="inputUserame"
									class="form-control" placeholder="Username" required autofocus>
								<label for="inputUserame">Username</label>
							</div>

							<div class="form-label-group">
								<input type="email" name="email"  id="inputEmail"
									class="form-control" placeholder="Email address" required>
								<label for="inputEmail">Email address</label>
							</div>

							<hr>



							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Send</button>


						</form>
					</div>
				</div>
			</div>
		</div>



	</form>



</div>