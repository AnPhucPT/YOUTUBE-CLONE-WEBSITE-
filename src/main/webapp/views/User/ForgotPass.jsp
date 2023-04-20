<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<!-- Begin <head> -->
<%@ include file="/views/Component/Tag/Tag__Head.jsp"%>
<!-- End </head> -->

<body class="bg-black text-white rounded">
	<%-- <%@ include file="/comon/Header/NoLogin_Header.jsp"%> --%>
	<main class="">
		<!-- Begin Form -->
		<div style="background-color: rgba(225, 225, 225, 0.2);"
			class="position-relative container text-white col-8 col-lg-3 px-5 mt-5 pt-4 pb-3 rounded">
			
			<!-- Begin title -->
			<h4 class="text-center">FORGOT PASSWORD</h4>
			<hr>
			<!-- End title -->
			
			<!-- Begin Email input -->
			<div class="form-floating">
				<input required type="email" name="Email"
					class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
					id="Email" placeholder="name@example.com"> <label
					for="Email">Email :</label>
			</div>
			<!-- End Email input -->
			
			<!-- Begin Submit Button -->
			<button id="submit-btn" type="submit"
				class="mb-4 mt-3 btn w-100 bg-primary bg-opacity-75 text-white">Send
				new password</button>
			<!-- End Submit Button -->
		
			<!-- Begin footer -->
			<p class="text-center">
				Don't have an account? <a class="text-decoration-none"
					href="Register">Sign up now</a>
			</p>
			<!-- End footer -->
			
			<!-- Begin Loading -->
			<div id="loading"
				class="position-absolute top-0 end-0 rounded w-100 h-100 bg-black bg-opacity-50 d-flex justify-content-center align-items-center visually-hidden">
				<img style="width: 100px; height: 100px; object-fit: cover;"
					src="https://cdn.pixabay.com/animation/2022/10/11/03/16/03-16-39-160_512.gif"
					class="img-fluid w-10" alt="">
			</div>
			<!-- End Loading -->
			
		</div>
		<!-- End Form -->
		
	</main>
	<footer> </footer>
	
	
	<!-- Begin JQuery for Forgot Password -->
	<script src="js/JQuery_ForgotPass.js"></script>
	<!-- End JQuery for Forgot Password -->
	
	
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