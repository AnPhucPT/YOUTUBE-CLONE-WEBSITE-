$('#submit-btn-email').click(function() {
	if($('#Email').val() != '') {
		$('#loading').toggleClass("visually-hidden");
	setTimeout(
		function() {
			$('#loading').toggleClass("visually-hidden");
			Swal.fire({
				position: 'top',
				icon: 'success',
				text: 'Send mail successfully...',
			})
			$('#Email').val('')
			$('#Email').focus()
		}, 3 * 1000);
	}
});