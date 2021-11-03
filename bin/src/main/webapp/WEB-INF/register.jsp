<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">

	<form method="post" action="/registeruser"
		style="width: 80%; margin-left: auto; margin-right: auto;">
		<div class="form-row">
			<div class="col">
				<h1>Create An Account</h1>
			</div>
		</div>
		<br />
		<div class="row">
		<div class="col">
		<h3>Account holder personal information</h3>
		<hr />
		</div>
		</div>
		<br >
		<div class="row">
			<div class="col">
				<label>Full Name</label>&nbsp; <input type="text"
					class="form-control" name="name" id="name" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Date of Birth</label>&nbsp; <input type="date"
					class="form-control" name="dob" id="dob" />
			</div>
			<div class="col-6">
				<label>Gender</label>
				<div class="in-line">
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="gendermale" value="Male"> <label
							class="form-check-label" for="gendermale"> Male </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="gender"
							id="genderfemale" value="Female"> <label
							class="form-check-label" for="genderfemale"> Female </label>
					</div>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Street</label>&nbsp; <input type="text" class="form-control"
					name="street" id="street" />
			</div>
			<div class="col-6">
				<label>City</label>&nbsp; <input type="text" class="form-control"
					name="city" id="city" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Province/State</label>&nbsp; <input type="text"
					class="form-control" name="province" id="province" />
			</div>
			<div class="col-6">
				<label>Country</label>&nbsp; <input type="text" class="form-control"
					name="country" id="country" />
			</div>
		</div>
		<br />
		<div class="row">
					<div class="col-6">
				<label>Postal Code</label>&nbsp; <input type="text"
					class="form-control" name="postal" id="postal" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Phone</label>&nbsp; <input type="number" class="form-control"
					name="phone" id="phone" />
			</div>
			<div class="col-6">
				<label>Email</label>&nbsp; <input type="email" class="form-control"
					name="email" id="email" />
			</div>
		</div>
		<br />
				<div class="row">
		<div class="col">
		<h3>Account login details</h3>
		<hr />
		</div>
		</div>
		<br >
		<div class="row">
			<div class="col-6">
				<label>User Name</label>
				<input type="text" class="form-control" name="username" id="username" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Password</label>
				<input type="password" class="form-control" name="password" id="password" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Confirm Password</label>
				<input type="text" class="form-control" name="confirmpwd" id="confirmpwd" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col text-center">
				<button class="btn btn-primary" type="submit" name="btnRegister"
					id="btnRegister">Create an Account</button>
			</div>
		</div>
	</form>
</div>