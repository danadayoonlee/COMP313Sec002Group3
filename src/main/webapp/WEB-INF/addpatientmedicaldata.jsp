<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">

	<form method="post" action="/addpatientdata/${patient.getPatientId()}"
		th:object="${patientmedicalinfo}"	style="width: 80%; margin-left: auto; margin-right: auto;">
		<div class="form-row">
			<div class="col text-center">
				<h3 style="padding-top: 2%;">Patient Information</h3>
			</div>
		</div>
		<br>
		<input type="hidden" name="patientId" value="${patient.getPatientId()}" />
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<table class="table table-striped">
						<tr>
							<td class="font-weight-bold">Patient Name</td>
							<td>${patient.getName()}</td>
						</tr>
						<tr>
							<td class="font-weight-bold">Date of Birth</td>
							<td>${patient.getDob()}</td>
						</tr>
						<tr>
							<td class="font-weight-bold">Address</td>
							<td>${patient.getStreet()},${patient.getCity()},
								${patient.getProvince()}, ${patient.getPostal()}</td>
						</tr>
						<tr>
							<td class="font-weight-bold">Contact No.</td>
							<td>${patient.getPhone()}</td>
						</tr>
						<tr>
							<td class="font-weight-bold">Email</td>
							<td>${patient.getEmail()}</td>
						</tr>
						<tr>
							<td class="font-weight-bold">Family Doctor</td>
							<td>${familydoctor}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col text-center">
				<small class="text-danger" th:inline="text">${errorMsg}</small>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Medical Visit Reason</label>
				<textarea class="form-control" rows="3" name="reasonforvisit"
					th:field="*{ReasonForVisit}"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Problems</label>
				<textarea class="form-control" rows="3" name="problems"
					th:field="*{Problems}"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Medications</label>
				<textarea class="form-control" rows="3" name="medications"
					th:field="*{Medications}"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Allergies</label>
				<textarea class="form-control" rows="3" name="allergies"
					th:field="*{Allergies}"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Treatment</label>
				<textarea class="form-control" rows="3" name="treatment"
					th:field="*{Treatment}"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Services Due</label><input type="text" class="form-control"
					name="servicedue" th:field="*{ServicesDue}" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Location Of Visit</label> <select class="form-control"
					name="visitlocation" th:field="*{LocationOfVisit}">
					<option value="Virtual">Virtual</option>
					<option value="Clinic">Clinic</option>
				</select>
			</div>
			<div class="col-6">
				<label>Next Follow-up</label> <input type="date"
					class="form-control" name="followup" th:field="*{FollowUp}" />
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col text-center">
				<button type="submit" class="btn btn-success">Save</button>
			</div>
		</div>

	</form>
</div>