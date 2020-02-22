<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>UOM DATA</h2>
	<c:choose>
		<c:when test="${!empty list}">
		<table border="1" >
			<thead>
				<tr>
					<th>ID</th>
					<th>TYPE</th>
					<th>MODEL</th>
					<th>DECRIPTION</th>
					<th colspan="2">OPERATION</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="ob">
				<tr>
					<td>${ob.uomId}</td>
					<td>${ob.uomTp}</td>
					<td>${ob.uomModel}</td>
					<td>${ob.uomDesc}</td>
					<td><a href="delete?uid=${ob.uomId}">
							<button>DELETE</button></a></td>
					<td><a href="edit?uid=${ob.uomId}">
							<button>EDIT</button></a></td>
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