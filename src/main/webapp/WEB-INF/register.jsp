<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">

	<form method="post" action="/register" th:object=${patient
		}
		style="width: 80%; margin-left: auto; margin-right: auto;">
		<div class="form-row">
			<div class="col text-center">
				<h1 style="padding-top: 2%;">Create An Account</h1>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<h3>Account holder personal information</h3>
				<hr />
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col text-center">
				<small class="text-danger" th:inline="text">${errorMsg}</small>
			</div>
		</div>
		<input type="text" hidden th:field="*{Id}" />
		<div class="row">
			<div class="col">
				<label>Full Name</label>&nbsp; <input type="text"
					class="form-control" name="name" th:field="*{Name}" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Date of Birth</label>&nbsp; <input type="date"
					class="form-control" name="dob" th:field="*{DOB}" />
			</div>
			<div class="col-6">
				<label>Gender</label>
				<div class="in-line">
					<div class="form-check">
						<input class="form-check-input" type="radio" th:field="*{Gender}"
							id="gendermale" name="gender" value="Male"> <label
							class="form-check-label" for="gendermale" > Male </label>
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" th:field="*{Gender}"
							id="genderfemale" name="gender" value="Female"> <label
							class="form-check-label" for="genderfemale"> Female </label>
					</div>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Street</label>&nbsp; <input type="text" class="form-control"
					name="street" th:field="*{Street}" />
			</div>
			<div class="col-6">
				<label>City</label>&nbsp; <input type="text" class="form-control"
					name="city" th:field="*{City}" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Province/State</label>&nbsp; <input type="text"
					class="form-control" name="province" th:field="*{Province}" />
			</div>
			<div class="col-6">
				<label>Country</label>&nbsp; <input type="text" class="form-control"
					name="country" th:field="*{Country}" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Postal Code</label>&nbsp; <input type="text"
					class="form-control" name="postal" th:field="*{Postal}" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Phone</label>&nbsp; <input type="number" class="form-control"
					name="phone" th:field="*{Phone}" />
			</div>
			<div class="col-6">
				<label>Email</label>&nbsp; <input type="email" class="form-control"
					name="email" th:field="*{Email}" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<h3>Account login details</h3>
				<hr />
			</div>
		</div>
		<div class="row">
			<div class="col-6">
				<label>User Role</label><br />
				<!-- <select class="selectpicker" id="useraccessid" name="useracessid" data-width="100%" >
					<option th:each="userrole: ${userAccess}" th:value="${userrole.UserAccessId}" th:text="${userrole.UserRole}"><option>
				</select>-->
				<select class="form-control" data-width="100%" id="useraccessid"
					name="useraccessid">
					<option value="1">Admin</option>
					<option value="2">HelpDesk</option>
					<option value="3">Doctor</option>
					<option value="4">Receptionist</option>
					<option value="5">Nurse</option>
					<option value="6">Patient</option>
				</select>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>User Name</label> <input type="text" class="form-control"
					name="username" id="username" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Password</label> <input type="password" class="form-control"
					name="password" id="passord" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Confirm Password</label> <input type="password"
					class="form-control" name="confirmpwd" id="confirmpwd" />
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