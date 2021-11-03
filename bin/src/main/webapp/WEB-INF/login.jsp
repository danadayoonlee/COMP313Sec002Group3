<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">
	<div class="form-row">
		<div class="col text-center">
			<h1>Login</h1>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col text-center">
		<small class="text-danger" th:inline="text">${errorMsg}</small>
		</div>
		</div>
	<form method="post" action="/login" style="width: 50%; margin-left: auto; margin-right: auto;">
		<div class="row">
			<div class="col">
				<label>Username</label>&nbsp; <input type="text"
					class="form-control" name="username" id="username" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Password</label>&nbsp; <input type="password"
					class="form-control" name="password" id="password" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col text-center">
				<button class="btn btn-primary" type="submit" name="btnLogin"
					id="btnLogin">Login</button>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col text-center">
				<span>Don't have an account? <a href="/register">click
						here</a> to register!</span>
			</div>
		</div>
	</form>

</div>
