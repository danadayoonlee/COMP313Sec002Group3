<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div id="container" style="min-height: 100%">
	<div class="form-row">
		<div class="col text-center">
			<h3 style="padding-top: 2%;">Patient Information</h3>
		</div>
	</div>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-6">
				<label class="font-weight-bold">Patient Name</label>&nbsp;<span
					th:inline="text">${patient.getName()}</span><br /> <label
					class="font-weight-bold">Date of Birth</label>&nbsp;<span
					th:inline="text">${patient.getDob()}</span><br />
			</div>
		</div>
	</div>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<input type="hidden" name="patientId" value="${patient.getPatientId()}" />
		<input type="hidden" name="doctorId" value="${doctor}" />
		<div class="row">
			<div class="col-3">
				<select class="form-control" name="documentType" id="documentType">
					<option value="test-requisition">Test Requisition</option>
					<option value="test-result">Test Result</option>
					<option value="prescription">Prescription</option>
				</select>
			</div>
			<div class="col-6">
				<input type="file" placeholder="Selected file" name="file" id="file"
					class="form-control" />
			</div>
			<div class="col-3">
				<button type="submit" class="btn btn-success">Upload
					Document</button>
			</div>
		</div>
	</form>
</div>