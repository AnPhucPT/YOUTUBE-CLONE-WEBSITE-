$('#NewPassword').keyup(function() {
	if ($('#CurrentPassword').val() === "") {
		$('#NewPassword').val("")
		$('#CurrentPassword').focus()
		Swal.fire({
			position: 'top',
			icon: 'info',
			text: 'Please enter Your current password first!',
		})
	}
})

$('#ConfirmPassword').keyup(function() {
	if ($('#CurrentPassword').val() === "") {
		$('#ConfirmPassword').val("")
		$('#CurrentPassword').focus()
		Swal.fire({
			position: 'top',
			icon: 'info',
			text: 'Please enter Your current password first!',
		})
	} else if ($('#NewPassword').val() === "") {
		$('#ConfirmPassword').val("")
		$('#NewPassword').focus()
		Swal.fire({
			position: 'top',
			icon: 'info',
			text: 'Please enter Your new password first!',
		})
	}
})

$('#submit-btn').click(function() {
	if ($('#CurrentPassword').val() !== "" && $('#ConfirmPassword').val() !== "" && $('#NewPassword').val() !== "") {
		if ($('#ConfirmPassword').val() === $('#NewPassword').val()) {
			var newPassword = $('#NewPassword').val();
			var currentPassword = $('#CurrentPassword').val();
			var formData = {
				'CurrentPassword': currentPassword,
				'NewPassword': newPassword
			};
			$.ajax({
				url: 'ChangePass',
				type: 'POST',
				data: formData
			}).then(function() {
				Swal
					.fire({
						position: 'top',
						icon: 'success',
						text: 'Change password successfully',
					})
			}).fail(function() {
				$('#CurrentPassword')
					.val("")
				$('#CurrentPassword')
					.focus()
				Swal.fire({
					position: 'top',
					icon: 'error',
					text: 'Wrong current password!',
				})
			})
		} else {
			$('#ConfirmPassword').val("")
			$('#ConfirmPassword').focus()
			Swal.fire({
				position: 'top',
				icon: 'info',
				text: 'Your confirm password is not match the new password field!',
			})
		}

	} else {
		if ($('#CurrentPassword').val() === "") {
			$('#CurrentPassword').focus()
			Swal.fire({
				position: 'top',
				icon: 'info',
				text: 'Please enter Your current password!',
			})
		} else if ($('#NewPassword').val() === "") {
			$('#NewPassword').focus()
			Swal.fire({
				position: 'top',
				icon: 'info',
				text: 'Please enter Your new password!',
			})
		} else if ($('#ConfirmPassword').val() === "") {
			$('#ConfirmPassword').focus()
			Swal.fire({
				position: 'top',
				icon: 'info',
				text: 'Please enter Your Confirm password!',
			})
		}
	}

})