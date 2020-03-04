<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
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
		h2{
			margin-top: 100px;
	}
</style>
<title>Uom Data</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h2 class="text-warning bg-info text-center">UOM DATA</h2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<div class="row">
					<table class="table table-dark table-hover">
						<thead class="bg-danger">
							<tr>
								<th>ID</th>
								<th>TYPE</th>
								<th>MODEL</th>
								<th>DECRIPTION</th>
								<th colspan="3">OPERATION</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.uomId}</td>
									<td>${ob.uomTp}</td>
									<td>${ob.uomModel}</td>
									<td>${ob.uomDesc}</td>
									<td colspan="3"><a href="delete?uid=${ob.uomId}">
											<button class="btn btn-danger">DELETE</button>
									</a> <a href="edit?uid=${ob.uomId}">
											<button class="btn btn-success">EDIT</button>
									</a> <a href="view?uid=${ob.uomId}">
											<button class="btn btn-info">VIEW</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="row">
					<a href="excel">Export Excel</a>&nbsp;|&nbsp;
					<a href="pdf">Export PDF</a>
				</div>
				<div class="row">
					<span class="text-danger">${msg}</span>
				</div>
			</div>
			<div class="col-lg-3"></div>
		</div>
		</c:when>
		<c:otherwise>
			<h3>Data Not Found</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>