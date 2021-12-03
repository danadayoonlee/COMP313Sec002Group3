<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container" style="min-height: 100%;">
	<div class="form-row">
		<div class="col text-center">
			<h3 style="padding-top: 2%;">Patient Information</h3>
		</div>
	</div>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-8">
				<label class="font-weight-bold">Patient Name</label>&nbsp;<span
					th:inline="text">${patient.getName()}</span><br /> <label
					class="font-weight-bold">Date of Birth</label>&nbsp;<span
					th:inline="text">${patient.getDob()}</span><br /> <label
					class="font-weight-bold">Address</label>&nbsp;<span
					th:inline="text">${patient.getStreet()},
					${patient.getCity()}, ${patient.getProvince()},
					${patient.getPostal()}</span><br /> <label class="font-weight-bold">Contact
					No.</label>&nbsp;<span th:inline="text">${patient.getPhone()}</span><br />
				<label class="font-weight-bold">Email</label>&nbsp;<span
					th:inline="text">${patient.getEmail()}</span><br /> <label
					class="font-weight-bold">Family Doctor</label>&nbsp;<span
					th:inline="text">${familydoctor}</span><br />
			</div>
			<div class="col-4" height="100%">
			<a href="/addpatientmedicaldata/${patient.getPatientId()}" class="btn btn-primary" alt="Add Patient Medical Info" style="bottom:0;position:absolute;right:0;">+ Add Patient Medical Info</a>
			</div>
		</div>
	</div>
	<br />
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Check-up Date</th>
				<th>Location Of Visit</th>
				<th>Services Due</th>
				<th>Next Follow-up</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${medicalhistory.size() > 0}">
					<c:forEach items="${medicalhistory}" var="i">
						<tr>
							<td th:inline="text"><fmt:formatDate value="${i.getDateVisited()}" pattern="yyyy-MM-dd" /></td>
							<td th:inline="text">${i.getLocationOfVisit()}</td>
							<td th:inline="text">${i.getServicesDue()}</td>
							<td th:inline="text"><fmt:formatDate value="${i.getFollowUp()}" pattern="yyyy-MM-dd" />
							</td>
							<td><a href="/viewpatientmedicaldetail/${i.getId()}/patient/${patient.getPatientId()}">View</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5" class="text-center">No medical data found!</td>
					</tr>
				</c:otherwise>
			</c:choose>



		</tbody>
	</table>
</div>