<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Part data Page</title>
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
	<%@include file="UserMenu.jsp" %>
	<H2 class="text-warning bg-info text-center">PART DATA</H2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
		<div class="row">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">
				<div class="row">
					<table class="table table-hover table-dark">
						<thead class="bg-danger">
							<tr>
								<th rowspan="2">ID</th>
								<th rowspan="2">CODE</th>
								<th colspan="3">DIMENSION</th>
								<th rowspan="2">BASE COST</th>
								<th rowspan="2">CURRENCY</th>
								<th rowspan="2">DESCRIPTION</th>
								<th colspan="3" rowspan="2">OPERATION</th>
							</tr>
							<tr>
								<th>WIDTH</th>
								<th>LENGTH</th>
								<th>HEIGHT</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.partId }</td>
									<td>${ob.partCode }</td>
									<td>${ob.partWidth }</td>
									<td>${ob.partLength }</td>
									<td>${ob.partHeight }</td>
									<td>${ob.partBCost}</td>
									<td>${ob.partCurrency }</td>
									<td>${ob.partDesc }</td>
									<td colspan="3"><a href="delete?pid=${ob.partId}">
											<button class="btn btn-danger">DELETE</button>
									</a> <a href="edit?pid=${ob.partId}">
											<button class="btn btn-success">EDIT</button>
									</a> <a href="view?pid=${ob.partId}">
											<button class="btn btn-info">VIEW</button>
									</a></td>
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
		<c:otherwise>
			<h3>Data Not Found</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>