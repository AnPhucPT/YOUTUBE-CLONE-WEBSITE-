var statusMessage;
document.getElementById('Email').focus();

$('#submit-btn')
	.click(
		function(event) {
			$('#loading').toggleClass("visually-hidden");
			statusMessage = ''
			var email = $('#Email').val();
			var formData = {
				'email': email
			};
			$
				.ajax({
					url: 'ForgotPass',
					type: 'POST',
					data: formData
				})
				.then(
					function(data) {
						$('#loading').toggleClass(
							"visually-hidden");
						Swal
							.fire({
								position: 'top',
								icon: 'success',
								text: 'Please check your email. \n Move to home page in 2 sec...',
							})
						setTimeout(
							function() {
								window.location.href = 'http://localhost:8080/ASM/index'
							}, 5 * 1000);
					}).fail(
						function(error) {
							$('#loading').toggleClass(
								"visually-hidden");
							Swal.fire({
								position: 'top',
								icon: 'error',
								text: 'Valid email',
							})
						})
		});