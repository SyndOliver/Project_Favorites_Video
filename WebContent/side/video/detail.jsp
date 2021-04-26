<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-7">
	<div class="card text-center mt-3">
		<div class="card-body">
			<div class="row">
				<img src="../Image/sp1.jpg" alt="" class="img-fluid">
			</div>
			<div class="row p-2">
				<b>Video Title</b>
			</div>
			<div class="row p-2">
				<b>Video Title</b>
			</div>
		</div>
		<div class="card-footer text-right">
			<a href="" class="btn btn-success">Like</a> <a href=""
				class="btn btn-info">Share</a>
		</div>
	</div>
	
		<div class="detail__history">
			<div class="detail__history-card">
				<div class="card__title">
					<p>Video Seen</p>
				</div>
				<c:if test="${cookie != null }">
					<div class="card__list">
						<div class="card__list-img">
							<img src="assets/img/${cookie.poster.value}" alt="">
						</div>
					</div>
				</c:if>
			</div>
		</div>
</div>


	
	
	
