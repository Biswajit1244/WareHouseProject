<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp" %>
	<h3>UPLOAD FILE HERE</h3>
	<form action="upload" method="POST" enctype="multipart/form-data">
	<pre>
		ID:<input type="text" name="fileNo">
		DOC:<input type="file" name="fileData">
		<input type="submit" value="UPLOAD">
	</pre>
	</form>
	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>FILE NAME</th>
				<th>LINK</th>
			</tr>
		</thead>
		<c:forEach items="${list}" var="ob">
			<tr>
				<td>${ob[0]}</td>
				<td>${ob[1]}</td>
				<td><a href="download?fid=${ob[0]}">Download</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>