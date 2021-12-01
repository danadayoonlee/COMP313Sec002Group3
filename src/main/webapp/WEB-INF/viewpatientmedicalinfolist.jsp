<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container" style="min-height:100%;">
	<div class="form-row">
		<div class="col text-center">
			<h3 style="padding-top: 2%;">Patient Information</h3>
		</div>
	</div>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<label class="font-weight-bold">Patient Name</label>&nbsp;<span
					th:inline="text">${patient.getName()}</span><br /> <label class="font-weight-bold">Date
					of Birth</label>&nbsp;<span th:inline="text">${patient.getDob()}</span><br /> <label
					class="font-weight-bold">Address</label>&nbsp;<span
					th:inline="text">${patient.getStreet()}, ${patient.getCity()}, ${patient.getProvince()}, ${patient.getPostal()}</span><br />
				<label class="font-weight-bold">Contact No.</label>&nbsp;<span
					th:inline="text">${patient.getPhone()}</span><br /> <label class="font-weight-bold">Email</label>&nbsp;<span
					th:inline="text">${patient.getEmail()}</span><br /> <label class="font-weight-bold">Family
					Doctor</label>&nbsp;<span th:inline="text">${familydoctor}</span><br />
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
				<th>Health Condition</th>
				<th>Next Follow-up</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<tr th:each="data: ${medicalhistory}">
				<td th:inline="text">${data.getDateVisited()}</td>
				<td  th:inline="text">${data.getLocationOfVisit()}</td>
				<td th:inline="text">${data.getServicesDue()}</td>
				<td></td>
				<td th:inline="text">${data.getFollowUp()}</td>
				<td><a href="/viewpatientmedicaldetail/${data.Id}">View</a></td>
			</tr>
			
		</tbody>
	</table>
</div>