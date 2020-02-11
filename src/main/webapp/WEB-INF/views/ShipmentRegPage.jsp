<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Shipment Register</h3>
	<form action="save" method="post">
	 <pre>
	Shipment Mode:<select name="shipMode">
			<option>--Select Type---</option>
			<option>Air</option>
			<option>Truck</option>
			<option>Ship</option>
			<option>Trian</option>
	</select>
	
	Shipment Code:<input type="text" name="shipCode">
	
	Enable Shipment:<select name="enbShip">
			<option>--Select--</option>
			<option>YES</option>
			<option>NO</option>
	</select>
	
	Shipment Grade:
			<input type="radio" name="shipGrad" value="A">A	 
			<input type="radio" name="shipGrad" value="B">B	 
			<input type="radio" name="shipGrad" value="C">C
			
	Description:
		<textarea name="shipDesc"></textarea>
	
	<input type="submit" value="REGISTER SHIPMENT">	 
	 </pre>
	</form>
	${msg}
</body>
</html>