<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUser Register</title>         
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style type="text/css">
  	*{
  		margin: 0px;
  		padding: 0px;
  	}
  	.control-label{
  		font-size: 15px;
  		margin-top: 20px;
  		font-weight: normal;
  	}
  	.form-control{
  		
  		margin-top:20px;
  		border: 5px;
  		border-radius: 10px;
  		border-bottom: 2px solid gray;
  		font-size: 15px;
  		color: green;
  	}
  	.col-lg-6{
  		background: rgba(0,0,0,0.4);
  		height: 550px;
  		box-shadow: -1px 1px 60px 10px black inset;
  	}
  </style>
</head>
<body>
<div class="container">
	<H3 class="txt text-center">WAREHOUSE USER REGISTER</H3>
	  <div class="col-lg-3"></div>
	  <div class="col-lg-6">
		<form:form action="save" method="post" class="from-group" modelAttribute="whUserType">
				<div class="row">
					<div class="col-lg-3">
						<label class="control-label"> USER TYPE</label>
					</div>
					<div class="col-lg-7">
						<form:radiobutton path="whUserType" value="vendor" />
						Vendor
						<form:radiobutton path="whUserType" value="customer" />
						Customer
					</div>
				</div>
			<div class="row">
					<div class="col-lg-3">
						<label class="control-label">USER CODE:</label>
					</div>
					<div class="col-lg-7">
						<form:input path="whUserCode" class="form-control"/>
					</div>
				</div>
		  		    
		  <div class="row">
					<div class="col-lg-3">
						<label class="control-label">USER FOR</label>
					</div>
					<div class="col-lg-7">
						<form:input path="whUserFor" class="form-control"/>
					</div>
				</div>
		  <div class="row">
					<div class="col-lg-3">
						<label class="control-label">USER EMAIL</label>
					</div>
					<div class="col-lg-7">
						<form:input path="whUserEmail" class="form-control"/>
					</div>
				</div>
		  <div class="row">
					<div class="col-lg-3">
						<label class="control-label">USER CONTACT</label>
					</div>
					<div class="col-lg-7">
						<form:input path="whUserCont" class="form-control"/>
					</div>
				</div>
		  <div class="row">
					<div class="col-lg-3">
						<label class="control-label"> USER ID TYPE</label>
					</div>
					<div class="col-lg-5">
						<form:select path="whUserIdType" class="form-control">
		  			<form:option value="" disabled="true" selected="true" hidden="true">--choose--</form:option>  
		  			<form:option value="PANCARD">PANCARD</form:option>
		  			<form:option value="AADHAR CARD">AADHAR CARD</form:option>
		  			<form:option value="VOTER ID">VOTER ID</form:option>
		  			<form:option value="Other">Other</form:option>
		  			</form:select>
					</div>
				</div>
		 <div class="row">
					<div class="col-lg-3">
						<label class="control-label">IF OTHER TYPE</label>
					</div>
					<div class="col-lg-7">
						<form:input path="whUserIdOther" class="form-control"/>
					</div>
				</div>
		 <div class="row">
					<div class="col-lg-3">
						<label class="control-label">ID NUMBER</label>
					</div>
					<div class="col-lg-7">
						<form:input path="whUserIdNum" class="form-control"/>
					</div>
				</div>
		  <input type="submit" value="CREATE USER" class="btn btn-primary">			
		</form:form>
	  </div>
	  <div class="col-lg-3"></div>
</div>
</body>
</html>