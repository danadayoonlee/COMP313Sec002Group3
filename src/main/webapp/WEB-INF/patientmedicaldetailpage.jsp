<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">

	<div class="form-row">
		<div class="col text-center">
			<h3 style="padding-top: 2%;">Patient Information</h3>
		</div>
	</div>
	<br> <input type="hidden" name="patientId"
		value="${patient.getPatientId()}" />
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
		<div class="col">
			<label>Medical Visit Reason</label>
			<textarea class="form-control" rows="3" name="reasonforvisit"
				readonly>${medicaldata.getReasonForVisit()}</textarea>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<label>Problems</label>
			<textarea class="form-control" rows="3" name="problems" readonly>${medicaldata.getProblems()}</textarea>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<label>Medications</label>
			<textarea class="form-control" rows="3" name="medications" readonly>${medicaldata.getMedications()}</textarea>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<label>Allergies</label>
			<textarea class="form-control" rows="3" name="allergies" readonly>${medicaldata.getAllergies()}</textarea>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<label>Treatment</label>
			<textarea class="form-control" rows="3" name="treatment" value=""
				readonly>${medicaldata.getTreatment()}</textarea>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<label>Services Due</label><input type="text" class="form-control"
				name="servicedue" value="${medicaldata.getServicesDue()}" readonly />
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col-6">
			<label>Location Of Visit</label> <input type=text
				class="form-control" name="visitlocation"
				value="${medicaldata.getLocationOfVisit()}" readonly>
		</div>
		<div class="col-6">
			<label>Next Follow-up</label> <br />
			<fmt:formatDate value="${medicaldata.getFollowUp()}"
				pattern="dd/MM/yyyy" />
		</div>
	</div>
</div>