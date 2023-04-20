<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<!-- Begin <head> -->
<%@ include file="/views/Component/Tag/Tag__Head.jsp"%>
<!-- End </head> -->

<body class="bg-black text-white rounded">
	<main>
		<!-- Begin form -->
		<form id="form-register"
			style="background-color: rgba(225, 225, 225, 0.2);"
			class="container text-white col-8 col-lg-3 mt-5 px-5 pt-4 pb-3 rounded"
			action="" method="post">

			<!-- Begin title -->
			<h3 class="text-center">REGISTER</h3>
			<hr>
			<!-- End title -->

			<!-- Begin input UserName -->
			<div class="form-floating mb-3 ">
				<input required type="text" name="UserName"
					class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
					id="UserName" placeholder="name@example.com"> <label
					for="tUserName">UserName :</label>
			</div>
			<!-- End input UserName -->

			<!-- Begin input Email -->
			<div class="form-floating mb-3 ">
				<input required type="email" name="Email"
					class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
					id="Email" placeholder="name@example.com"> <label
					for="Email">Email :</label>
			</div>
			<!-- End input Email -->

			<!-- Begin input Password -->
			<div class="form-floating mb-3 ">
				<input required type="password" name="Password"
					class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
					id="Password" placeholder="name@example.com"> <label
					for="Password">Password :</label>
			</div>
			<!-- End input Password -->

			<!-- Begin input Confirm Password -->
			<div class="form-floating mb-3 ">
				<input onkeyup="checkConfirmPassword()" required type="password"
					name="ConfirmPassword"
					class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
					id="ConfirmPassword" placeholder="123"> <label
					for="ConfirmPassword">Confirm Password :</label>
			</div>
			<!-- End input Confirm Password -->

			<!-- Begin input file image -->
			<div class="mb-3">
				<div class="input-group d-flex align-items-center mb-3">
					<!-- Begin input hidden -->
					<div class="form-floating ">
						<input required type="text" name="Avatar"
							class="form-control rounded text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
							id="Avatar" placeholder="123"> <label
							for="Avatar">Your Link Image :</label>
					</div>
					<img id="img_user"
						style="width: 50px; height: 50px; object-fit: cover;" src=""
						class="img-fluid rounded-circle visually-hidden ms-3" alt="">
				</div>
			</div>
			<!-- End input file image  -->

			<!-- Begin Button Submit -->
			<button onclick="submitForm()" id="btn-submit" type=" submit"
				class="mb-4 mt-3 btn w-100 bg-primary bg-opacity-75 text-white">Register</button>
			<!-- End Button Submit -->

			<!-- Begin form footer -->
			<p class="text-center">
				Already have an account? <a class="text-decoration-none"
					href="Login">Sign in now</a>
			</p>
			<!-- End form footer -->

		</form>

	</main>
	<footer> </footer>

	<!-- Begin JS for show message -->
	<script>
		if ("${status}") {
			Swal.fire({
				icon : 'error',
				text : '${status}',
			})
		}
	</script>
	<!-- End JS for show message -->

	<!-- Begin JS for show IMG input file -->
	<!-- <script src="js/JS_showIMG_inputFile.js"></script> -->
	<!-- End JS for show IMG input file -->

	<!-- Begin JQuery for Check Register -->
	<script src="js/JQuery_CheckRegister.js"></script>
	<!-- End JQuery for Check Register -->

	<!-- Begin JS for show IMG Avatar -->
	<script src="js/JS_showAvatarUser.js"></script>
	<!-- End JS for show IMG Avatar -->
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