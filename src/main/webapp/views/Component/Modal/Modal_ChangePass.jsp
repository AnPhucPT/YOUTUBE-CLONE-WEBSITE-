<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div id="newPassword"
				class=" container bg-black col-12  px-5 pt-4 pb-3 border border-secondary rounded">
				<h4 class="text-center">CHANGE PASSWORD</h4>
				<hr>
				<div class="form-floating mb-3 ">
					<input type="password" name="CurrentPassword"
						class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
						id="CurrentPassword" placeholder="123"> <label
						for="CurrentPassword">Your current Password :</label>
				</div>
				<hr>
				<div class="form-floating mb-3 ">
					<input type="password" name="NewPassword"
						class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
						id="NewPassword" placeholder="123"> <label
						for="NewPassword">New Password :</label>
				</div>
				<div class="form-floating mb-4 ">
					<input type="password" name="ConfirmPassword"
						class="form-control text-white bg-black bg-opacity-50 border-secondary shadow-none px-3"
						id="ConfirmPassword" placeholder="123"> <label
						for="ConfirmPassword">Confirm new Password :</label>
				</div>
				<button id="submit-btn" type="submit"
					class="mb-4 btn w-100 btn-primary">Submit</button>
			</div>
		</div>
	</div>
</div>