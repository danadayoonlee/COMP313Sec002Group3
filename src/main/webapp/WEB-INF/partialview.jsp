<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js" type="text/javasript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&family=Poppins:wght@200&display=swap" rel="stylesheet">
<title>My Template</title>
<style type="text/css">
li {
	list-style-type: none;
}
</style>
</head>
<body style = "background: white; height: 100%; color: black;">
<div class="container-fluid" style="font-family: 'Poppins', sans-serif;   min-height: 100%">
	<div class="row font-size-lg text-white" style="background-color: #181d45;padding-bottom: 10px;min-height:20%">
		<div class="col-6">
		<img src="resources/static/img/logo.PNG" alt="CuraHealthyMe"/>
		</div>
		<div class="col-6 text-right  font-size-lg">
		<a href="${pageContext.request.contextPath}/" style="color: white;">Home</a> |
		<a href="${pageContext.request.contextPath}/aboutus" style="color: white;">About Us</a> |
		<a href="${pageContext.request.contextPath}/contactus" style="color: white;">Contact Us</a> |
		<a href="${pageContext.request.contextPath}/news" style="color: white;">News</a> |
		<a href="${pageContext.request.contextPath}/login" style="color: white;">Login</a>
		</div>
	</div>
	<br />
	<div class="row">
		<div class="col">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>
	</div>
</div>
	<footer style="background-color: white;font-family: 'Poppins', sans-serif; position: relative; height: 100px; margin-to: -100px; clear: both;">
		<div class="row">
			<div class="col text-center">
				<span>Copyright &copy;curahealthyme</span>
			</div>
		</div>
	</footer>
</body>
</html>