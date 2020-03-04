<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="../resources/js/bootstrap.min.js"></script>
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
<title>Order Method Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h2 class="text-warning bg-info text-center">Order Method Data Page</h2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<div class="row">
					<table class="table table-dark table-hover">
						<thead class="bg-danger">
							<tr>
								<th>ID</th>
								<th>MODE</th>
								<th>CODE</th>
								<th>ORDER_TYPE</th>
								<th>ACCEPT_TYPE</th>
								<th>DESCRIPTION</th>
								<th colspan="3">OPERATION</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.orderId}</td>
									<td>${ob.orderMode}</td>
									<td>${ob.orderCode}</td>
									<td>${ob.orderType}</td>
									<td>${ob.orderAcpt}</td>
									<td>${ob.decription}</td>
									<td colspan="3"><a href="delete?oid=${ob.orderId}"><button
												class="btn btn-danger">DELETE</button></a> <a
										href="edit?oid=${ob.orderId}"><button
												class="btn btn-success">EDIT</button></a> <a
										href="view?oid=${ob.orderId}"><button class="btn btn-info">VIEW</button></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="row">
					<a href="excel">Export Excel</a>&nbsp;|&nbsp; <a href="pdf">Export
						PDF</a>
				</div>
				<div class="row">
					<span class="text-danger">${msg}</span>
				</div>
			</div>
			<div class="col-lg-2"></div>
		</div>
		</c:when>
		<c:otherwise>Data Not Found..!!</c:otherwise>
	</c:choose>
</body>
</html>