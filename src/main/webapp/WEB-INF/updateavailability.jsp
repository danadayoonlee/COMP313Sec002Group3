<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<div class="col">
			<h3>Update Availability</h3>
		</div>
	</div>
	<br />
	<form method="post"
		action="/setavailabletime/${doctor.getEmployeeId()}">
		<div class="row">
			<div class="col-6">
				<label>Select Date</label><br /> <input type="date" name="date"
					id="date" class="form-control" required />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Available From</label><br /> <input type="time"
					name="startTime" id="startTime" class="form-control" required />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Available To</label><br /> <input type="time" name="endTime"
					id="endTime" class="form-control" required />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<button type="submit" class="btn btn-success">Update
					Schedule</button>
			</div>
		</div>
	</form>
	<br />
	<div class="row">
		<div class="col">
			<h3>My Schedule</h3>
		</div>
	</div>
	<br />
	<table class="table">
		<thead>
			<tr>
				<th>Date</th>
				<th>Start Time</th>
				<th>End Time</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${schedule.size() > 0}">
					<c:forEach var="i" items="${schedule}">
						<tr>
							<td>${i.getDate()}</td>
							<td>${i.getAvailableStartTime()}</td>
							<td>${i.getAvailableEndTime()}</td>
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