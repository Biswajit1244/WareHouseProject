<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>UOM REGISTER</h2>
	<form action="save" method="post">
	<pre>
		UOM TYPE:<select name="uomType">
			<option>--select type--</option>
			<option>PACKING</option>
			<option>NO PACKING</option>
			<option>-NA-</option>
		</select>
		
		UOM MODEL:<input type="text" name="uomModel">
		
		DESCRIPTION:<textarea name="uomDesc"></textarea>
		<input type="submit" value="CREATE UOM">
  	</pre>
	</form>	
	${msg}
</body>
</html>