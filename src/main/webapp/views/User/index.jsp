<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<!-- Begin Modal -->
		<%@ include file="/views/Component/Modal/Modal_ChangePass.jsp"%>
		<!-- End Modal -->

		<!-- Begin Container -->
		<div class="container">
			<div class="row">

				<!-- Begin Aside -->
				<%@ include file="/views/Component/Aside/Aside_index.jsp"%>
				<!-- End Aside -->

				<!-- Begin Content -->
				<div class="col">
					<%@ include file="/views/Component/Content/Content_index.jsp"%>
				</div>
				<!-- End Content -->

			</div>
		</div>
		<!-- End Container -->

	</main>

	<!-- Begin JQuery for Modal Change Password -->
	<script src="js/JQuery_ChangePassword.js"></script>
	<!-- End JQuery for Modal Change Password -->
	
	<!-- Begin JQuery for input find video by title -->
	<script src="js/JQuery_Input_findVideo.js"></script>
	<!-- End JQuery for input find video by title -->
	
	<!-- Begin JQuery for show IMG-Poster onkeyup  -->
	<script src="js/JQuery_showPoster.js"></script>
	<!-- End JQuery for show IMG-Poster onkeyup  -->
	
	<!-- Begin JQuery for Reset Form CRUD video  -->
	<script src="js/JS_ResetForm_Video.js"></script>
	<!-- End JQuery for Reset Form CRUD video  -->
	
	<!-- Begin JS for show avatar IMG -->
	<script src="js/JS_showAvatarUser.js"></script>
	<!-- End JS for show avatar IMG -->
	
	

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