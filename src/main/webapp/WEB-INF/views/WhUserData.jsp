<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>WhUser data Page</title>
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
	<H2 class="text-warning bg-info text-center">WAREHOUSE USER DATA</H2>
	<br>
	<c:choose>
		<c:when test="${!empty list}">
			<div class="row">
				<div class="col-1"></div>
				<div class="col-10">
					<table class="table table-hover table-dark">
						<thead class="bg-danger">
							<tr>
								<th>ID</th>
								<th>TYPE</th>
								<th>CODE</th>
								<th>USER FOR</th>
								<th>EMAIL</th>
								<th>CONTACT</th>
								<th>ID TYPE</th>
								<th>OTHER ID_Type</th>
								<th>ID NUMBER</th>
								<th colspan="3">OPERATION</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="ob">
								<tr>
									<td>${ob.userId}</td>
									<td>${ob.whUserType }</td>
									<td>${ob.whUserCode }</td>
									<td>${ob.whUserFor }</td>
									<td>${ob.whUserEmail }</td>
									<td>${ob.whUserCont }</td>
									<td>${ob.whUserIdType }</td>
									<td>${ob.whUserIdOther }</td>
									<td>${ob.whUserIdNum }</td>
									<td colspan="3"><a href="delete?userid=${ob.userId}">
											<button class="btn btn-danger">DELETE</button>
									</a> <a href="edit?userid=${ob.userId}">
											<button class="btn btn-success">EDIT</button>
									</a> <a href="view?userid=${ob.userId}">
											<button class="btn btn-info">VIEW</button>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
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
		<c:otherwise>
			<h3>Data Not Found</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>