<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container">
	<div class="row">
		<div class="col"><h3>Patient Documents</h3></div>
	</div>
	<div class="row">
		<div class="col">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Patient Name</th>
						<th>File Name </th>
						<th>Document Type</th>
						<th>Date Posted</th>
						<th>Uploaded By</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${documents.size() > 0}">
							<c:forEach items="${documents}" var="i">
								<tr>
									<td th:inline="text">${i.getPatientName()}</td>
									<td>${i.getFileName()}</td>
									<td th:inline="text">${i.getDocumentType()}</td>
									<td th:inline="text"><fmt:formatDate
											value="${i.getDatePosted()}" pattern="yyyy-MM-dd" /></td>
									<td th:inline="text">${i.getDoctorName()}</td>
									<td>
																			<a
										href="/viewfile/${i.getFileName()}">View</a><br /><a
										href="/downloadfile/${i.getFileName()}">Download</a>

										</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="6" class="text-center">No documents uploaded!</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</div>