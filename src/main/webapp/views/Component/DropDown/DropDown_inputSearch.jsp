<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="dropdown">
	<input type="text"
		class="w-100 form-control input-title dropdown-toggle shadow-none bg-black text-light"
		id="triggerId" data-bs-toggle="dropdown" aria-haspopup="true"
		aria-expanded="false" placeholder="Search title video here"> </input>

	<div id="selectVideo" class="dropdown-menu" aria-labelledby="triggerId">
		<a class="dropdown-item disabled" href="#">Select one:</a>
		<c:forEach items="${videos}" var="item">
			<div class="">
				<div class="dropdown-divider"></div>
				<a
					style="display: -webkit-box !important; -webkit-box-orient: vertical; -webkit-line-clamp: 1; overflow: hidden;"
					class="dropdown-item dropdown-title "
					href="Admin/Favorites?Href=${item.href}">${item.title}</a>
			</div>
		</c:forEach>
		<!-- 
		<a class="dropdown-item" href="#">Example video's title which one
			is kinda long title</a>

		<div class="dropdown-divider"></div>
		<a class="dropdown-item" href="#">Lorem ipsum dolor sit amet
			consectetur adipisicing elit. Mollitia, labore?</a> -->
	</div>
</div>