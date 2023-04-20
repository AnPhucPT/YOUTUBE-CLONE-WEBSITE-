<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<h5>Favorites Statistic:</h5>
<div style="background-color: rgba(225, 225, 225, 0.2);" d
	class="row rounded shadow p-3 pb-4 mt-3">
	
	<div class="table-responsive">
		<table class="table  text-light">
			<thead>
				<tr>
					<th scope="col">Thumnail</th>
					<th scope="col">Href</th>
					<th scope="col">Title</th>
					<th class="text-center col-2" scope="col">Total Like</th>
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
						<td><a class="text-info" href="Video?action=watch&ID=${video.href}">${video.href}</a></td>
						<td scope="row">${video.title}</td>
						<td class="text-center">${video.totalLike}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<div style="background-color: rgba(225, 225, 225, 0.2);"
	class="row rounded shadow p-3 pb-4 mt-3 mb-5">
	<h5>User Statistic:</h5>
	<%@ include file="/views/Component/DropDown/DropDown_inputSearch.jsp"%>

	<div class="table-responsive mt-3">
		<table class="table  text-light">
			<thead>
				<tr>
					<th scope="col">UserName</th>
					<th scope="col">Email</th>
				</tr>
			</thead>
			<tbody id="tbody_list_User">
				<tr class="align-middle">
					<td class="text-center" colspan="2">...</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>




