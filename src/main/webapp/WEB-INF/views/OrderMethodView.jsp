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
<title>Order View</title>
</head>
<body>
	<h3>Order View Page</h3>
	<div class="col-lg-1"></div>
	<div class="col-lg-4">
	<table class="table">
		<tr>
			<th>ID</th><td>${ob.orderId}</td>
		</tr>
		<tr>
			<th>MODE</th><td>${ob.orderMode}</td>
		</tr>
		<tr>
			<th>CODE</th><td>${ob.orderCode}</td>
		</tr>
		<tr>
			<th>TYPE</th><td>${ob.orderType}</td>
		</tr>
		<tr>
			<th>ACCEPT TYPE</th><td>${ob.orderAcpt }</td>
		</tr>
		<tr>
			<th>DECRIPTION</th><td>${ob.decription}</td>
		</tr>
	</table>
	<a href="excel?oid=${ob.orderId}">EXCEL EXPORT</a>&nbsp;|&nbsp;
	<a href="pdf?oid=${ob.orderId}">PDF EXPORT</a>
	</div>
	<div class="col-lg-7"></div>
</body>
</html>