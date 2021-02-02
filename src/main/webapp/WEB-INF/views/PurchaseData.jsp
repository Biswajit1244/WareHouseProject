<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h2 class="text-warning bg-info text-center">Order Method Data
		Page</h2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
			<div class="row">
				<div class="col-1"></div>
				<div class="col-10">
					<div class="row">
						<table class="table table-dark table-hover">
							<thead class="bg-danger">
								<tr>
									<th>ID</th>
									<th>CODE</th>
									<th>REF NUM</th>
									<th>QUALITY CHECK</th>
									<th>DEFAULT STATUS</th>
									<th>SHIPMENT CODE</th>
									<th>VENDOR</th>
									<th>DESCRIPTION</th>
									<th colspan="3">OPERATION</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="ob">
									<tr>
										<td>${ob.purId }</td>
										<td>${ob.purCode }</td>
										<td>${ob.purRefNum }</td>
										<td>${ob.purQtChck }</td>
										<td>${ob.purDfltSts }</td>
										<td>${ob.shipOb.shipCode}</td>
										<td>${ob.whUserOb.whUserCode}</td>
										<td>${ob.purDesc }</td>
										<td><a href="parts?pid=${ob.purId }"><button
													class="btn btn-warning">ADD PARTS</button></a>
										<td><c:choose>
												<c:when test="${'ORDERED' eq ob.purDfltSts}">
													<a href="invoceOrder?poId=${ob.purId}" class="btn btn-success">GENERATE
														INVOICE</a>
												</c:when>
												<c:when test="${'INVOICED' eq ob.purDfltSts}">
													<a href="downloadInvoce?poId=${ob.purId}" class="btn btn-info">DOWNLOAD
														INVOICE</a>
												</c:when>
												<c:when test="${'RECEVIED' eq ob.purDfltSts}">
													<b class="text-success">ORDER IS USED IN GRN</b>
												</c:when>
												<c:otherwise>
													ORDER MUST BE PLACED
												</c:otherwise>
											</c:choose></td>
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
				<div class="col-1"></div>
			</div>
		</c:when>
		<c:otherwise>Data Not Found..!!</c:otherwise>
	</c:choose>
</body>
</html>