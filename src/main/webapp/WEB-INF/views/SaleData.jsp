<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale Data</title>
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
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h2 class="text-warning bg-info text-center">Sale Data
		Page</h2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<div class="row">
						<table class="table table-dark table-hover">
							<thead><tr>
								<th>CODE</th>							
								<th>REF NUM</th>							
								<th>STOCK MODE</th>							
								<th>STOCK SOURCE</th>							
								<th>STATUS</th>							
								<th>DESCRIPTION</th>
								<th colspan="3">OPERATION</th>							
							</tr></thead>
							<tbody>
								<c:forEach items="${list}" var="ob">
									<tr>
										<td>${ob.saleOrderCode }</td>
										<td>${ob.saleRefNo }</td>
										<td>${ob.saleStkMode }</td>
										<td>${ob.saleStkSource }</td>
										<td>${ob.saleDfltSts }</td>
										<td>${ob.saleDes }</td>
										<td colspan="3">
											<a href="delete?sid=${ob.saleId}"><button
												class="btn btn-danger">DELETE</button></a> <a
										href="edit?sid=${ob.saleId}"><button
												class="btn btn-success">EDIT</button></a> <a
										href="view?sid=${ob.saleId}"><button class="btn btn-info">VIEW</button></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="row">
						<a href="excel" class="btn btn-secondary">Export Excel</a>&nbsp;&nbsp; <a href="pdf" class="btn btn-secondary">Export
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