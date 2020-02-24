<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
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
<title>Uom Data</title>
</head>
<body>
	<h2 class="text-success bg-info">UOM DATA</h2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
			<div class="col-lg-3"></div>
			<div class="col-lg-5">
				<div class="row">
					<table class="table table-striped table-hover">
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
			<div class="col-lg-4"></div>
		</c:when>
		<c:otherwise>
			<h3>Data Not Found</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>