<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container" style="min-height: 100%;">
	<div class="row">
		<div class="col">
			<h3>Appointments</h3>
		</div>
	</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Patient Name</th>
					<th>Appointment Date</th>
					<th>Appointment Time</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${appointments.size() > 0}">
						<c:forEach var="i" items="${appointments}">
							<tr>
								<td>${i.getJoinId()}</td>
								<td><fmt:formatDate type="date"
											value="${i.getAppointmentDate()}" /></td>
								<td><fmt:formatDate type="time"
											value="${i.getAppointmentStartTime()}" /> - 
								<fmt:formatDate type="time"
											value="${i.getAppointmentEndTime()}" /></td>
								<td></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6" class="text-center">No Appointment found!</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
</div>