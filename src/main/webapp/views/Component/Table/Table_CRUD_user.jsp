<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="col-8">
	<div style="background-color: rgba(225, 225, 225, 0.2);"
		class="container rounded shadow pt-2 p-4 mt-2 ">
		<div class="p-2 d-flex justify-content-center">
			<div class=" d-flex  my-2 rounded-4 overflow-hidden w-50">
				<input required type="text" name="UserName" id="UserName"
					class="form-control bg-black  shadow-none border-0 text-light rounded-0 ps-3"
					placeholder="Enter UserName" aria-describedby="helpId"> <a
					name="" id=""
					class="btn bg-primary bg-opacity-50  text-light px-3 rounded-0"
					href="#" role="button"><i class="bi-search"></i></a>
			</div>
		</div>

		<div class="table-responsive">
			<table class="table text-light">
				<thead>
					<tr>
						<th>Avatar</th>
						<th class="text-center">UserName</th>
						<th>Email</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${users}" var="user">
						<tr class="align-middle">
							<td class="col-1"><img
								style="height: 49px; object-fit: cover;" src="${user.avatar}"
								class="w-100 rounded-circle" alt=""></td>
							<td class="text-center">${user.userName}</td>
							<td>${user.email}</td>
							<td class="col text-center"><a name="" id=""
								class="text-primary" href="User?action=Edit&Email=${user.email}"
								role="button"><i class="h5 bi bi-pencil-square"></i></a> <a
								name="" id="" class="text-danger"
								href="User?action=Delete&Email=${user.email}" role="button"><i
									class="h5 bi bi-trash3"></i></a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>