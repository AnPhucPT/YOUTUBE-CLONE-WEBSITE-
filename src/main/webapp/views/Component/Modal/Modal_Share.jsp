<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="shareModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="position-relative modal-content">
			<!-- Begin Loading -->
			<div style="z-index: 1000 !important;" id="loading"
				class="position-absolute top-0 end-0 rounded w-100 h-100 bg-black bg-opacity-75 d-flex justify-content-center align-items-center visually-hidden">
				<img style="width: 100px; height: 100px; object-fit: cover;"
					src="https://cdn.pixabay.com/animation/2022/10/11/03/16/03-16-39-160_512.gif"
					class="img-fluid w-10" alt="">
			</div>
			<!-- End Loading -->
			<form action="Share" method="post"
				class=" container bg-black col-12  px-5 pt-4 pb-3 border border-secondary rounded">
				<h4 class="text-center">SHARE THIS TO YOUR FRIEND</h4>
				<input type="text" name="ID" id="" value="${video.href}"
					class="form-control visually-hidden">
				<hr>
				<a href="#"
					class=" row me-1 shadow-sm rounded text-decoration-none text-dark mb-3 text-white text-opacity-75">
					<div class="col-3 col-lg-5 ps-">
						<img style="height: 90px; object-fit: cover;"
							src="https://img.youtube.com/vi/${video.href}/mqdefault.jpg"
							class="w-100 rounded" alt="">
					</div>
					<div class="col-9 col-lg-7  pe-0 ">
						<div
							style="display: -webkit-box !important; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden; font-size: 0.9rem;"
							class=" text-white">${video.title}</div>
						<div
							style="display: -webkit-box !important; -webkit-box-orient: vertical; -webkit-line-clamp: 1; overflow: hidden; font-size: 0.8rem;"
							class="mt-1">${video.description}</div>
					</div>
				</a>
				<hr>
				<div class="form-floating mb-4 ">
					<input required type="email" name="Email"
						class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
						id="Email" placeholder="Your friend Email"> <label class="h6"
						for="Email">Enter your friend email:</label>
				</div>
				<button id="submit-btn-email" type="submit"
					class="mb-4 btn w-100 btn-primary">Submit</button>
			</form>
		</div>
	</div>
</div>