<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns:th="http://www.thymeleaf.org" >
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
				<tiles:insertAttribute name="content"></tiles:insertAttribute>
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