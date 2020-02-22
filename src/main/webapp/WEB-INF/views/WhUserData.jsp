<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>WhUser data Page</title>
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<H3>WAREHOUSE USER</H3>
	<c:choose>
		<c:when test="${!empty list}">
			<table class="table table-bordered">
			
			<thead class="bg-success">
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
				 <th colspan="2">OPERATION</th>
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
					<td><a href="delete?userid=${ob.userId}">
							<button class="btn btn-danger">DELETE</button></a></td>
					<td><a href="edit?userid=${ob.userId}">
							<button class="btn btn-info">EDIT</button></a></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
			<a href="excel">EXCEL EXPORT</a>
		</c:when>
		<c:otherwise><h3>Data Not Found</h3></c:otherwise>
	</c:choose>
</body>
</html>