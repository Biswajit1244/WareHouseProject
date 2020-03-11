<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h3 class="text-success">Order View Page</h3>
	<div class="row">
		<div class="col-1"></div>
		<div class="col-4">
			<table class="table">
				<tr>
					<th>ID</th>
					<td>${ob.purId}</td>
				</tr>
				<tr>
					<th>CODE</th>
					<td>${ob.purCode}</td>
				</tr>
				<tr>
					<th>REF NUM</th>
					<td>${ob.purRefNum}</td>
				</tr>
				<tr>
					<th>QUALITY CHECK</th>
					<td>${ob.purQtChck}</td>
				</tr>
				<tr>
					<th>DEFAULT STATUS</th>
					<td>${ob.purDfltSts}</td>
				</tr>
				<tr>
					<th>SHIPMENT CODE</th>
					<td>${ob.shipOb.shipCode}</td>
				</tr>
				<tr>
					<th>VENDOR</th>
					<td>${ob.whUserOb.whUserCode}</td>
				</tr>
				<tr>
					<th>DESCRIPTION</th>
					<td>${ob.purDesc}</td>
				</tr>
			</table>
			<a href="excel?pid=${ob.purId}">EXCEL EXPORT</a>&nbsp;|&nbsp; <a
				href="pdf?pid=${ob.purId}">PDF EXPORT</a>
		</div>
		<div class="col-7"></div>
	</div>
</body>
</html>