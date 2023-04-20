<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-2 ">
	<!-- Hover added -->
	<div class="list-group ">
		<a href="index"
			class="btn-dark text-info rounded list-group-item list-group-item-action bg-transparent ${active == 'Home' ? 'chose' : ''} "><i
			class="me-3 ${active == 'Home' ? 'bi-house-fill' : 'bi-house'} bi-house-fill"></i>
			Home</a> <a href="#"
			class="btn-dark text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-person-video"></i> Shorts</a> <a href="#"
			class="btn text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-play-btn"></i> Subcriptions</a>
	</div>
	<hr class="my-2">
	<div class="list-group ">
		<a href="#"
			class="text-white rounded list-group-item list-group-item-action bg-transparent"><i
			class="me-3 bi-journal"></i> Library</a> 
	</div>
	<hr class="my-2">
	<div class="list-group ms-3">
		Sign in to like videos, comment, and subscribe. <a name="" id=""
			class="btn btn-outline-info rounded-5 w-75 mt-2" href="Login"
			role="button"><i class="bi-person-circle"></i> Sign in</a>
	</div>
	<hr class="my-2 mt-3">
	<div class="list-group ">
		<span class="ms-2"> Explore </span> <a href="#"
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