<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../resources/css/bootstrap.min.css">         
<script src="../resources/js/bootstrap.min.js"></script>
<title>Part View</title>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
	<h3 class="text-success">Page View Page</h3>
	<div class="row">
		<div class="col-4">
		<table class="table">
		<tr>
			<th>ID</th><td>${ob.partId}</td>
		</tr>
		<tr>
			<th>CODE</th><td>${ob.partCode}</td>
		</tr>
		<tr>
			<th>WIDTH</th><td>${ob.partWidth}</td>
		</tr>
		<tr>
			<th>LENGTH</th><td>${ob.partLength}</td>
		</tr>
		<tr>
			<th>HEIGHT</th><td>${ob.partHeight}</td>
		</tr>
		<tr>
			<th>BASE COST</th><td>${ob.partBCost }</td>
		</tr>
		<tr>
			<th>CURRENCY</th><td>${ob.partCurrency }</td>
		</tr>
		<tr>
			<th>DECRIPTION</th><td>${ob.partDesc}</td>
		</tr>
	</table>
		</div>
	</div>
	<a href="excel?pid=${ob.partId}">EXCEL EXPORT</a>&nbsp;|&nbsp;
	<a href="pdf?pid=${ob.partId}">PDF EXPORT</a>
</body>
</html>