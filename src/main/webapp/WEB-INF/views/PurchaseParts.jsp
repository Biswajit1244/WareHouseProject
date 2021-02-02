<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="UserMenu.jsp"%>
	<div class="container">
		<div class="card">
			<div class="card-header bg-info">
				<h3 class="text-warning bg-info text-center">WELCOME TO
					PURCHASE ORDER PARTS</h3>
			</div>
			<div class="card-body">
				<table class="table">
					<tr>
						<td>ORDER CODE</td>
						<td class="text-success"><b>${parent.purCode}</b></td>

						<td>ORDER STATUS</td>
						<td class="text-success"><b>${parent.purDfltSts}</b></td>
					</tr>
				</table>
				<hr />
				<c:if
					test="${'OPEN' eq parent.purDfltSts || 'PICKING' eq parent.purDfltSts}">
					<form:form action="addPart" method="post"
						modelAttribute="purchaseDtls" class="form-group">
						<div class="row">
							<div class="col-2">
								<label>SELECT PART:</label>
							</div>
							<div class="col-4">
								<form:select path="part.partId" class="form-control">
									<form:options items="${partMap}" />
								</form:select>
							</div>
							<div class="col-6"></div>
						</div>
						<div class="row">
							<div class="col-2">
								<label>Qty:</label>
							</div>
							<div class="col-4">
								<form:input path="qty" class="form-control" />
							</div>
							<div class="col-6"></div>
						</div>
						<input type="hidden" name="pur.purId" value="${parent.purId}">
						<input type="submit" value="Add Part" class="btn btn-success" />
					</form:form>
				</c:if>

				<table class="table table-bordered">
					<tr>
						<th>SlNo</th>
						<th>PART</th>
						<th>BASE COST</th>
						<th>QTY</th>
						<c:if test="${'PICKING' eq parent.purDfltSts }">
							<th>OPERATION</th>
						</c:if>
					</tr>
					<c:forEach items="${childs}" var="dtl">
						<tr>
							<td>${dtl.slNo}</td>
							<td>${dtl.part.partCode}</td>
							<td>${dtl.part.partBCost}</td>
							<td>${dtl.qty}</td>
							<c:if test="${'PICKING' eq parent.purDfltSts }">
								<td><a
									href="removePart?dtlId=${dtl.purDtlsId}&poId=${parent.purId}"
									class="btn btn-danger"> DELETE</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<div class="row">
					<div class="col-4"></div>
					<div class="col-4">
						<c:if test="${'PICKING' eq parent.purDfltSts }">
							<a href="placeOrder?poId=${parent.purId}" class="btn btn-success">CONFORM</a>
						</c:if>
					</div>
					<div class="col-4"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>