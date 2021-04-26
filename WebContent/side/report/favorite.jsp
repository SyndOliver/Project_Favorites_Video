<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-12">
	<!--Đưa sản phẩm lên-->
	<div class="row p-3">
		<c:forEach var="item" items="${items}">
			<div class="col-3 mt-2">
				<div class="card text-center">
					<div class="card-body">
						<a href="Detail?videoId=${item.videoId}" class="card-body-title">
							<img
							src="${empty item.poster ? 'images/desktop.jpg': item.poster}"
							width="90%" alt="" class="img-fluid">

							<div class="text-center">
								<b>${item.title }</b>
							</div>
					</div>
					<div class="card-footer">


						<a href="Unlike?videoId=${item.videoId }" class="btn btn-success">UnLike</a>
						<a href="ShareVideo?videoId=${item.videoId }" class="btn btn-info">Share</a>



					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<!--Phân trang
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link" href="HomePape"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="HomePape">1</a></li>
					<li class="page-item"><a class="page-link" href="HomePape">2</a></li>
					<li class="page-item"><a class="page-link" href="HomePape"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>-->
</div>