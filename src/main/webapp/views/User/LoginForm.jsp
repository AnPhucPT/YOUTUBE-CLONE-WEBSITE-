<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">

<!-- Begin <head> -->
<head>
<title>Login</title>
<link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/512/1384/1384060.png">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.4/jquery.min.js"
	integrity="sha512-pumBsjNRGGqkPzKHndZMaAG+bir374sORyzM3uulLV14lN5LyykqNk8eEeUlUkB3U0M4FApyaHraT65ihJhDpQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<!-- End </head> -->

<body class="bg-black text-white rounded">
	<main class="">
		<!-- Begin Form -->
		<form style="background-color: rgba(225, 225, 225, 0.2);"
			class="container text-white col-8 col-lg-3 mt-5 px-5 pt-4 pb-3 rounded"
			action="" method="post">
			<!-- Begin title -->
			<h4 class="text-center">LOGIN</h4>
			<hr>
			<!-- End Title -->

			<!-- Begin input UserName -->
			<div class="form-floating mb-3 ">
				<input required type="text" name="UserName"
					class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
					id="UserName" placeholder="name@example.com"> <label
					for="tUserName">UserName :</label>
			</div>
			<!-- End input UserName -->

			<!-- Begin input Password -->
			<div class="form-floating mb-3 ">
				<input required type="password" name="Password"
					class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
					id="Password" placeholder="name@example.com"> <label
					for="Password">Password :</label>
			</div>
			<!-- End input Password -->

			<!-- Begin input Checkbox -->
			<div class="d-flex justify-content-between">
				<div class="form-check mb-3">
					<input class="form-check-input " type="checkbox" value=""
						id="Remember"> <label class="form-check-label"
						for="Remember"> Remember me? </label>
				</div>
				<a href="ForgotPass" class="text-decoration-none text-info">Forgot
					password</a>
			</div>
			<!-- End input Checkbox -->

			<!-- Begin Submit Button -->
			<button type="submit" name="submit-button"
				class="mb-4 mt-3 btn w-100 bg-info bg-opacity-75 text-white">Login</button>
			<!-- End Sutbmit Button -->

			<!-- Begin footer form -->
			<p class="text-center">
				Don't have an account? <a class="text-decoration-none text-info"
					href="Register">Sign up now</a>
			</p>
			<!-- End footer form -->

		</form>
		<!-- End form -->

	</main>
	<footer> </footer>

	<!-- Begin JQuery for Check Login -->
	<script>
		document.getElementById('UserName').focus()
		if ("${status}") {
			Swal.fire({
				icon : 'error',
				text : '${status}',
			})
		}
	</script>
	<!-- End JQuery for Check Login -->

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