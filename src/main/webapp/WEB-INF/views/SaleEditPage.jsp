<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale Update Page</title>
<style type="text/css">
.btn-lg {
	margin-left: 200px;
}

.card-body {
	background-color: #adb9cc;
}

#head, h3 {
	background-color: #a70907;
}

.form-control {
	margin-top: 20px;
	border: 5px;
	border-radius: 10px;
	border-bottom: 2px solid gray;
	font-size: 15px;
	color: green;
}

.control-label {
	font-size: 15px;
	margin-top: 20px;
	font-weight: bold;
}
</style>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="container">
			<div class="card-header" id="head">
				<h3 class="text-white text-center text-uppercase">Sale
					Registration</h3>
			</div>
			<div class="card-body">
				<div class="row">
					<div class="col-2"></div>
					<div class="col-8">
						<form:form action="updateabel" method="POST" modelAttribute="sale">
							<div class="row">
								<div class="col-3">
									<label class="control-label">ID</label>
								</div>
								<div class="col-6">
									<form:input path="saleId" class="form-control" readonly="true"/>
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">ORDER CODE</label>
								</div>
								<div class="col-6">
									<form:input path="saleOrderCode" class="form-control" />
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">Shipment Code</label>
								</div>
								<div class="col-6">
									<form:select path="" class="form-control">
										<form:option value="" disabled="true" selected="true"
											hidden="true">--Select--</form:option>
									</form:select>
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">Customer</label>
								</div>
								<div class="col-6">
									<form:select path="" class="form-control">
										<form:option value="" disabled="true" selected="true"
											hidden="true">--Select--</form:option>
									</form:select>
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">Ref Number</label>
								</div>
								<div class="col-6">
									<form:input path="saleRefNo" class="form-control" />
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">Stock Mode</label>
								</div>
								<div class="col-6">
									<form:radiobutton path="saleStkMode" value="Grade" />
									<label class="control-label">Grade</label>
									<form:radiobutton path="saleStkMode" value="Margin" />
									<label class="control-label">Margin</label>
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">Stock Source</label>
								</div>
								<div class="col-6">
									<form:select path="saleStkSource" class="form-control">
										<form:option value="" disabled="true" selected="true"
											hidden="true">--Select Type--</form:option>
										<form:option value="OPEN">OPEN</form:option>
										<form:option value="AVAIL">AVAIL</form:option>
										<form:option value="REFUND">REFUND</form:option>
									</form:select>
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">Default Status</label>
								</div>
								<div class="col-6">
									<form:input path="saleDfltSts" class="form-control"
										value="SALE-OPEN" readonly="true" />
								</div>
								<div class="col-3"></div>
							</div>
							<div class="row">
								<div class="col-3">
									<label class="control-label">Description</label>
								</div>
								<div class="col-6">
									<form:textarea path="saleDes" class="form-control" />
								</div>
								<div class="col-3"></div>
							</div>
							<br>
							<input type="submit" value="UPDATE SALE ORDER"
								class="btn btn-primary btn-lg">
						</form:form>
					</div>
					<div class="col-2"></div>
				</div>
			</div>
			<c:if test="${!empty msg }">
				<div class="card-footer bg-info text-white text-center">
					<b>${msg}</b>
				</div>
			</c:if>
		</div>

	</div>
</body>
</html>