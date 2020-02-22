<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Order Method Data</title>
</head>
<body>
	<h2 class="text-success bg-info">Order Method Data Page:-</h2><br>
	<c:choose>
		<c:when test="${!empty list}">
			<div class="col-lg-1"></div>
			<div class="col-lg-8">
			  <div class="row">
			     <table class="table table-striped table-hover">
				   <thead class="bg-danger">
					 <tr>
						<th>ID</th>
						<th>MODE</th>
						<th>CODE</th>
						<th>ORDER_TYPE</th>
						<th>ACCEPT_TYPE</th>
						<th>DESCRIPTION</th>
						<th colspan="3">OPERATION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="ob">
					 <tr>
					 	<td>${ob.orderId}</td>
					 	<td>${ob.orderMode}</td>
					 	<td>${ob.orderCode}</td>
					 	<td>${ob.orderType}</td>
					 	<td>${ob.orderAcpt}</td>
					 	<td>${ob.decription}</td>
					 	<td colspan="3"><a href="delete?oid=${ob.orderId}"><button class="btn btn-danger">DELETE
	 							</button></a>
	 						<a href="edit?oid=${ob.orderId}"><button class="btn btn-success">EDIT</button></a>
	 						<a href="view?oid=${ob.orderId}"><button class="btn btn-info">VIEW</button></a></td>
					 </tr>	
					</c:forEach>
				</tbody>
			   </table>
			  </div>	
			  <div class="row">
			  	<a href="excel">Export Excel</a>
		      </div>
		      <div class="row">
			   <span class="text-danger text-center">${msg}</span>
		      </div>
			</div>
			<div class="col-lg-3"></div>
		</c:when>
		<c:otherwise>Data Not Found..!!</c:otherwise>
	</c:choose>
</body>
</html>