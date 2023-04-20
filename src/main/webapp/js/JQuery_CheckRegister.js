var password = document.getElementById('Password');
var ConfirmPassword = document.getElementById('ConfirmPassword')
document.getElementById('form-register').onsubmit = function(e) {
	e.preventDefault();
}
function submitForm() {
	if (password.value.trim() !== ConfirmPassword.value.trim()) {
		ConfirmPassword.focus()
		Swal.fire({
			icon: 'error',
			text: 'Mật khẩu không trùng. Vui lòng nhập lại ',
		})
	} else {
		document.getElementById('form-register').submit()
	}
}
function checkConfirmPassword() {
	if (password.value.trim() === "") {
		password.focus()
		Swal.fire({
			icon: 'info',
			text: 'Vui lòng nhập trường password trước',
		})
	}
}