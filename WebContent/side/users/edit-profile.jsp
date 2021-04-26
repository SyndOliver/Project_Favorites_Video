<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="container">
	<form action="EditProfile" method="post">
		<div class="row">
			<div class="col-lg-10 col-xl-9 mx-auto">
				<div class="card card-signin flex-row my-5">
					<div class="card-img-left d-none d-md-flex">
						<!-- Background image for card set in CSS! -->
						
					</div>
					<div class="card-body">
						<h5 class="card-title text-center">Edit Profile</h5>
							<jsp:include page="/common/inform.jsp"></jsp:include>
							
						<form class="form-signin">
							<div class="col">
						<div class="form-group">
							<label for="username">Username</label> <input type="text"
								class="form-control" name="username" id="username" value="${user.username }"
								aria-describedby="usernamehid" placeholder="Username" > <small
								id="usernamehid" class="form-text text-muted">Username
								is required</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname" value="${user.fullname }"
								aria-describedby="fullnameHid" placeholder="Fullname" > <small
								id="fullnameHid" class="form-text text-muted">fullname
								is required</small>
						</div>
						
						<div class="form-group">
							<label for="email">Email address</label> <input type="text"
								class="form-control" name="email" id="email"  value="${user.email }"
								aria-describedby="eamilHid" placeholder="Email" > <small
								id="eamilHid" class="form-text text-muted">Email is
								required</small>
						</div><div class="form-group  ">
							<label for="password"></label> <input type="hidden"
								class="form-control" name="password" id="password" value="${user.password }"
								placeholder="Password">
						</div>
						
						
							<button class="btn btn-lg btn-primary btn-block text-uppercase"
								type="submit">Change</button>
						
						
					</div>


						</form>
					</div>
				</div>
			</div>
		</div>






	</form>
</div>