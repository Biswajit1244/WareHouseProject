<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Part Edit Page</title>

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
			<h3 class="text-center text-white">PART UPDATE PAGE</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-lg-2"></div>
				<div class="col-lg-8">
					<form:form method="post" action="update" modelAttribute="part">
						<div class="row">
							<div class="col-3">
								<label class="control-label">ID</label>
							</div>
							<div class="col-6">
								<form:input path="partId" class="form-control" readonly="true"/>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<label class="control-label">CODE</label>
							</div>
							<div class="col-6">
								<form:input path="partCode" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<label class="control-label">DIMENSION</label>
							</div>
							<div class="col-lg-3">
								<form:input path="partWidth" class="form-control"
									placeholder="Width" />
							</div>
							<div class="col-lg-3">
								<form:input path="partLength" class="form-control"
									placeholder="Length" />
							</div>
							<div class="col-lg-3">
								<form:input path="partHeight" class="form-control"
									placeholder="Height" />
							</div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<label class="control-label">BASE COST</label>
							</div>
							<div class="col-6">
								<form:input path="partBCost" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<label class="control-label">BASE CURRENCY</label>
							</div>
							<div class="col-6">
								<form:select path="partCurrency" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select--</form:option>
									<form:option value="INR">INR</form:option>
									<form:option value="USD">USD</form:option>
									<form:option value="AUS">AUS</form:option>
									<form:option value="ERU">ERU</form:option>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<label class="control-label">UOM</label>
							</div>
							<div class="col-6">
								<<form:select path="uom.uomId" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select--</form:option>
									<form:options items="${uomMap}"/>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<label class="control-label">ORDER METHOD CODE</label>
							</div>
							<div class="col-6">
								sale(only one select)
								<form:select path="omObSale.orderId" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select--</form:option>
									<form:options items="${omSaleMap}"/>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-lg-3"></div>
							<div class="col-6">
								purchase(only one select)
								<form:select path="omObPur.orderId" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--Select--</form:option>
									<form:options items="${omPurMap}"/>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-lg-3">
								<label class="control-label">DESCRIPTION</label>
							</div>
							<div class="col-6">
								<form:textarea path="partDesc" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<br>
						<input type="submit" value="UPDATE" class="btn btn-primary btn-lg">
					</form:form>
				</div>
				<div class="col-lg-2"></div>
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