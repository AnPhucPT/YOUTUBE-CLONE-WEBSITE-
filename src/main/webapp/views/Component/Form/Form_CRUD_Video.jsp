<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="form-video" action="Video" method="post"
	style="background-color: rgba(225, 225, 225, 0.2);"
	class="row rounded shadow p-3 py-4 mt-2">
	<div class="col-4">
		<img id="poster" style="width: 100%;" class=" rounded me-3"
			src="https://innovating.capital/wp-content/uploads/2021/05/placeholder-image-dark.jpg"
			alt="">
	</div>
	<div class="col-8">
		<div class="row">
			<div class="col-3">
				<div class="mb-3">
					<label for="Href" class="form-label">Video Href:</label> <input required
						type="text" name="Href" id="Href" value="${form.href}"
						class="form-control bg-black border-secondary shadow-none text-light "
						placeholder="" aria-describedby="helpId">
				</div>
			</div>
			<div class="col-9">
				<div class="mb-3">
					<label for="Title" class="form-label">Title Video:</label> <input required
						type="text" name="Title" id="Title" value="${form.title}"
						class="form-control bg-black border-secondary shadow-none text-light "
						placeholder="" aria-describedby="helpId">
				</div>
			</div>
		</div>
		<div class="mb-3">
			<label for="description" class="form-label">Video
				description:</label>
			<textarea 
				class="form-control bg-black border-secondary shadow-none text-light "
				name="description" id="description" rows="2">${form.description}</textarea>
		</div>
		<!-- <div class="mb-3 d-flex gap-3">
			<div class="form-check">
				<input class="form-check-input" type="radio" name="status"
					value="Active" id="Active" checked> <label
					class="form-check-label" for="Active"> Active </label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="status"
					value="Inactive" id="Inactive"> <label
					class="form-check-label" for="Inactive"> Inactive </label>
			</div>
		</div> -->
		<hr>

		<div class="d-flex gap-2">
			<c:choose>
				<c:when test="${status == 'Create'}">
					<button id="	" name="submitButton" value="Create" type="submit"
						class="flex-grow-1  btn btn-info">Create</button>
				</c:when>
				<c:when test="${status == 'Update'}">
					<button name="submitButton" value="Update" type="submit"
						class="flex-grow-1  btn btn-info">Update</button>
				</c:when>
			</c:choose>
			<a name=""
			id="reset_form_video" class="btn btn-outline-secondary" href="CRUD_video" role="button"><i
			class="bi-arrow-counterclockwise"></i></a> 
		</div>
		<!-- <a name="" id="" class="btn btn-primary px-3 me-2" href="Video?action=Edit"
			role="button"><i class="bi-plus-circle"></i> Create</a> -->
			

	</div>
</form>