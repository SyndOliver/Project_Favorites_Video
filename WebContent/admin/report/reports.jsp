<%@ page language="java" contentType="text/html; charset=Utf-8"
	pageEncoding="Utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">Favorties</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videolist-tab" data-toggle="tab" href="#videolist" role="tab"
			aria-controls="videolist" aria-selected="false">Favorties User</a></li>

		<li class="nav-item" role="presentation"><a class="nav-link"
			id="sharefriends-tab" data-toggle="tab" href="#sharefriends"
			role="tab" aria-controls="sharefriends" aria-selected="false">Share
				Friends</a></li>

	</ul>
	<!--Farvorites edit-->
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<table class="table table-border mt-3">
				<tr>
					<td>Video Title</td>
					<td>Favorites Count</td>
					<td>Lasted Day</td>
					<td>Oldest Day</td>
				</tr>	
				<c:forEach var="item" items ="${favlist}">
					<tr>
						<td>${item.videoTitle}</td>
						<td>${item.favoriteCount}</td>
						<td>${item.newesDate}</td>
						<td>${item.oldesDate}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		
		<!--Farvorites User-->
		<div class="tab-pane fade" id="videolist" role="tabpanel"
			aria-labelledby="videolist-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label>Video Title 
								<select name="videoUserId" id="videoUserId"
									class="form-control ml-3">
									<c:forEach var="item" items="${vidlist}">
										<option value="${item.videoId}"
										  ${item.videoId == videoUserId?'selected':''}>${item.title}</option>
									</c:forEach>
								</select></label>
								
								
								<button class="btn btn-info ml-2">Reports</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Username</td>
								<td>Fullname</td>
								<td>Email</td>
								<td>Favorite Date</td>
							</tr>
							<c:forEach var="item" items="${favuser}">
								<tr>
									<td>${item.username}</td>
									<td>${item.fullname}</td>
									<td>${item.email}</td>
									<td>${item.likeDate}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
		
		
		
		<!--Share Friends-->
		<div class="tab-pane fade" id="sharefriends" role="tabpanel"
			aria-labelledby="sharefriends-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
							
							<label>Video Title 
								<select name="videoShareId" id="videoShareId"
									class="form-control ml-3">
									<c:forEach var="item" items="${videoList}">
										<option value="${item.videoId}" ${item.videoId == videoShareId?'selected':''}>${item.title}</option>
									</c:forEach>
								</select></label>
								
								<button class="btn btn-info ml-2">Reports</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Sender Name</td>
								<td>Email Send</td>
								<td>Receiver Email</td>
								<td>Sent Date</td>
							</tr>
						<c:forEach var="item" items="${shareUser}">
								<tr>
									<td>${item.senderName}</td>
									<td>${item.senderEmail}</td>
									<td>${item.receiverEmail}</td>
									<td>${item.sentDate}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>

	</div>

</div>