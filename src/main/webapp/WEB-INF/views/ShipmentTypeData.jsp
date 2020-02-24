<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style type="text/css">
		th,td
		{
			padding: 15px;
			text-align: center;
		}
		th
		{
			background-color: #a70907;
			color: white;
			font-size: 12pt;
		}
</style>
<title>Shipment Data</title>
</head>
<body>
	<H3 class="text-success bg-info">SHIPMENT TYPE DATA PAGE</H3>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
			<div class="col-lg-2"></div>
			<div class="col-lg-7">
				<div class="row">
					<table class="table table-striped table-hover">
						<thead class="bg-danger">
							<tr>
								<th>ID</th>
								<th>MODE</th>
								<th>CODE</th>
								<th>ENABLE</th>
								<th>GRADE</th>
								<th>DESCRPTION</th>
								<th colspan="3">OPERATION</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.shipId}</td>
									<td>${ob.shipMode}</td>
									<td>${ob.shipCode}</td>
									<td>${ob.enbShip}</td>
									<td>${ob.shipGrad}</td>
									<td>${ob.shipDesc}</td>
									<td colspan="3"><a href="delete?sid=${ob.shipId}"><button
												class="btn btn-danger">DELETE</button></a> <a
										href="edit?sid=${ob.shipId}"><button
												class="btn btn-success">EDIT</button></a> <a
										href="view?sid=${ob.shipId}"><button class="btn btn-info">
												VIEW</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="row">
					<a href="excel">Export Excel</a>&nbsp;|&nbsp;
					<a href="pdf">Export Pdf</a>
				</div>
				<div class="row">
					<span class="text-danger">${msg}</span>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</c:when>
		<c:otherwise>
			<h4>Data Not found</h4>
		</c:otherwise>
	</c:choose>

</body>
</html>