<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${not empty message }">
	<div class="row">
		<div class="col">
			<div class="alert alert-success">${message}</div>
		</div>
	</div>
</c:if>
<c:if test="${not empty erro }">
	<div class="row">
		<div class="col">
			<div class="alert alert-danger">${erro}</div>
		</div>
	</div>
</c:if>
