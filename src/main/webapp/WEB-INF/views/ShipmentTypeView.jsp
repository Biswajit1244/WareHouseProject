<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Shipment View Page</title>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
	<h3>Shipment View Page</h3>
	<div class="col-lg-1"></div>
	<div class="col-lg-4">
	<table class="table">
		<tr>
			<th>ID</th><td>${ob.shipId}</td>
		</tr>
		<tr>
			<th>MODE</th><td>${ob.shipMode}</td>
		</tr>
		<tr>
			<th>CODE</th><td>${ob.shipCode}</td>
		</tr>
		<tr>
			<th>ENABLE</th><td>${ob.enbShip }</td>
		</tr>
		<tr>
			<th>GRADE</th><td>${ob.shipGrad }</td>
		</tr>
		<tr>
			<th>DECRIPTION</th><td>${ob.shipDesc }</td>
		</tr>
	</table>
	<a href="excel?sid=${ob.shipId}">EXCEL EXPORT</a>&nbsp;|&nbsp;
	<a href="pdf?sid=${ob.shipId}">PDF EXPORT</a>
	</div>
	<div class="col-lg-7"></div>
</body>
</html>