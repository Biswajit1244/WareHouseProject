<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Order Method Register</title>
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
		<div class="card-header" id="head">
			<h3 class="text-white text-center text-uppercase">Order Method
				Registration</h3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form:form action="save" method="POST" modelAttribute="orderMethod">
						<div class="row">
							<div class="col-3">
								<label class="control-label">Order Mode</label>
							</div>
							<div class="col-6">
								<form:radiobutton path="orderMode" value="Sale" class="input-lg" />
								<label class="control-label">Sale</label>
								<form:radiobutton path="orderMode" value="Purchase"
									class="input-lg" />
								<label class="control-label">Purchase</label>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Order Code</label>
							</div>
							<div class="col-6">
								<form:input path="orderCode" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Order Type</label>
							</div>
							<div class="col-6">
								<form:select path="orderType" class="form-control">
									<form:option value="" disabled="true" selected="true"
										hidden="true">
															--Select Type--</form:option>
									<form:option value="FIFO">FIFO</form:option>
									<form:option value="LIFO">LIFO</form:option>
									<form:option value="FCFO">FCFO</form:option>
									<form:option value="FEFO">FEFO</form:option>
								</form:select>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Order Accept</label>
							</div>
							<div class="col-6">
								<form:checkbox path="orderAcpt" value="Multi-Model" />
								<label class="control-label">Multi-Model</label>
								<form:checkbox path="orderAcpt" value="Accept Return" />
								<label class="control-label">Accept Return</label>
							</div>
							<div class="col-3"></div>
						</div>
						<div class="row">
							<div class="col-3">
								<label class="control-label">Description</label>
							</div>
							<div class="col-6">
								<form:textarea path="decription" class="form-control" />
							</div>
							<div class="col-3"></div>
						</div>
						<br>
						<input type="submit" value="CREATE ORDER METHOD"
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