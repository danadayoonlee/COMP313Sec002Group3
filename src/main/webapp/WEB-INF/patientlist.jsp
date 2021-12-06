<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<c:choose>
				<c:when test="${patients.size() > 0}">
					<c:forEach var="i" items="${patients}">
						<tr>
							<td th:inline="text">${i.getName()}</td>
							<td th:inline="text">${i.getDob()}</td>
							<td th:inline="text">${i.getPhone()}</td>
							<td th:inline="text"></td>
							<td th:inline="text"><a
								href="/viewmedicalhistory/${i.getPatientId()}">View</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="6" class="text-center">No patients found!</td>
					</tr>
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>
</div>