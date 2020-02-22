<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>ShipmentType Edit Page</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<h3 class="text-success text-center">Shipment Update Page</h3>
<div class="container">
	<div class="row">
		<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<form:form action="update" method="post" modelAttribute="shipmentType" class="form-group">
				<div class="row">
					<div class="col-lg-6">
						<label>Shipment ID:</label>
						<form:input path="shipId" calss="form-control" readonly="true"/>
					</div>
				</div>
				<div class="row">
	 				<div class="col-lg-6">
	 				<label>Shipment Mode:</label>
					<form:select path="shipMode" class="form-control">
						<form:option value="" disabled="true" selected="true" hidden="true">--Select Type---</form:option>
						<form:option value="Air">Air</form:option>
						<form:option value="Truck">Truck</form:option>
						<form:option value="Ship">Ship</form:option>
						<form:option value="Train">Trian</form:option>
					</form:select>
				 	</div>
				</div>
			<div class="row">
			  <div class="col-sm-9">
				<label>Shipment Code:</label>
				<form:input path="shipCode" class="form-control"/>
			  </div>
			</div>
			<div class="row">
				<div class="col-lg-6">
					<label>Enable Shipment:</label>
					<form:select path="enbShip" class="form-control">
						<form:option value="" disabled="true" selected="true" hidden="true">--Select--</form:option>
						<form:option value="YES">YES</form:option>
						<form:option value="NO">NO</form:option>
					</form:select>
				</div>
			</div>
			<div class="row">
				<div calss="col-sm-9">
					<label>Shipment Grade:</label>
					<form:radiobutton path="shipGrad" value="A" class="input-lg"/><label>A</label>	 
					<form:radiobutton path="shipGrad" value="B" class="input-lg"/><label>B</label>	 
					<form:radiobutton path="shipGrad" value="C" class="input-lg"/><label>C</label>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-lg-6">
					<label>Description:</label>
					<form:textarea path="shipDesc" class="form-control"/>
				</div>
			</div>
			<br>
		<input type="submit" value="UPDATE SHIPMENT" class="btn btn-primary btn-lg"/>	 
	</form:form>
	</div>
	<div class="col-lg-3"></div>
	</div>
</div>
</body>
</html>