<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<div class="col">
			<h3>Book An Appointment</h3>
		</div>
	</div>
	<br />
	<form method="post" action="/bookappointment/${patient.getPatientId()}">
	<div class="row">
		<div class="col-6">
			<label>Select Date</label><br />
			<input type="date" name="date" id="date" class="form-control" required/>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-6">
			<label>Doctor</label><br />
			<select class="form-control" name="doctorId" id="doctorId" required>
					<c:forEach var="i" items="${doctors}">
							<option value="${i.getEmployeeId()}">${i.getEmployeeName()}</option>
					</c:forEach>
			</select>
		</div>
	</div>
	<br />
		<div class="row">
		<div class="col-6">
			<button type="submit" class="btn btn-success">Find Available Appointments</button>
		</div>
	</div>
	</form>
</div>