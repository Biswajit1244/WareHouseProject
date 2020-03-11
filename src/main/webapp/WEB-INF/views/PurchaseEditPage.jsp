<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase Edit Page</title>
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
		<div class="card-header" id="head">
			<h3 class="text-center text-white text-uppercase">Purchase
				Register</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form:form method="post" action="update" modelAttribute="purchase">
						<div class="row">
							<div class="col-3">
								<label class="form-control">ID</label>
							</div>
							<div class="col-6">
								<form:input path="purId" class="form-control" readonly="true"/>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Order Code</label>
							</div>
							<div class="col-6">
								<form:input path="purCode" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
							<div class="row">
							<div class="col-3">
								<label class="control-label">Shipment Code</label>
							</div>
							<div class="col-6">
								<form:select path="shipOb.shipId" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select Type--</form:option>
									<form:options items="${shipMap}"/>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Vendor</label>
							</div>
							<div class="col-6">
								<form:select path="whUserOb.userId" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select Type--</form:option>
									<form:options items="${whUserMap}"/>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Reference Num</label>
							</div>
							<div class="col-6">
								<form:input path="purRefNum" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Quality Check</label>
							</div>
							<div class="col-6">
								<form:radiobutton path="purQtChck" value="Required" />
								<label class="control-label">Required</label>
								<form:radiobutton path="purQtChck" value="Not Required" />
								<label class="control-label">Not Required</label>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Default Status</label>
							</div>
							<div class="col-6">
								<form:input path="purDfltSts" value="OPEN" readonly="true"
									class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Description</label>
							</div>
							<div class="col-6">
								<form:textarea path="purDesc" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<br>
						<input type="submit" value="UPDATE ORDER"
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
</body>
</html>