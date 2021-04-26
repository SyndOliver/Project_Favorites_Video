<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">Video Editting</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videolist-tab" data-toggle="tab" href="#videolist" role="tab"
			aria-controls="videolist" aria-selected="false">List Video</a></li>

	</ul>
	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype='multipart/form-data'>
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img src="${video.poster !=null?video.poster: 'images/sp2.jsp'}" alt="" class="img-fluid">
									<div class="input-group mb-3 mt-3">
										<div class="input-group-prepend">
											<span class="input-group-text">Upload</span>
										</div>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="cover" name="cover">
											<label for="cover">Choose File</label>
										</div>
									</div>
								</div>
							</div>

							<div class="col-9">
								<div class="form-group">
									<label for="youtubeId">Youtube ID</label> <input type="text"
										class="form-control" name="videoId" id="youtubeId"  value="${video.videoId}"
										aria-describedby="youtubeIdHid" placeholder="Youtube ID">
									<small id="youtubeIdHid" class="form-text text-muted">Youtube
										ID is required</small>
								</div>

								<div class="form-group">
									<label for="videotitle">Video Title</label> <input type="text"
										class="form-control" name="title" id="videotitle" value="${video.title}"
										aria-describedby="videotitleHid" placeholder="Video Title">
									<small id="videotitleHid" class="form-text text-muted">Video
										Title is required</small>
								</div>

								<div class="form-group">
									<label for="viewcount">View Count</label> <input type="text"
										class="form-control" name="views" id="viewcount" value="${video.views}"
										aria-describedby="viewcountHid" placeholder="View Count">
									<small id="viewcountHid" class="form-text text-muted">View
										Count is reqiured</small>
								</div>

								<div class="form-check form-check-inline">
									<label> <input type="radio" class="form-check-intput"
										name="active" id="status" value="true" ${video.active?'checked':''}> Active
									</label> 
									<label> 
									<input type="radio" class="form-check-intput"
											name="active" id="status" value="false" ${!video.active?'checked':''}>Inactive
									</label>

								</div>
								
							</div>
						</div>

						<div class="row">
							<div class="col">
								<label for="decription">Decription</label>
								<textarea name="description" id="decription" cols="30" rows="10"
									class="form-control"  >${video.description}</textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-outline-primary" formaction="Admin/VideoManagement/create">Create</button>
						<button class="btn btn-outline-warning" formaction="Admin/VideoManagement/update">Update</button>
						<button  class="btn btn-outline-danger" formaction="Admin/VideoManagement/delete">Delete</button>
						<button  class="btn btn-outline-info" formaction="Admin/VideoManagement/reset">Reset</button>
					</div>
				</div>
			</form>

		</div>
		<div class="tab-pane fade" id="videolist" role="tabpanel"
			aria-labelledby="videolist-tab">
			<table class="table table-stripe">
				<tr>
					<td>Youtube ID</td>
					<td>Video Title</td>
					<td>View Count</td>
					<td>Status</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var = "item" items = "${videos}">
					<tr>
						<td>${item.videoId}</td>
						<td>${item.title}</td>
						<td>${item.views}</td>
						<td>${item.active? 'Active':'Deactive'}</td>
						
						<td><a href="Admin/VideoManagement/edit?videoId=${item.videoId}"><i class="fa fa-edit" aria-hidden="true"></i>
								Edit</a>
						 <a href="Admin/VideoManagement/delete?videoId=${item.videoId}"><i class="fa fa-trash" aria-hidden="true"></i>
								Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>

</div>
