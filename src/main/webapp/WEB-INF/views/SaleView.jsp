<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale View</title>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
	<h3 class="text-success">Order View Page</h3>
	<div class="col-lg-1"></div>
	<div class="col-lg-4">
	<table class="table">
		<tr>
			<th>ID</th><td>${ob.}</td>
		</tr>
		<tr>
			<th>ID</th><td>${ob.}</td>
		</tr>
		<tr>
			<th>ID</th><td>${ob.}</td>
		</tr>
		<tr>
			<th>ID</th><td>${ob.}</td>
		</tr>
		<tr>
			<th>ID</th><td>${ob.}</td>
		</tr>
		<tr>
			<th>ID</th><td>${ob.}</td>
		</tr>
		<tr>
			<th>ID</th><td>${ob.}</td>
		</tr>
	</table>
	<a href="excel?sid=${ob.saleId}">EXCEL EXPORT</a>&nbsp;|&nbsp;
	<a href="pdf?sid=${ob.saleId}">PDF EXPORT</a>
	</div>
	<div class="col-lg-7"></div>
</body>
</html>