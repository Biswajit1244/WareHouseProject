<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
  <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>WhUser Edit</title>         
	<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<H3 class="txt">WAREHOUSE USER EDIT</H3>
	<div class="form-group">
		<form:form action="update" method="post" class="from-group" modelAttribute="whUserType">
		  USER ID:<form:input path="userId" class="form-control"/>
		  USER TYPE:<form:radiobutton path="whUserType" value="vendor"/>Vendor
		  			<form:radiobutton path="whUserType" value="customer"/>Customer

		  		    
		  USER CODE:<form:input path="whUserCode" class="form-control"/>
		  
		  USER FOR :<form:input path="whUserFor" class="form-control"/>		    
		  
		  USER EMAIL:<form:input path="whUserEmail" class="form-control"/>
		  
		  USER CONTACT:<form:input path="whUserCont" class="form-control"/>
		  
		  USER ID TYPE:<form:select path="whUserIdType" class="form-control">
		  			<form:option value="" disabled="true" selected="true" hidden="true">--choose--</form:option>  
		  			<form:option value="PANCARD">PANCARD</form:option>
		  			<form:option value="AADHAR CARD">AADHAR CARD</form:option>
		  			<form:option value="VOTER ID">VOTER ID</form:option>
		  			<form:option value="Other">Other</form:option>
		  			</form:select>
		  			
		  IF OTHER TYPE:<form:input path="whUserIdOther" class="form-control"/>
		  ID NUMBER:<form:input path="whUserIdNum" class="form-control"/>
		  
		  <input type="submit" value="UPDATE WHUSER" class="from-control" class="btn btn-primary">			
		</form:form>
	</div>
</body>
</html>