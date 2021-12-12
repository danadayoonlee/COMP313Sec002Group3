<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="container" style="min-height: 100%;">
	<div class="row">
		<div class="col">
			<h3>Patients</h3>
		</div>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Name</th>
				<th>DOB</th>
				<th>Contact No.</th>
				<th>Family Physician</th>
				<th>Actions</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="patient" items="${patients}">
				<tr>
					<td th:inline="text">${patient.getName()}</td>
					<td th:inline="text">${patient.getDob()}</td>
					<td th:inline="text">${patient.getPhone()}</td>
					<td th:inline="text"></td>
					<td th:inline="text">
						<a class="btn btn-secondary  btn-xs"
										href="/historyview/${patient.getPatientId()}"
										title="find family doctor" style="display:${histrySize}">View</a>
					
						<a class="btn btn-secondary  btn-xs"
										href="/history/${patient.getPatientId()}"
										title="find family doctor">Modify</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>