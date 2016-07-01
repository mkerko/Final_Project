<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:setBundle basename="localize" var="loc"/>
	<fmt:message bundle="${loc}" key="local.button.logout" var="logout"/>
	<fmt:message bundle="${loc}" key="local.title.cabinet" var="title"/>
	<fmt:message bundle="${loc}" key="local.nav.allreservations" var="allReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.cabinet" var="cabinet"/>
	<fmt:message bundle="${loc}" key="local.nav.myreservations" var="myReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.users" var="users"/>
	<fmt:message bundle="${loc}" key="local.nav.users" var="users"/>
	<fmt:message bundle="${loc}" key="local.cab.add" var="add"/>
	<fmt:message bundle="${loc}" key="local.cab.cabinet" var="cabinet"/>
	<fmt:message bundle="${loc}" key="local.cab.showCash" var="showCash"/>
	<fmt:message bundle="${loc}" key="local.footer.siteMap" var="siteMap"/>
	<fmt:message bundle="${loc}" key="local.footer.payment" var="payment"/>
	<fmt:message bundle="${loc}" key="local.book" var="book"/>
	<fmt:message bundle="${loc}" key="local.ru" var="ru"/>
	<fmt:message bundle="${loc}" key="local.en" var="en"/>
	<fmt:message bundle="${loc}" key="local.error.message" var="message"/>
	<title>${title}</title>
	<link rel="icon" href="https://www.dorchestercollection.com/wp-content/themes/dt-the7/images/favicon.ico">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Motel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
	<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<!-- Custom Theme files -->
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<script src="js/jquery-1.11.1.min.js"></script>
	<!--webfonts-->
	<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
	<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,600' rel='stylesheet' type='text/css'>
	<!--//webfonts-->
	<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<!-- banner -->
<div class="banner1">
	<div class="header">
		<div class="container">
			<div class="logo">
				<h1><a href="/index.jsp">Hotel EDEN</a></h1>
			</div>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<!--/.navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="Offers">${myReservations}</a></li>
						<c:if test="${sessionScope.role == 'admin'}">
							<li><a href="AllOffers">${allReservations}</a></li>
							<li><a href="Users">${users}</a></li>
						</c:if>
						<%--<li><a href="ShortCodes">Short Codes</a></li>--%>
						<li><a href="Cabinet">${cabinet}</a></li>
						<li>
							<div class="booking-form2">
								<form action="Controller" method="post">
									<input type="hidden" name="action" value="logout"/>
									<input class="hvr-shutter-in-horizontal"  type="submit" value="${logout}">
								</form>
							</div>
						</li>
						<c:if test="${sessionScope.locale == 'en'}">
							<li>
								<form action="Controller" method="post">
									<input type="hidden" name="action" value="ru"/>
									<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
									<button type="submit" style="border: 0; background: transparent">
										<img src="/images/48/ru.png" width="32" height="32" alt="RU" />
									</button>
								</form>
							</li>
						</c:if>
						<c:if test="${sessionScope.locale == 'ru'}">
							<li>
								<form action="Controller" method="post">
									<input type="hidden" name="action" value="en"/>
									<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
									<button type="submit" style="border: 0; background: transparent">
										<img src="/images/48/gb.png" width="32" height="32" alt="GB" />
									</button>
								</form>
							</li>
						</c:if>
					</ul>
				</div>
				<!--/.navbar-collapse-->
			</nav>


		</div>
	</div>
</div>
<!-- banner -->
<!-- offers -->
<div class="main-1">
	<div class="container">
		<div class="register">
			<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
				<h3>${cabinet}</h3><br><br>
				<form action="Controller" method="get">
					<input type="hidden" name="action" value="getfunds"/>
					<input type="hidden" name="userID" value="${sessionScope.get("user").getID()}">
					<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
					<div class="booking-form2">
						<input class="btn btn-default" type="submit" value="${showCash}">
					</div>
				</form>

				<c:if test="${funds != null}">
					<div class="alert alert-success alert-success" role="alert">
						<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<strong><c:out value="${funds}"/></strong> USD
					</div>
				</c:if>

				<c:if test="${requestScope.error != null}">
					<div class="alert alert-danger" role="alert">
						<strong></strong> ${message}
					</div>
				</c:if>
			</div>

			<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
				<form action="Controller" method="post">
					<div class="register-top-grid">
						<input type="hidden" name="action" value="addfunds"/>
						<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
						<input type="hidden" name="userID" value="${sessionScope.get("user").getID()}">
						<div class="wow fadeInRight" data-wow-delay="0.4s">
							<h4>USD<label>*</label></h4>
							<input type="number" name="toAdd">
							<br>
							<div class="booking-form2">
								<input type="submit" value="${add}"/>
							</div>
						</div>
					</div>
					<br>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- offers -->
<!-- footer -->
<div class="footer">
	<div class="container">
		<div class="col-md-4 deco">
			<h4>Hotel Eden</h4>
			<li><a>Hotel Eden in Rome</a></li>
			<li class="white"><a>Via Ludovisi 49, 00187 IT</a></li>
			<li class="white"><a>Tel: 0039 06 478121</a></li>
			<li class="white"><a>Email: info@eden.com</a></li>
		</div>
		<div class="col-md-4 deco">
			<h4>Navigation</h4>
			<li><a href="Offers">${myReservations}</a></li>
			<c:if test="${sessionScope.role == 'admin'}">
				<li><a href="AllOffers">${allReservations}</a></li>
				<li><a href="Users">${users}</a></li>
			</c:if>
			<li><a href="Cabinet">${cabinet}</a></li>
		</div>
		<div class="col-md-4 cardss">
			<h4>${payment}</h4>
			<li><i class="visa"></i></li>
			<li><i class="ma"></i></li>
			<li><i class="paypal"></i></li>
			<div class="clearfix"> </div>
		</div>

		<div class="clearfix"> </div>
	</div>
</div>

<!-- footer -->
</body>
</html>