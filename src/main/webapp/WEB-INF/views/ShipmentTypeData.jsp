<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shipment Data</title>
</head>
<body>
	<H3>SHIPMENT TYPE DATA PAGE</H3>
	<c:choose>
	 <c:when test="${!empty list}">
	 	<table border="1">
	 		<thead>
	 			<tr>
	 				<th>ID</th>
	 				<th>MODE</th>
	 				<th>CODE</th>
	 				<th>ENABLE</th>
	 				<th>GRADE</th>
	 				<th>DESCRPTION</th>
	 				<th colspan="3">OPERATION</th>
	 			</tr>
	 		</thead>
	 		<tbody>
	 				<c:forEach items="${list}" var="ob">
	 				<tr>
	 					<td>${ob.shipId}</td>
	 					<td>${ob.shipMode}</td>
	 					<td>${ob.shipCode}</td>
	 					<td>${ob.enbShip}</td>
	 					<td>${ob.shipGrad}</td>
	 					<td>${ob.shipDesc}</td>
	 					<td><a href="delete?sid=${ob.shipId}"><button>DELETE
	 							</button></a></td>
	 					<td><a href="edit?sid=${ob.shipId}"><button>EDIT</button></a></td>
	 					<td><a href="view?sid=${ob.shipId}"><button>VIEW</button></a></td>
	 				</tr>
	 				</c:forEach>		
	 		</tbody>
	 	</table>
	 	${msg}
	 </c:when>
		<c:otherwise>
			<h4>Data Not found</h4>
		</c:otherwise>
	</c:choose>

</body>
</html>