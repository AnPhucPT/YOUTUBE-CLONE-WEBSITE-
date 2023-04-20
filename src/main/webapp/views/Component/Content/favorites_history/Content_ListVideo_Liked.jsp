<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-8">

	<c:forEach items="${videos}" var="video">
		<a href="Video?action=watch&ID=${video.href}"
			class=" row me-1 shadow-sm rounded text-decoration-none text-dark mb-3 text-white text-opacity-75">
			<div class="col-4 col-lg-4 ">
				<img style="height: 120px; object-fit: cover;"
					src="https://img.youtube.com/vi/${video.href}/mqdefault.jpg"
					class="w-100 rounded-4" alt="">
			</div>
			<div class="col-8 col-lg-8  ps-0 ">
				<div
					style="display: -webkit-box !important; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden;"
					class=" text-white">${video.title}</div>
				<div style="font-size: 0.8rem;" class="mt-1">
					Web Dev Simplified <i class="bi-check-circle-fill"></i>
				</div>
				<div class="d-flex ">
					<div style="font-size: 0.8rem;" class="">167K views</div>
					<div style="font-size: 0.8rem;" class=" mx-2">-</div>
					<div style="font-size: 0.8rem;" class="">1 hour ago</div>
				</div>
			</div>
		</a>
	</c:forEach>
	
</div>