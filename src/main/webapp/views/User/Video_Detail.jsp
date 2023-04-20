<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<!-- Begin <head> -->
<%@ include file="/views/Component/Tag/Tag__Head.jsp"%>
<!-- End </head> -->

<body class="bg-black text-white rounded">

	<!-- Begin <Header> -->
	<%@ include file="/views/Component/Header/Header_index.jsp"%>
	<!-- End </Header> -->

	<main>
		<!-- Begin Container -->
		<div class="container p-3 text-white text-opacity-75">
			<div class="row">

				<!-- Begin col-lg-8 -->
				<div class="col-12 col-lg-8">

					<!-- Begin Video Watching -->
					<iframe
						style="box-shadow: rgb(255 255 255/ 50%) 0px 0px 150px 0px;"
						width="100%" height="485px"
						class="rounded-4"
						src="https://www.youtube.com/embed/${video.href}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
					<!-- End Video Watching -->

					<!-- Begin Video Content -->
					<div class="ps-0">

						<!-- Begin Video title -->
						<div class="row">
							<div class="col">
								<h5 class="title-Video m-0">${video.title}</h5>
							</div>
						</div>
						<!-- End Video title -->

						<!-- Begin info -->
						<div
							class="d-flex align-items-center justify-content-between mt-3">

							<!-- Begin User Avatar - User Name -->
							<div class="d-flex align-items-center">
								<img style="width: 36px;" class=" rounded-circle me-2"
									src="https://yt3.ggpht.com/yti/AHXOFjXxJbRXly3rZLGrTLEzJt4-w0A3utpTrH2O-w=s88-c-k-c0x00ffffff-no-rj-mo"
									alt="">
								<div class="text-secondary">
									Ân Phúc<i class="bi-check-circle-fill ms-1"></i>
								</div>
							</div>
							<!-- Begin User Avatar - User Name -->

							<!-- Begin show Button Action if had Login -->
							<c:if test="${not empty sessionScope.currentUser}">
								<div class="h5 mb-0 d-flex gap-2  align-items-center">

									<!-- Begin Button Share -->
									${video.shares}<a data-bs-target="#shareModal"
										data-bs-toggle="modal"
										class="text-decoration-none btn btn-outline-primary rounded-4 pb-2 me-2">
										<i class="bi-box-arrow-up-right"></i>
									</a>
									<!-- End Button Share -->

									<!-- Begin modal Share -->
									<%@ include file="/views/Component/Modal/Modal_Share.jsp"%>
									<!-- End modal Share -->


									<!-- Begin Button Like -->
									<c:choose>
										<c:when test="${flagLikeBtn == true }">
										${video.likes}<a id="LikeOrUnlike"
												href="Video?action=like&ID=${video.href}"
												class="btn btn-danger rounded-4 text-decoration-none"><i
												class="bi-heart"></i> </a>
										</c:when>
										<c:otherwise>
											 ${video.likes}<a id="LikeOrUnlike"
												href="Video?action=like&ID=${video.href}"
												class="btn btn-outline-danger rounded-4 text-decoration-none ">
												<i class="bi-heart"></i>
											</a>
										</c:otherwise>
									</c:choose>
									<!-- End Button Like -->

								</div>
							</c:if>
							<!-- End show Button Action if had Login -->

						</div>
						<!-- End info -->

						<!-- Begin Video Description -->
						<c:choose>
							<c:when test="${video.description != null}">
								<span style="background-color: rgba(225, 225, 225, 0.2);"
									class="d-block mt-3 p-2 rounded">${video.description} </span>
							</c:when>
						</c:choose>
						<!-- End Video Description -->

					</div>
					<!-- End Video Content -->

				</div>
				<!-- End col-lg-8 -->

				<!-- Begin col-lg-4 -->
				<div class="col-12 ps-4 pt-1 col-lg-4">
					<c:forEach items="${videos}" var="video">
						<a href="Video?action=watch&ID=${video.href}"
							class="video row me-1 shadow-sm rounded text-decoration-none text-dark mb-3 text-white text-opacity-75">
							<div class="col-3 col-lg-5 ps-0">
								<img style="height: 90px; object-fit: cover;"
									src="https://img.youtube.com/vi/${video.href}/mqdefault.jpg"
									class="w-100 rounded" alt="">
							</div>
							<div class="col-9 col-lg-7  ps-0 ">
								<div
									style="display: -webkit-box !important; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden;"
									class=" text-white">${video.title}</div>
								<div
									style="display: -webkit-box !important; -webkit-box-orient: vertical; -webkit-line-clamp: 1; overflow: hidden; font-size: 0.8rem;"
									class="mt-1">${video.description}</div>
							</div>
						</a>
					</c:forEach>


				</div>
				<!-- End col-lg-4 -->

			</div>
		</div>
		<!-- End Container -->
	</main>
	<footer> </footer>

	<!-- Begin JQuery for Like or Unlike -->
	<script src="js/JQuery_Like_or_Unlike.js"></script>
	<!-- End JQuery for Like or Unlike -->

	<!-- Begin JQeury for loading share -->
	<script src="js/JQuery_share.js"></script>
	<!-- End JQeury for loading share -->

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
		integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
		crossorigin="anonymous"></script>
</body>

</html>