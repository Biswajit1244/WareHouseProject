<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>UomType Update Page</title>
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
			<h3 class="text-white text-center text-uppercase">UOM UPDATE</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form:form action="update" method="post" modelAttribute="uomType">
						<div class="row">
							<div class="col-3">
								<label class="control-label">UOM ID:</label>
							</div>
							<div class="col-6">
								<form:input path="uomId" class="form-control" readonly="true"/>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">UOM TYPE:</label>
							</div>
							<div class="col-6">
								<form:select path="uomTp" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">--select type--</form:option>
									<form:option value="PACKING">PACKING</form:option>
									<form:option value="NO PACKING">NO PACKING</form:option>
									<form:option value="-NA-">-NA-</form:option>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">UOM MODEL:</label>
							</div>
							<div class="col-6">
								<form:input path="uomModel" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">DESCRIPTION:</label>
							</div>
							<div class="col-6">
								<form:textarea path="uomDesc" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<br>
						<input type="submit" value="UPDATE UOM"
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