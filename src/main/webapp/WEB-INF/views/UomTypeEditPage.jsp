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
<title>UomType Edit Page</title>
</head>
<body>
	<h2 class="text-success text-center">UOM EDIT PAGE</h2>
	<div class="container">
	  <div class="col-lg-3"></div>
	  <div class="col-lg-6">
		<form:form action="update" method="post" modelAttribute="uomType" class="form-group">
			<div class="row">
			   <div class="col-lg-6">
			<div class="row">
				<div class="col-lg-6">
					<form:input path="uomId" class="form-control" readonly="true"/>
				</div>
			</div>   
				<label>UOM TYPE:</label>
				<form:select path="uomTp" class="form-control">
					<form:option value="">--select type--</form:option>
					<form:option value="PACKING">PACKING</form:option>
					<form:option value="NO PACKING">NO PACKING</form:option>
					<form:option value="NA">-NA-</form:option>
				</form:select>
			   </div>
			</div>
			<div class="row">
				<div class="col-sm-9">
					<label>UOM MODEL</label>
		 		   <form:input path="uomModel" class="form-control"/>
				</div>
			</div>
		    <div class="row">
		    	<div class="col-xs-4">
		    		<label>DESCRIPTION:</label>
					<form:textarea path="uomDesc" class="form-control"/>
		    	</div>
		    </div><br>
		<input type="submit" value="EDIT UOM" class="btn btn-primary">
		</form:form>	
	  </div>
	  <div class="col-lg-3"></div>
	</div>
</body>
</html>