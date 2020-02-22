<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Order Method Register</title>
</head>
<body>
	<h3 class="text-success text-center">Order Method Registration</h3>
	<div class="container">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-6">
			 <form:form action="update" method="POST" modelAttribute="orderMethod">
				<div class="row">
					<div class="col-lg-6">
					<label>Order Id</label>
					<form:input path="orderId" class="form-control"/>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
					   <label>Order Mode</label>
						<form:radiobutton path="orderMode" value="Sale" class="input-lg"/>Sale
						<form:radiobutton path="orderMode" value="Purchase" class="input-lg"/>Purchase
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
					     <label>Order Code</label>
						<form:input path="orderCode" class="form-control"/>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
					     <label>Order Type</label>
						<form:select path="orderType" class="form-control">
							<form:option value="" disabled="true" selected="true" hidden="true">
															--Select Type--</form:option>
							<form:option value="FIFO">FIFO</form:option>
							<form:option value="LIFO">LIFO</form:option>
							<form:option value="FCFO">FCFO</form:option>
							<form:option value="FEFO">FEFO</form:option>
						</form:select>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-9">
					  <label>Order Accept</label>
					  <form:checkbox path="orderAcpt" value="Multi-Model"/>Multi-Model
					  <form:checkbox path="orderAcpt" value="Accept Return"/>Accept Return
					</div>
				</div>			
				<div class="row">
				 <div class="col-lg-6">
					<label>Description</label>
					<form:textarea path="decription" class="form-control"/>
				</div>
			</div>
			<br>
			<input type="submit" value="UPDATE ORDER METHOD" class="btn btn-primary">
			 </form:form>
			 </div>
			<div class="col-lg-3"></div>
		</div>
	</div>
	${msg}
</body>
</html>