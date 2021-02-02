<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base">${pageContext.request.requestURL}</c:set>
<c:set var="url"
	value="${fn:replace(base, pageContext.request.requestURI, pageContext.request.contextPath)}" />

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<script src="../resources/js/jQuery-v3.4.1-min.js"></script>
<script src="../resources/js/bootstrap.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">WAHREHOUSE APP</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="#">HOME
					<span class="sr-only">(current)</span>
			</a></li>
			<!-- one option start-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">UOM</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${url}/uom/register">REGISTER</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/uom/all">ALL</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/uom/charts">CHARTS</a>

				</div></li>
			<!-- one option end -->
			<!-- one option start-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> SHIPMENT TYPE </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${url}/shipment/register">REGISTER</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/shipment/all">ALL</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/shipment/charts">CHARTS</a>

				</div></li>
			<!-- one option end -->

			<!-- one option start-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">WHUSER</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${url}/whuser/register">REGISTER</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/whuser/all">ALL</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/whuser/charts">CHARTS</a>

				</div></li>
			<!-- one option end -->

			<!-- one option start-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> ORDER METHOD </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${url}/order/register">REGISTER</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/order/all">ALL</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/order/charts">CHARTS</a>

				</div></li>
			<!-- one option end -->
			<!-- one option start-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">PART</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${url}/part/register">REGISTER</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/part/all">ALL</a>
				</div></li>
			<!-- one option end -->
			<!-- one option start-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">PURCHASE</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${url}/purchase/register">REGISTER</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/purchase/all">ALL</a>
				</div></li>
			<!-- one option end -->
						<!-- one option start-->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">SALE</a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="${url}/sale/register">REGISTER</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="${url}/sale/all">ALL</a>
				</div></li>
			<!-- one option end -->
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>
