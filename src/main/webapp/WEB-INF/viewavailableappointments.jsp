<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
	<div class="row">
		<div class="col">
			<h3>Book An Appointment</h3>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<span class="font-weight-bold">Patient Full Name: </span><span>${patient.getName()}</span>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<span class="font-weight-bold">Doctor: </span><span>${doctor.getEmployeeName()}</span>
		</div>
	</div>
	<hr />
	<br />
	<div class="row">
		<div class="col">
			<h3>Available Appointments</h3>
		</div>
	</div>

	<div class="row">
		<div class="col-8">
			<table class="table">
				<thead>
					<tr>
						<th>Start Time</th>
						<th>End Time</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${appointments.size() > 0}">
							<c:forEach var="i" items="${appointments}">
								<tr>
									<td><fmt:formatDate type="time"
											value="${i.getAppointmentStartTime()}" /></td>
									<td><fmt:formatDate type="time"
											value="${i.getAppointmentEndTime()}" /></td>
									<td>
										<form method="post"
											action="/bookdoctorappointment/${patient.getPatientId()}/${i.getAppointmentStartTime()}/${i.getAppointmentEndTime()}">
											<input type="hidden" id="doctorId" name="doctorId"
												value="${doctor.getEmployeeId()}" /> <input type="hidden"
												id="date" name="date" value="${i.getAppointmentDate()}" />
											<button type="submit" class="btn btn-primary">Book</button>
										</form>
									</td>
								</tr>

							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3" class="text-center">No availability found!</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>