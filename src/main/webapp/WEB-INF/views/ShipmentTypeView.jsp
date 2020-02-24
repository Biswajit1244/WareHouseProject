<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Shipment View Page</title>
</head>
<body>
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