<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div id="container" style="min-height: 100%">
	<div class="text-right">
		<a href="/logout" title="logout">Logout</a>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<h3>Welcome, ${USERNAME}</h3>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<table class="table no-border">
				<tr>
					<td width="20%">Employee Name</td>
					<td th:inline="text" width="80%">${user.getEmployeeName()}</td>
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td th:inline="text">${user.getDob()}</td>
				</tr>
				<tr>
					<td colspan="2">
						<div class="container">
							<div class="row">
								<div class="col-4">
									<a class="btn btn-secondary  btn-lg btn-block"
										href="/viewmypatients/${user.getEmployeeId()}"
										title="View My Patients">View My Patients</a>
								</div>
								<div class="col-4">
									<a class="btn btn-secondary  btn-lg btn-block"
										href="/viewallpatients" title="View All Patients">View All
										Patients</a>
								</div>
								<div class="col-4">
									<a class="btn btn-secondary  btn-lg btn-block"
										href="/uploadeddocuments" title="Uploaded Documents">Uploaded Documents</a>
								</div>
							</div>
							<br />
							<div class="row">
								<div class="col-4">
									<a class="btn btn-secondary  btn-lg btn-block"
										href="/sendtestrequisition" title="Send Test Requisitions">Send
										Test Requisition</a>
								</div>
								<div class="col-4">
									<a class="btn btn-secondary  btn-lg btn-block"
										href="/sendtestresult" title="Send Test Requisitions">Send
										Test result</a>
								</div>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>

