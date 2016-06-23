<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:setBundle basename="localize" var="loc"/>
	<fmt:message bundle="${loc}" key="local.button.goback" var="logout"/>
	<fmt:message bundle="${loc}" key="local.title.login" var="title"/>
	<fmt:message bundle="${loc}" key="local.login" var="login"/>
	<fmt:message bundle="${loc}" key="local.password" var="password"/>
	<fmt:message bundle="${loc}" key="local.submit" var="submit"/>
	<fmt:message bundle="${loc}" key="local.register" var="register"/>
	<fmt:message bundle="${loc}" key="local.ru" var="ru"/>
	<fmt:message bundle="${loc}" key="local.en" var="en"/>
	<fmt:message bundle="${loc}" key="local.error.message" var="message"/>
	<title>${title}</title>
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
				<h1><a href="/index.jsp">Motel</a></h1>
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
				<!--/.navbar-header-->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="Offers">My Reservations</a></li>
						<c:if test="${sessionScope.role == 'admin'}">
							<li><a href="AllOffers">All Reservations</a></li>
							<li><a href="Users">Users</a></li>
						</c:if>
						<%--<li><a href="ShortCodes">Short Codes</a></li>--%>
						<li><a href="Cabinet">Cabinet</a></li>
						<li>
							<form action="Controller" method="post">
								<input type="hidden" name="action" value="logout"/>
								<input class="hvr-shutter-in-horizontal"  type="submit" value="${logout}"/>
							</form>
						</li>
					</ul>
				</div>
				<!--/.navbar-collapse-->
				<!--/.navbar-collapse-->
			</nav>


		</div>
	</div>
</div>
<!-- banner -->
<!-- offers -->
<div class="offers">
	<div class="container">

		<h3>All orders</h3>
		<form name="myForm" id="myForm" action="Controller" method="get">
			<input type="hidden" name="action" value="getallreservations"/>
			<input type="hidden" name="userID" value="${sessionScope.get("user").getID()}">
			<input type="hidden" name="role" value="${sessionScope.get("user").getRole()}">
			<input class="btn btn-default" id="AutoSubmit" type="submit" value="Show all orders">
			<%--<script type="text/javascript">--%>
			<%--var something = (function() {--%>
			<%--var executed = false;--%>
			<%--return function () {--%>
			<%--if (!executed) {--%>
			<%--executed = true;--%>
			<%--document.forms["myForm"].submit();// do something--%>
			<%--}--%>
			<%--};--%>
			<%--})();--%>

			<%--</script>--%>
		</form>
		<div class="clearfix"></div>
		<br>
			<c:forEach items="${reservations}" var="reservation">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="images/4.jpg" alt="...">
						<div class="caption">
							<h3>Room #${reservation.roomID}</h3>
							<ul class="list-group">
								<li class="list-group-item">Sign In: ${reservation.startDate}</li>
								<li class="list-group-item">Sign out: ${reservation.endDate}</li>
								<li class="list-group-item">Number of guests: ${reservation.guestNumber}</li>
								<li class="list-group-item">Is approved:
									<c:if test="${reservation.getIsApproved() == false}">
										Not yet
									</c:if>

									<c:if test="${reservation.getIsApproved() == true}">
										Yes
									</c:if>
								</li>
								<c:if test="${reservation.getIsApproved() == false}">
								<li class="list-group-item">
									<form>
										<input type="hidden" name="action" value="approvereservation"/>
										<input type="hidden" name="orderID" value="${reservation.orderID}">
										<input class="btn btn-default" type="submit" value="Approve order">
									</form>
								</li>
								</c:if>
								<%--<div>--%>
								<%--<li class="list-group-item">--%>
									<%--<form>--%>
										<%--<input type="hidden" name="action" value="approvereservation"/>--%>
										<%--<input type="hidden" name="orderID" value="${reservation.orderID}">--%>
										<%--<input class="btn btn-default" type="submit" value="Approve order">--%>
									<%--</form>--%>
								<%--</li>--%>
								<%--</div>--%>
							</ul>
						</div>
					</div>
				</div>
			</c:forEach>
		<div class="clearfix"></div><br>

		<%----%>
		<%--<c:if test="${requestScope.error != null}">--%>
		<%--<div>--%>
		<%--<h4>${message}</h4>--%>
		<%--<p>${requestScope.error}</p>--%>
		<%--</div>--%>
		<%--</c:if>--%>
		<%--<form action="Controller" method="post">--%>

		<%--<c:forEach items="$	{reservations}" var="reservation">--%>
		<%--<input type="hidden" name="action" value="deletereservation"/>--%>
		<%--<input type="hidden" name="roomID" value="${reservation.orderID}">--%>
		<%--<input class="btn btn-default" type="submit" value="Delete order #${reservation.orderID}">--%>
		<%--</c:forEach>--%>
		<%--</form>--%>
	</div>
</div>
<!-- offers -->
<!-- footer -->
<div class="footer">
	<div class="container">
		<div class="col-md-2 deco">
			<h4>Navigation</h4>
			<li><a href="/index.jsp">Home</a></li>
			<li><a href="ShortCodes">Short Codes </a></li>
			<li><a href="SignIn">Sign in</a></li>
			<li><a href="Contacts">Contact</a></li>
		</div>
		<div class="col-md-2 deco">
			<h4>Links</h4>
			<li><a href="#">Qui Sommes-Nous ?</a></li>
			<li><a href="#">Mentions Légales </a></li>
			<li><a href="#">Conditions D'Utilisation </a></li>
		</div>
		<div class="col-md-2 deco">
			<h4>Language</h4>
			<a>
				<form action="Controller" method="post">
					<input type="hidden" name="action" value="en"/>
					<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
					<input type="submit" value="${en}"/>
				</form>
			</a>
			<form action="Controller" method="post">
				<input type="hidden" name="action" value="ru"/>
				<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
				<input type="submit" value="${ru}"/>
			</form>
		</div>
		<div class="col-md-3 cardss">
			<h4>Payment Sécure</h4>
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