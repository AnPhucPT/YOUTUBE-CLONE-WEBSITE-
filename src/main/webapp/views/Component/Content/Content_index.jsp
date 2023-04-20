<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>

	<c:when test="${active == 'Home'}">
		<!-- Begin List Video -->
		<%@ include file="/views/Component/Content/home/Main__ListVideos.jsp"%>
		<!-- End List Video -->

		<!-- Begin Pagination -->
		<%@ include file="/views/Component/Pagination/Pagination_index.jsp"%>
		<!-- End Pagination -->
	</c:when>

	<c:when test="${active == 'Favorites' || active == 'Histories'}">
		<h5>List Video:</h5>

		<div class="row">

			<!-- Begin List Video -->
			<%@ include
				file="/views/Component/Content/favorites_history/Content_ListVideo_Liked.jsp"%>
			<!-- End Pagination -->

			<!-- Begin Search Video titele -->
			<%@ include
				file="/views/Component/Search/favorites_history/Search_title.jsp"%>
			<!-- End Search Video titele -->

		</div>
	</c:when>

	<c:when test="${active == 'admin_favorites'}">
		
		<!-- Begin List Video statistical -->
		<%@ include
			file="/views/Component/Content/admin_favorites/Content_Video_statistic.jsp"%>
		<!-- End Pagination statistical -->
	</c:when>
	
	<c:when test="${active == 'CRUD_video'}">
		
		<!-- Begin List Video statistical -->
		<%@ include
			file="/views/Component/Content/CRUD_video/Content_CRUD_Video.jsp"%>
		<!-- End Pagination statistical -->
	</c:when>
	
	<c:when test="${active == 'CRUD_user'}">
		
		<!-- Begin List Video statistical -->
		<%@ include
			file="/views/Component/Content/CRUD_user/Content_CRUD_user.jsp"%>
		<!-- End Pagination statistical -->
	</c:when>

</c:choose>