
			
<div class="container">

	<form method="post" action="/addpatientdata/${patient.getPatientId()}" th:object="${patientmedicalinfo}"
		style="width: 80%; margin-left: auto; margin-right: auto;">
		<input type="hidden" th:field="*{Id}">
		<div class="form-row">
			<div class="col text-center">
				<h3 style="padding-top: 2%;">Patient Information</h3>
			</div>
		</div>
		<br>
		<div class="container-fluid">
			<div class="row">
				<div class="col">
					<label class="text-bold">Patient Name:</label><span
						>&nbsp;&nbsp;&nbsp;${patient.getName()}</span><br /> <label class="text-bold">Date
						of Birth:</label><span th:text="">&nbsp;&nbsp;&nbsp;${patient.getDob()}</span><br /> <label
						class="text-bold">Address:</label><span
						th:text="">&nbsp;&nbsp;&nbsp;${patient.getStreet()}, ${patient.getCity()}, ${patient.getProvince()}, ${patient.getPostal()}</span><br />
					<label class="text-bold">Contact No.:</label><span
						th:text="">&nbsp;&nbsp;&nbsp;${patient.getPhone()}</span><br /> <label class="text-bold">Email:</label><span
						th:text="">&nbsp;&nbsp;&nbsp;${patient.getEmail()}</span><br /> <label class="text-bold">Family
						Doctor:</label><span th:text="">&nbsp;&nbsp;&nbsp;${familydoctor}</span><br />
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
			<div class="col-6">
				<label>Disease</label> 
				<select class="form-select"
					name="diseaseId" th:field="*{DiseaseId}">
					<c:forEach var="disease" items="${diseases}">
						<option value="${disease.getDiseaseId()}">${disease.getDiseaseName()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-6">
				<label>Date Visited</label> <input type="date"
					class="form-control" name="dateVisited" value="${patientmedicalinfo.getDateVisited()}" />
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<label>Medical Visit Reason</label>
				<textarea class="form-control" rows="3" 
					id="reasonForVisit" name="reasonForVisit" >${patientmedicalinfo.getReasonForVisit()}</textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Problems</label>
				<textarea class="form-control" rows="3" 
					id="problems" name="problems">${patientmedicalinfo.getProblems()}</textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Medications</label>
				<textarea class="form-control" rows="3" name="medications"
					  name="medications">${patientmedicalinfo.getMedications()}</textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Allergies</label>
				<textarea class="form-control" rows="3" name="allergies">${patientmedicalinfo.getAllergies()}</textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Treatment</label>
				<textarea class="form-control" rows="3" name="treatment">${patientmedicalinfo.getTreatment()}</textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Services Due</label><input type="text" class="form-control"
					 value="${patientmedicalinfo.getServicesDue()}" name="servicesDue"/>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-6">
				<label>Location Of Visit</label> <select class="form-select"
					name="locationOfVisit" th:field="*{LocationOfVisit}">
					<option value="Virtual">Virtual</option>
					<option value="Clinic">Clinic</option>
				</select>
			</div>
			<div class="col-6">
				<label>Next Follow-up</label> <input type="date"
					class="form-control" name="followUp" value="${patientmedicalinfo.getFollowUp()}" />
			</div>
		</div>
		<br />
		<button type="submit">Save</button>

	</form>
</div>
