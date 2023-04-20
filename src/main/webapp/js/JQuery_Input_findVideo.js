$('.input-title').keyup(function() {
	console.log($(this).innerText)
})

$('.dropdown-title').click(function(event) {
	event.preventDefault();
	$('.input-title').val(this.innerText)
	$.ajax({
		url: this.href,
		type: 'GET',
		contentType: 'application/json'
	})
		.done(function(data) {
			$('#tbody_list_User').html('')
			var htmls = data.map(function(user) {
				return `
                	<tr class="align-middle">
						<td>${user.userName}</td>
						<td>${user.email}</td>
					</tr>
                `
			})
			$('#tbody_list_User').html(htmls.join(''))
		}).fail(function() {
			$('#tbody_list_User').html(`
			<tr class="align-middle">
				<td class="text-center" colspan="2">No Data Availible</td>
			</tr> `)
		})

})

