<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<title>WhUser View</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<h3>WhUser View Page</h3>
	<div class="col-lg-1"></div>
	<div class="col-lg-4">
	<table class="table">
		<tr>
			<th>ID</th><td>${ob.userId}</td>
		</tr>
		<tr>
			<th>TYPE</th><td>${ob.whUserType}</td>
		</tr>
		<tr>
			<th>CODE</th><td>${ob.whUserCode}</td>
		</tr>
		<tr>
			<th>USER FOR</th><td>${ob.whUserFor}</td>
		</tr>
		<tr>
			<th>EMAIL</th><td>${ob.whUserEmail}</td>
		</tr>
		<tr>
			<th>CONTACT</th><td>${ob.whUserCont}</td>
		</tr>
		<tr>
			<th>ID TYPE</th><td>${ob.whUserIdType}</td>
		</tr>
		<tr>
			<th>OTHER ID_TYPE</th><td>${ob.whUserIdOther}</td>
		</tr>
		<tr>
			<th>ID NUMBER</th><td>${ob.whUserIdNum}</td>
		</tr>
	</table>
	<a href="excel?userid=${ob.userId}">EXCEL EXPORT</a>&nbsp;|&nbsp;
	<a href="pdf?userid=${ob.userId}">PDF EXPORT</a>
	</div>
	<div class="col-lg-7"></div>
</body>
</html>