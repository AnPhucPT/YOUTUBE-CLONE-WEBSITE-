document.getElementById('Avatar').addEventListener("keyup", () => {
	if (document.getElementById('Avatar').value == '') {
		document.getElementById('img_user').classList.add('visually-hidden')
	} else {
		document.getElementById('img_user').src = document.getElementById('Avatar').value
		document.getElementById('img_user').classList.remove('visually-hidden')
	}
})