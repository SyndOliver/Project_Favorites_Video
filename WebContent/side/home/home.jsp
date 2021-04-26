<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<div class="row">
		<div class="col-lg-3">
			<h1 class="my-4">MINH_PHUC</h1>
			<div class="list-group">
				<a href="AboutUs" class="list-group-item">About Us</a> <a
					href="ContactUs" class="list-group-item">Contact US</a> <a
					href="favorite" class="list-group-item">Favorite</a>
			</div>

		</div>


		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="d-block img-fluid" src="img/vd3.png" alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid" src="img/vd4.jpg"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid" src="img/vd5.jpeg"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<div class="row">
				<div class="row p-3">
					<c:forEach var="item" items="${videos}">
						<div class="col-3 mt-2">
							<div class="card text-center">

								<div class="card-body">
									<a href="Detail?videoId=${item.videoId}"
										class="card-body-title"> <img
										src="${empty item.poster ? 'images/desktop.jpg': item.poster}"
										width="90%" alt="" class="img-fluid">

										<div class="text-center">
											<b>${item.title }</b>
										</div>
								</div>

								<div class="card-footer">

									<c:choose>
										<c:when test="${listF != null }">
											<c:set var="init" value="0" />
											<c:forEach items="${listF}" var="videoFavorite">
												<c:if test="${item.videoId == videoFavorite.videoId}">
													<c:set var="init" value="${init+1}" />
												</c:if>
											</c:forEach>
											<c:choose>
												<c:when test="${init == '1'}">
													<a href="Unlike?videoId=${item.videoId }"
														class="btn btn-success">UnLike</a>
													<a href="ShareVideo?videoId=${item.videoId }"
														class="btn btn-info">Share</a>
												</c:when>
												<c:otherwise>
													<a href="LikeVideo?videoId=${item.videoId }"
														class="btn btn-success">Like</a>
													<a href="ShareVideo?videoId=${item.videoId }"
														class="btn btn-info">Share</a>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<a href="LikeVideo?videoId=${item.videoId }"
												class="btn btn-success">Like</a>
											<a href="ShareVideo?videoId=${item.videoId }"
												class="btn btn-info">Share</a>
										</c:otherwise>
									</c:choose>

								</div>
							</div>
						</div>
					</c:forEach>
				</div>


			</div>
			<!-- /.row -->

		</div>


	</div>
</div>









<div class="col-12">
	<!--Đưa sản phẩm lên-->

	<!--Phân trang
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link" href="HomePage"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="HomePage">1</a></li>
					<li class="page-item"><a class="page-link" href="HomePage">2</a></li>
					<li class="page-item"><a class="page-link" href="HomePage"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>-->
	
</div>