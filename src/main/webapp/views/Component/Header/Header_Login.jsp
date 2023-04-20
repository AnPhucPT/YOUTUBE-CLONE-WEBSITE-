<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="">
	<div style="height: 56px;"
		class="container d-flex justify-content-between align-items-center ">
		<div class="">
			<a href="index"> <img style="height: 20px;"
				src="https://www.edigitalagency.com.au/wp-content/uploads/Youtube-logo-white-only-png.png"
				class="img-fluid rounded-top" alt="">
			</a>
		</div>
		<div class="">
			<form style="border: 1px solid rgba(255, 255, 255, 0.2);"
				class="d-flex rounded-5 overflow-hidden">
				<input style="outline: none; width: 500px;" type="text" name=""
					id=""
					class=" rounded-start p-2 ps-4 bg-transparent border-0 text-white rounded"
					placeholder="Search" aria-describedby="helpId"> <a name=""
					id="" class="btn btn-dark text-light px-4 rounded-0" href="#"
					role="button"><i class="bi-search"></i></a>
			</form>
		</div>
		<div class="">
			<div class="d-flex align-items-center">
				<span class="me-2">${sessionScope.currentUser.userName}</span>
				<div class="dropdown open">
					<a
						class="btn btn-outline-light rounded-4 py-2 dropdown-toggle me-3"
						type="button" id="triggerId" data-bs-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> <i
						class="bi bi-person-circle"></i> 
						<%-- <img style="width: 30px; height: 30px;"
                                src="files/${sessionScope.currentUser.getAvatar()}"
                                class="img-fluid rounded-circle" alt=""> --%>
					</a>
					<div class="dropdown-menu dropdown-menu-end shadow"
						style="right: 0 !important; left: unset;"
						aria-labelledby="triggerId">
						<a data-bs-toggle="modal" data-bs-target="#exampleModal"
							class="dropdown-item d-flex pe-4" href="Register"> <i
							style="width: 20px;" class="d-block me-2 bi-key"></i> Change
							Password
						</a> <a class="dropdown-item d-flex pe-4" href="#"> <i
							style="width: 20px;" class="d-block me-2 bi-pencil-square"></i>Edit
							Profile
						</a>
						<hr class="my-1">
						<a class="dropdown-item d-flex pe-4" href="Logout"> <i
							style="width: 20px;" class="d-block me-2 bi-box-arrow-right"></i>Logout
						</a>
					</div>
				</div>

				<a id="CRUD-video" href="CRUD_video" class="btn ${active == 'CRUD_video' ? 'btn-info' : 'btn-outline-light'} rounded-4 p-2 py-1 "><i
					class="h3 mb-0 bi-cloud-plus"></i></a>
			</div>
		</div>
	</div>
</header>