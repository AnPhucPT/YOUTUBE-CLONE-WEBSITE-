<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-4">
	<form style="background-color: rgba(255, 255, 255, 0.2);"
		class="p-4  rounded shadow container col-6 col-lg-12  mt-2" action="User"
		method="post">
		<div class="mb-3">
			<label for="UserName" class="form-label">UserName:</label> <input
				type="text" name="UserName" id="UserName" value="${form.userName}"
				class="form-control bg-black  shadow-none border-secondary text-light"
				placeholder="Enter your UserName" aria-describedby="helpId">
		</div>
		<div class="mb-3">
			<label for="Email" class="form-label">Email:</label> <input
				type="email" value="${form.email}"
				class="form-control bg-black shadow-none border-secondary text-light"
				name="Email" id="Email" aria-describedby="emailHelpId"
				placeholder="abc@mail.com">
		</div>

		<div class="mb-3">
			<label for="Avatar" class="form-label">Avatar:</label>
			<div class="d-flex gap-2 align-items-center">
				<input required type="text" value="${form.avatar}"
					class="form-control bg-black shadow-none border-secondary text-light "
					name="Avatar" id="Avatar" aria-describedby="HelpId"
					placeholder="your link image"> <img id="img_user"
					style="width: 50px; height: 50px; object-fit: cover;" src=""
					class="img-fluid rounded-circle visually-hidden" alt="">
			</div>
		</div>
		<hr>
		<div class="d-flex gap-2">
			<c:choose>
				<c:when test="${status == 'Create'}">
					<button id="submitButton" name="submitButton" value="Create"
						type="" class="flex-grow-1 btn btn-info disabled">Only Update</button>
				</c:when>
				<c:when test="${status == 'Update'}">
					<button name="submitButton" value="Update" type="submit"
						class="flex-grow-1  btn btn-info">Update</button>
				</c:when>
			</c:choose>
			<a name="" id="reset_form_video" class="btn btn-outline-secondary"
				href="CRUD_user" role="button"><i class="bi-arrow-counterclockwise"></i></a>
		</div>
	</form>
</div>