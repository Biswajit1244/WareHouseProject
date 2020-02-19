<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment View Page</title>
</head>
<body>
	<h3>Shipment View Page</h3>
	<table>
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
</body>
</html>