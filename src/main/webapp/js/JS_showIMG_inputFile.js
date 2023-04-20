function chooseFile(fileInput) {
	if (fileInput.files && fileInput.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			document.getElementById('img-file').setAttribute('src',
				e.target.result)
			document.getElementById('img-file').classList
				.toggle('visually-hidden')
		}
		reader.readAsDataURL(fileInput.files[0])
	}
}