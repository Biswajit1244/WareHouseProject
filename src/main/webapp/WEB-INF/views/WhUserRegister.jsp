<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>         
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<H3 class="txt">WAREHOUSE USER REGISTER</H3>
	<div class="form-group">
	<fieldset>
		<legend><b>WareHouse User</b></legend>
		<form action="save" method="post" class="from-group">
		  USER TYPE:<input type="radio" name="whUserType" value="vendor">Vendor
		  		    <input type="radio" name="whUserType" value="customer">Customer
		  		    
		  USER CODE:<input type="text" name="whUserCode" class="form-control">
		  
		  USER FOR :<input type="text" name="whUserFor" class="form-control">		    
		  
		  USER EMAIL:<input type="email" name="whUserEmail" class="form-control">
		  
		  USER CONTACT:<input type="tel" name="whUserCont" class="form-control">
		  
		  USER ID TYPE:<select name="whUserIdType" class="form-control">
		  			<option>--choose--</option>  
		  			<option>PANCARD</option>
		  			<option>AADHAR CARD</option>
		  			<option>VOTER ID</option>
		  			<option>Other</option>
		  			</select>
		  			
		  IF OTHER TYPE:<input type="text" name="whUserIdOther" class="form-control">
		  ID NUMBER:<input type="text" name="whUserIdNum" class="form-control">
		  
		  <input type="submit" value="CREATE USER" class="from-control">			
		</form>
	</fieldset>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>