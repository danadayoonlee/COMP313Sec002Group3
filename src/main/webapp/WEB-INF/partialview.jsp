<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
<link href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js" type="text/javasript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Template</title>
<style type="text/css">
li {
	list-style-type: none;
}
</style>
</head>
<body>
<div class="container-fluid" style="min-height:100%;">
	<div class="row" style="min-height:15%;">
		<div class="col-6">
		<h1>CuraHealthyMe</h1>
		</div>
		<div class="col-6 text-right">
		<a href="${pageContext.request.contextPath}/">Home</a> |
		<a href="${pageContext.request.contextPath}/aboutus">About Us</a> |
		<a href="${pageContext.request.contextPath}/contactus">Contact Us</a> |
		<a href="${pageContext.request.contextPath}/news">News</a> |
		<a href="${pageContext.request.contextPath}/login">Login</a>
		</div>
	</div>
	<br />
	<div class="row" style="min-height:70%;">
		<div class="col">
			<tiles:insertAttribute name="content"></tiles:insertAttribute>
		</div>
	</div>
	<br />
	<div class="row" style="min-height:15%;">
		<div class="col text-center">
			<span>Copyright &copy;curahealthyme</span>
		</div>
	</div>
</div>
</body>
</html>