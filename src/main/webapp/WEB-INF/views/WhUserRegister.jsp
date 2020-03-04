<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUser Register</title>
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
			<H3 class="text-center text-white text-uppercase">WAREHOUSE
			USER REGISTER</H3>
		</div>
		<div class="card-body">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8">
					<form:form action="save" method="post" class="from-group"
				modelAttribute="whUserType">
				<div class="row">
					<div class="col-3">
						<label class="control-label"> USER TYPE</label>
					</div>
					<div class="col-6">
						<form:radiobutton path="whUserType" value="vendor" />
						<label class="control-label">Vendor</label>
						<form:radiobutton path="whUserType" value="customer" />
						<label class="control-label">Customer</label>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">USER CODE:</label>
					</div>
					<div class="col-6">
						<form:input path="whUserCode" class="form-control" />
					</div>
					<div class="col-3"></div>
				</div>

				<div class="row">
					<div class="col-3">
						<label class="control-label">USER FOR</label>
					</div>
					<div class="col-6">
						<form:input path="whUserFor" class="form-control" />
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">USER EMAIL</label>
					</div>
					<div class="col-6">
						<form:input path="whUserEmail" class="form-control" />
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">USER CONTACT</label>
					</div>
					<div class="col-6">
						<form:input path="whUserCont" class="form-control" />
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label"> USER ID TYPE</label>
					</div>
					<div class="col-6">
						<form:select path="whUserIdType" class="form-control">
							<form:option value="" disabled="true" selected="true"
								hidden="true">--choose--</form:option>
							<form:option value="PANCARD">PANCARD</form:option>
							<form:option value="AADHAR CARD">AADHAR CARD</form:option>
							<form:option value="VOTER ID">VOTER ID</form:option>
							<form:option value="Other">Other</form:option>
						</form:select>
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">IF OTHER TYPE</label>
					</div>
					<div class="col-6">
						<form:input path="whUserIdOther" class="form-control" />
					</div>
					<div class="col-3"></div>
				</div>
				<div class="row">
					<div class="col-3">
						<label class="control-label">ID NUMBER</label>
					</div>
					<div class="col-6">
						<form:input path="whUserIdNum" class="form-control" />
					</div>
					<div class="col-6"></div>
				</div>
				<br>
				<input type="submit" value="CREATE USER"
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