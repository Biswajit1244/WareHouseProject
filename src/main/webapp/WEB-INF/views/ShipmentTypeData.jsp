<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
th, td {
	padding: 15px;
	text-align: center;
}

th {
	background-color: #a70907;
	color: white;
	font-size: 12pt;
}

</style>
<title>Shipment Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<H2 class="text-warning bg-info text-center">SHIPMENT TYPE DATA PAGE</H2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-7">
				<div class="row">
					<table class="table table-hover table-dark">
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
					<a href="excel">Export Excel</a>&nbsp;|&nbsp; <a href="pdf">Export
						Pdf</a>
				</div>
				<div class="row">
					<span class="text-danger">${msg}</span>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
		</c:when>
		<c:otherwise>
			<h4>Data Not found</h4>
		</c:otherwise>
	</c:choose>

</body>
</html>