<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container" style="min-height: 100%">
	<div class="row">
		<div class="col">
			<h2>Find Family Doctor</h2>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<h3>Patient Information</h3>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table no-border">
				<tr>
					<td width="20%">Patient Name</td>
					<td th:inline="text" width="80%">${patient.getName()}</td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td th:inline="text">${patient.getDob()}</td>
				</tr>
			</table>
		</div>
	</div>
	<br />
	<form method="POST" action="/setfamilydoctor/${patient.getPatientId()}">
		<div class="row">
			<div class="col">
				<label>Available Physicians</label><br /> <select
					class="form-control" id="familydoctor" name="familydoctor">
				      <c:forEach items="${doctors}" var="i">  
         <option value="${doctors.get(i).getEmployeeId()}" >${doctors.get(i).getEmployeeName()}</option>
      </c:forEach>
				</select>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col text-center">
				<button class="btn btn-primary" type="submit" name="btnSetFamilyDoctor">Save</button>
			</div>
		</div>
	</form>

</div>