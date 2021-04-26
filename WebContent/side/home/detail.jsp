<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container-fluid mt-5">
	<div class="row">
		<c:forEach var="item" items="listvideo">
			<div class="col-md-5">
				<div class="carousel slide" data-ride="carousel" id="carousel-1">
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="img-thumbnail w-100 d-block"
								src="${videodetail.poster}" alt="Slide Image" loading="lazy">
						</div>

					</div>

				</div>
			</div>
			<div class="col-md-5">
				<h4>${videodetail.title}</h4>
				<h6>${videodetail.description}</h6>

				<div class="card-footer">
					<c:choose>
						<c:when test="${favorite!=null}">
							<a href="Unlike?videoId=${videodetail.videoId}"
								class="btn btn-success">Unlike</a>
						</c:when>

						<c:otherwise>
							<a href="LikeVideo?videoId=${videodetail.videoId}"
								class="btn btn-success">Like</a>
						</c:otherwise>

					</c:choose>

					<a href="ShareVideo?videoId=${videodetail.videoId}"
						class="btn btn-info">Share</a>
				</div>
			</div>
			<div class="col-md-2">
				<div class="detail__history-card">
					<div class="card__title">
						<p>Video seen</p>
					</div>
					<c:if test="${cookie != null }">
						<div class="card__list">
							<div class="card__list-img">
								<img src="${videodetail.poster}" width="50%" alt="">
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</c:forEach>



	</div>
</div>