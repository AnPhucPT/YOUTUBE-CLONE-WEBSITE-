<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row mt-5  ">
	<nav class="d-flex justify-content-center" aria-label="Page navigation">
		<ul class="pagination bg-black ">
			<li
				class="page-item rounded-start ${currentPage == 1 ? 'disabled bg-dark' : ''}  ">
				<a class="page-link bg-transparent text-light text-opacity-50"
				href="index?page=1" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a>
			</li>
			<c:forEach varStatus="i" begin="1" end="${maxPage}">
				<li class="page-item"><a
					class="page-link text-light ${currentPage == i.index ? 'bg-info text-opacity-100' : 'bg-transparent text-opacity-50' }"
					href="index?page=${i.index}">${i.index }</a></li>
			</c:forEach>
			<li
				class="page-item rounded-end ${currentPage == maxPage ? 'disabled bg-dark' : ''}">
				<a class="page-link bg-transparent text-light text-opacity-50"
				href="index?page=${maxPage}" aria-label="Next"> <span
					aria-hidden="true">&raquo;</span>
			</a>
			</li>
		</ul>
	</nav>
</div>