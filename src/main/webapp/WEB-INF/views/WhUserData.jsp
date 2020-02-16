<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
				 <th>OPERATION</th>
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
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</c:when>
		<c:otherwise><h3>Data Not Found</h3></c:otherwise>
	</c:choose>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>