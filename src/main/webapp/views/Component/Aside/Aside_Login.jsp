	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-2 ">
	<div class="list-group ">
		<a href="index"
			class="btn-dark rounded list-group-item list-group-item-action bg-transparent ${active == 'Home' ? 'chose text-info' : 'text-white'} "><i
			class="me-3 ${active == 'Home' ? 'bi-house-fill' : 'bi-house'} bi-house-fill"></i>
			Home</a>
	</div>
	<c:choose>
		<c:when test="${sessionScope.currentUser.getIsAdmin() == true}">
			<hr class="my-2">
			<div class="list-group ">
				<span class="mb-1"> User management </span> <a href="CRUD_user"
					class="${active == 'CRUD_user' ? 'chose text-info' : 'text-white'} rounded list-group-item list-group-item-action bg-transparent"><i
					class="me-3 bi-person-vcard"></i> Info User</a>
			</div>
		</c:when>
	</c:choose>
	<hr class="my-2">
	<div class="list-group ">
		<span class="mb-1"> Manipulation </span><a href="History"
			class="btn-dark  rounded list-group-item list-group-item-action bg-transparent ${active == 'Histories' ? 'chose text-info' : 'text-white'}"><i
			class="me-3 ${active == 'Histories' ? 'bi-stopwatch-fill' : 'bi-stopwatch'}"></i>
			History</a> <a href="Favorites"
			class=" rounded list-group-item list-group-item-action bg-transparent ${active == 'Favorites' ? 'chose text-info' : 'text-white'}"><i
			class="me-3  ${active == 'Favorites' ? 'bi-heart-fill' : 'bi-heart'}"></i>
			Liked Video</a> <!-- <a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-share"></i> Shared Video</a> --> <a href="Admin"
			class="rounded list-group-item list-group-item-action bg-transparent ${active == 'admin_favorites' ? 'chose text-info' : 'text-white'}"><i
			class="me-3  ${active == 'admin_favorites' ? 'bi-file-bar-graph-fill' : 'bi-file-bar-graph'}"></i> Statistical</a>
	</div>
	<hr class="my-2 mt-3">
	<div class="list-group ">
		<span class=""> Explore </span> <a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-fire"></i> Trending</a> <a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-music-note-beamed"></i> Music</a> <a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-controller"></i> Gaming</a> <a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-journal-arrow-up"></i> New</a> <a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-rocket-takeoff"></i> Sport</a>
	</div>
	<hr class="my-2 mt-3">
	<div class="list-group">
		<a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-gear"></i> Settings</a>
	</div>
</div>