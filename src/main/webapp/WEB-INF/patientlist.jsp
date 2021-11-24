<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
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
<c:forEach var="i" items="${patients}">
<tr>
<td th:inline="text">${patients.get(i).getName()}</td>
<td th:inline="text">${patients.get(i).getDob()}</td>
<td th:inline="text">${patients.get(i).getPhone()}</td>
<td th:inline="text"></td>
<td th:inline="text">${i}</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>