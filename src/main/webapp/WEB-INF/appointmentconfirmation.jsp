<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="row">
		<div class="col">
			<h3>Appointment Confirmation</h3>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-6">
			<label>Patient Name </label> <label>${patient.getName()}</label>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-6">
			<label>Doctor Name </label> <label>${doctor.getEmployeeName()}</label>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-6">
			<label>Appointment Date </label><label>${appointment.getAppointmentDate()}</label>
		</div>
	</div>
		<br />
	<div class="row">
		<div class="col-6">
			<label>Time </label><label><fmt:formatDate type="time"
											value="${appointment.getAppointmentStartTime()}" /> to <fmt:formatDate type="time"
											value="${appointment.getAppointmentEndTime()}" /></label>
		</div>
	</div>
</div>