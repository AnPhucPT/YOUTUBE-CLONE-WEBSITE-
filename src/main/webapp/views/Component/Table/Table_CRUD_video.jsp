<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="background-color: rgba(225, 225, 225, 0.2);"
	class="row rounded shadow p-3 py-4 mt-4">
	<div class="p-2  d-flex justify-content-center">
		<div class=" d-flex  my-2 rounded overflow-hidden w-50 border-info">
			<input type="text" name="UserName" id="UserName"
				class="form-control bg-black  shadow-none border-0 text-light rounded-0 ps-3"
				placeholder="Enter Title Video" aria-describedby="helpId"> <a
				name="" id=""
				class="btn btn-outline-info px-3 rounded-0 rounded-end"
				href="#" role="button"><i class="bi-search"></i></a>
		</div>
	</div>

	<div class="table-responsive">
		<table class="table text-light">
			<thead>
				<tr>
					<th>Thumbnail</th>
					<th>Href</th>
					<th>Video title</th>
					<th>Description</th>
					<th>View</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${videos}" var="video">
					<tr class="align-middle">
						<td class="col-2"><a
							href="Video?action=watch&ID=${video.href}"> <img
								style="height: 87px; object-fit: cover;"
								src="https://img.youtube.com/vi/${video.href}/mqdefault.jpg"
								class="w-100 rounded" alt="">
						</a></td>
						<td class="col"><a class="link-info" href="Video?action=watch&ID=${video.href}">${video.href}</a></td>
						<td class="col-3">${video.title}</td>
						<td class="col-6">${video.description != '' ? video.description : 'Chưa có mô tả'}</td>
						<td class="col text-center">${video.views}</td>
						<td class="col text-center"><a name="" id=""
							class="text-primary" href="Video?action=Edit&ID=${video.href}" role="button"><i
								class="h5 bi bi-pencil-square"></i></a> <a name="" id=""
							class="text-danger" href="Video?action=Delete&ID=${video.href}" role="button"><i
								class="h5 bi bi-trash3"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>