
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
				<th>Followup Date</th>
				<th>Need Checkup Or Not</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="i" items="${patients}">
				<tr>
					<td th:inline="text">${i.getName()}</td>
					<td th:inline="text">${i.getDate()}</td>
					<td th:inline="text">${i.getCheckup()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
