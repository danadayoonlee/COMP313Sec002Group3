<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js" type="text/javasript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&family=Poppins:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>My Template</title>
<style type="text/css">
li {
	list-style-type: none;
}
</style>
</head>
<body style = "background: white; height: 100%; color: black;">
<div class="container-fluid" style="font-family: 'Poppins', sans-serif;   min-height: 100%">
	<div class="row" style="overflow: auto; padding-bottom: 10px;">
		<div class="col-6" style="background-color: black; color: white; height: 60px;">
		<h1 style="font-size : 25px; margin-top: 10px;">CuraHealthyMe</h1>
		</div>
		<div class="col-6" style="background-color: black; color: white; font-size: 25px; ">
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