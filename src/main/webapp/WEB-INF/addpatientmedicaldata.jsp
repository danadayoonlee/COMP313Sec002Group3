<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorator="legal/layouts/main/main-layout" >
<head>
<link href="http://localhost:8083/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="http://localhost:8083/webjars/bootstrap/4.3.1/js/bootstrap.min.js" type="text/javasript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&family=Poppins:wght@200&display=swap" rel="stylesheet">
<title>CuraHealthyMe</title>
<style type="text/css">
li {
	list-style-type: none;
}
</style>

</head>
<body style = "background: white; height: 100%; color: black;">
<div style="font-family: 'Poppins', sans-serif;   min-height: 85%">
	<div class="row text-white" style="background-color: #181d45; margin: 0 !important;">
		<div class="col-5">
		<img src="http://localhost:8083/resources/static/img/logo.PNG" alt="CuraHealthyMe" height="150px"/>
		</div>
		<div class="col-7 text-right" style="font-size:20px;">
		<a href="${pageContext.request.contextPath}/" style="color: white;">Home</a> |
		<a href="${pageContext.request.contextPath}/aboutus" style="color: white;">About Us</a> |
		<a href="${pageContext.request.contextPath}/contactus" style="color: white;">Contact Us</a> |
		<a href="${pageContext.request.contextPath}/news" style="color: white;">News</a> |
		<%
		if(request.getSession().getAttribute("USERNAME") == null){
		%>
		<a href="${pageContext.request.contextPath}/login" style="color: white;">Login</a>
		<%
		}
		%>
		<%
		if(request.getSession().getAttribute("USERNAME") != null){
		%>
		<a href="${pageContext.request.contextPath}/logout" style="color: white;">Logout</a>
		<%
		}
		%>
		</div></div>
		<br />
		<div class="row" style="margin: 0 !important;">
			<div class="col">
			
			
<div class="container">

	<form method="post" action="/addpatientdata/${patient.getPatientId()}" th:object="${patientmedicalinfo}"
		style="width: 80%; margin-left: auto; margin-right: auto;">
		<input type="hidden" th:field="*{Id}" >
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
					class="form-control" name="dateVisited" value="${date}"/>
			</div>
		</div>
		
		<div class="row">
			<div class="col">
				<label>Medical Visit Reason</label>
				<textarea class="form-control" rows="3" 
					id="reasonForVisit" name="reasonForVisit" ></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Problems</label>
				<textarea class="form-control" rows="3" 
					id="problems" name="problems"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Medications</label>
				<textarea class="form-control" rows="3" name="medications"
					  name="medications"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Allergies</label>
				<textarea class="form-control" rows="3" name="allergies"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Treatment</label>
				<textarea class="form-control" rows="3" name="treatment"></textarea>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col">
				<label>Services Due</label><input type="text" class="form-control"
					  name="servicesDue"/>
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
					class="form-control" name="followUp" value="${date}"/>
			</div>
		</div>
		<br />
		<button type="submit">Save</button>

	</form>
</div>


</div>
		</div>
	</div>
	<footer
		style="background-color: white; font-family: 'Poppins', sans-serif; position: relative; min-height: 10%; margin-to: -100px; clear: both;">
		<div class="row" style="margin: 0 !important;">
			<div class="col text-center">
				<span>Copyright &copy; CuraHealthyMe</span>
			</div>
		</div>
	</footer>
	
</body>
</html>