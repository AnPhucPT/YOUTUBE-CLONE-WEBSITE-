<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="min-height: 576px" class="row">
	<c:forEach items="${videos}" var="video">
		<div class="col-6 col-xl-4 ">
			<div class="card border-0 shadow bg-transparent mt-3">
				<div class="card-body p-0">

					<a href="Video?action=watch&ID=${video.href}"
						class="text-decoration-none text-reset"> <img
						style="height: 200px; object-fit: cover;"
						src="https://img.youtube.com/vi/${video.getHref()}/sddefault.jpg"
						class="w-100 rounded-4" alt="">

						<div class="d-flex mt-2 ">
							<img style="width: 40px; height: 40px; object-fit: cover;"
								class="rounded-circle me-3"
								src="https://yt3.ggpht.com/yti/AHXOFjXxJbRXly3rZLGrTLEzJt4-w0A3utpTrH2O-w=s88-c-k-c0x00ffffff-no-rj-mo"
								alt="">
							<div class="">
								<p
									style="display: -webkit-box !important; -webkit-box-orient: vertical; -webkit-line-clamp: 2; overflow: hidden;"
									class="h6 card-title d-flex align-items-center p-0 m-0">
									${video.getTitle()}</p>
								<div class="mt-1">
									<div style="font-size: 0.9rem;" class="text-secondary d-flex ">
										<div>
											Ân Phúc <i class="bi-check-circle-fill ms-1"></i>
										</div>
										<div style="font-size: 0.9rem;" class="ms-3 text-secondary">${video.views}
											${video.views > 1 ?"views" : "view" }</div>
										<div style="font-size: 0.9rem;" class="ms-3 text-secondary">${video.shares}
											${video.shares > 1 ?"shares" : "share" }</div>
										<div style="font-size: 0.9rem;" class="ms-3 text-secondary">${video.likes}
											${video.likes > 1 ?"likes" : "like" }</div>
									</div>
									<div class="d-flex"></div>
								</div>
							</div>

						</div>

					</a>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
