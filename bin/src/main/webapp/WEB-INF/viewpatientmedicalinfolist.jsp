<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">
	<div class="form-row">
		<div class="col text-center">
			<h3 style="padding-top: 2%;">Patient Information</h3>
		</div>
	</div>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<label class="text-bold">Patient Name</label><span
					th:text="${patient.Name}"></span><br /> <label class="text-bold">Date
					of Birth</label><span th:text="${patient.DOB}"></span><br /> <label
					class="text-bold">Address</label><span
					th:text="${patient.Street}, ${patient.City}, ${patient.Province}, ${patient.Postal}"></span><br />
				<label class="text-bold">Contact No.</label><span
					th:text="${patient.Phone}"></span><br /> <label class="text-bold">Email</label><span
					th:text="${patient.Email}"></span><br /> <label class="text-bold">Family
					Doctor</label><span th:text="${familydoctor}"></span><br />
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
				<td th:text="${data.DateVisited}"></td>
				<td th:text="${data.LocationOfVisit}"></td>
				<td th:text="${data.ServicesDue}"></td>
				<td></td>
				<td th:text="${data.FollowUp}">Next Follow-up</td>
				<td><a href="/viewpatientmedicaldetail/${data.Id}">View</a></td>
			</tr>
		</tbody>
	</table>
</div>