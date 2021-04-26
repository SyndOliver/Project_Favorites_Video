<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="col mt-4">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">Users Editting</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videolist-tab" data-toggle="tab" href="#videolist" role="tab"
			aria-controls="videolist" aria-selected="false">List Users</a></li>

	</ul>
	<!--Tab edit-->
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" >
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="username">Username</label> <input type="text"
										class="form-control" name="username" id="username" value="${user.username}"
										aria-describedby="usernamHid" placeholder="Username">
									<small id="usernamHid" class="form-text text-muted">Username
										is required</small>
								</div>
								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text"
										class="form-control" name="fullname" id="fullname" value="${user.fullname}"
										aria-describedby="fullnameHid" placeholder="Fullname">
									<small id="fullnameHid" class="form-text text-muted">Fullname
										is required</small>
								</div>
								<div class="form-check form-check-inline">
									<label> <input type="radio" class="form-check-intput"
										name="admin" id="status" value="true" ${user.admin?'checked':''}> Admin
									</label> 
									<label> 
									<input type="radio" class="form-check-intput"
											name="admin" id="status" value="false" ${!user.admin?'checked':''}>User
									</label>

								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="password">Passwrod</label> <input type="password"
										class="form-control" name="password" id="password" value="${user.password}"
										aria-describedby="passwordHid" placeholder="Password">
									<small id="passwordHid" class="form-text text-muted">Password
										is required</small>
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" name="email" id="email" value="${user.email}"
										aria-describedby="emailHid" placeholder="Email"> <small
										id="emailHid" class="form-text text-muted">Email is
										required</small>
								</div>
									
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button  class="btn btn-outline-primary" formaction="Admin/UserManagement/create">Create</button>
						<button class="btn btn-outline-warning" formaction="Admin/UserManagement/update">Update</button>
						<button  class="btn btn-outline-danger" formaction="Admin/UserManagement/delete" >Delete</button>
						<button  class="btn btn-outline-info" formaction="Admin/UserManagement/reset">Reset</button>
					</div>
				</div>
			</form>

		</div>
		<!--Tab list-->
		<div class="tab-pane fade" id="videolist" role="tabpanel"
			aria-labelledby="videolist-tab">
			<table class="table table-stripe">
				<tr>
					<td>Username</td>
					<td>Fullname</td>
					<td>Email</td>
					<td>Role</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
				<c:forEach items="${users}" var="item">
					<td>${item.username}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.admin? 'True':'False'}</</td>
					<td><a href="Admin/UserManagement/edit?username=${item.username}"><i class="fa fa-edit" aria-hidden="true"></i>
								Edit</a>
						 <a href="Admin/UserManagement/delete?username=${item.username}"><i class="fa fa-trash" aria-hidden="true"></i>
								Delete</a></td>
				</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</div>