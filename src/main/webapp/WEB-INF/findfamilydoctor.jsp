<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">
	<div class="row">
		<div class="col">
			<h3>Find Family Doctor</h3>
		</div>
	</div>
	<br />
	<div class="row">
	<div class="col">
	<label>Available Physicians</label><br/>
	<select class="form-select" id="familydoctor" name="familydoctor">
	<option th:each="doctor: ${doctors}" th:value="${doctor.getEmployeeId()}" th:inline="text">${doctor.getEmployeeName()}</option>
	</select>
	</div>
	</div>
</div>