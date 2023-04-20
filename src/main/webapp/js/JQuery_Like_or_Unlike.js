$('#LikeOrUnlike').click(function(event) {
	event.preventDefault();
	$.ajax(this.href, {
		success: function(data) {
			$('#LikeOrUnlike').toggleClass('btn-outline-danger')
			$('#LikeOrUnlike').toggleClass('btn-danger')
		},
		error: function() {
			Swal.fire({
				icon: 'error',
				text: 'Something went wrong...',
			})
		}
	});
});