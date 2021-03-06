<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>ShipmentType Register</title>
<style type="text/css">
	.btn-lg{
		margin-left: 200px;
	}
	.card-body{
		background-color:#adb9cc;
	}
	#head,h3{
		background-color: #a70907;
	}
	.form-control{
		margin-top:20px;
  		border: 5px;
  		border-radius: 10px;
  		border-bottom: 2px solid gray;
  		font-size: 15px;
  		color: green;
	}
	.control-label{
		font-size: 15px;
  		margin-top: 20px;
  		font-weight: bold;
	}
</style>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header" id="head">
				<h3 class="text-white text-center text-uppercase">Shipment
					Register</h3>
			</div>
			<div class="card-body">
				<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<form:form action="save" method="post"
						modelAttribute="shipmentType" class="form-group">
						<div class="row">
							<div class="col-3">
								<label class="control-label">Shipment Mode:</label>
							</div>
							<div class="col-6">
								<form:select path="shipMode" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select Type---</form:option>
									<form:option value="Air">Air</form:option>
									<form:option value="Truck">Truck</form:option>
									<form:option value="Ship">Ship</form:option>
									<form:option value="Train">Train</form:option>
								</form:select>
							</div>
							<div class="col-3"><!-- ERROR MSG --></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Shipment Code:</label>
							</div>
							<div class="col-6">
								<form:input path="shipCode" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Enable Shipment:</label>
							</div>
							<div class="col-6">
								<form:select path="enbShip" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select--</form:option>
									<form:option value="Yes">YES</form:option>
									<form:option value="No">NO</form:option>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
							 <label class="control-label">Shipment Grade:</label>
							</div>
							<div class="col-6">
								<div class="row">
								  	<div class="col-4">
								 		<form:radiobutton
										path="shipGrad" value="A" class="input-lg" />&nbsp;&nbsp;<label class="control-label">A</label>
								  	</div>							
									<div class="col-4">
									     <form:radiobutton path="shipGrad" value="B" class="input-lg" />&nbsp;&nbsp;<label class="control-label">B</label>
									</div>							
									<div class="col-4">
										<form:radiobutton path="shipGrad" value="C" class="input-lg" />&nbsp;&nbsp;<label class="control-label">C</label>
									</div>							
							  </div>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Description:</label>
							</div>
							<div class="col-6">
								<form:textarea path="shipDesc" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<br>
						<input type="submit" value="REGISTER SHIPMENT"
							class="btn btn-primary btn-lg" />
					</form:form>
				</div>
				<div class="col-lg-2"></div>
			</div>
			</div>
			<c:if test="${!empty msg }">
				<div class="card-footer bg-info text-white text-center"><b>${msg}</b></div>
			</c:if>

		</div>
	</div>
</body>
</html>