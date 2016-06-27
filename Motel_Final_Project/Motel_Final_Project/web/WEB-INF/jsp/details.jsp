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
	<fmt:message bundle="${loc}" key="local.book" var="book"/>
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
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,600' rel='stylesheet' type='text/css'>
	<script src="js/bootstrap-datepicker.js"></script>
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
					</nav>


			</div>
		</div>
	</div>		
		<!-- banner -->
<!-- details -->
	<div class="details">
		<div class="container">
			<div class="col-md-7 details-left">
				<img src="../../images/163.jpg" class="img-responsive" alt="">
			</div>
			<div class="col-md-5 details-right">
				<span><strong>€ 250</strong> € 300 per guest</span>
				<li>Book the service at the best price</li>
				<li>Secure payment by credit card</li>
				<li>No booking fee</li>
				<p> Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and a type specimen book. It has the leap into electronic typesetting, It was popularised in the 1960s with the relesoftware like Aldus PageMaker including versions of Lorem Ipsum.</p>
			</div>
			<div class="clearfix"> </div>
			<div class="details-top">
				<h3>Lorem Ipsum has been the industry's standard dummy tex</h3>
				<h5>Buy the online room booking, save 2 euro and skip the line!</h5>
				<h6>Validity : from 1 January 2015 to 31 August 2015</h6>
				<h4>Included</h4>
				<li>Kids under 5: free</li>
				<li>publishing packages and web .Many desktop publishing packages and web page editors </li>
				<h4>Not included</h4>
				<li> will uncover many web sites still in their infancy. Various versions have evolved over the years,</li>
				<h4>Additional information</h4>
				<p>The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.</p>
			</div>
			<div class="booking-form">
				<div class="col-md-6">		
					<form action="Controller" method="post">
						<input type="hidden" name="action" value="book"/>
						<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
						<h5>CHECK IN</h5><br>
						<label>${checkIn}: </label><input type="date" name="startDate"><br><br>
						<h5>CHECK OUT</h5><br>
						<label>${checkOut}: </label><input type="date" name="endDate"><br><br>
						<h5>NUMBER OF GUESTS</h5><br>
						<label>${guestNumber}: </label><input type="number" name="guestNumber"><br><br>
						<input type="hidden" name="roomID" value="1"><br>
						<input type="hidden" name="price" value="110"><br>
						<input type="hidden" name="userID" value="${sessionScope.get("user").getID()}">
						<input type="submit" value="${book}"/>
						<c:if test="${requestScope.error != null}">
							<div class="error">
								<h4>${requestScope.error}</h4>
							</div>
						</c:if>
				 </form>			      
			 </div>


			</div>
		 </div>

	</div>
<!-- details -->
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
<script>
	$(document).ready(function(){
		var date_input=$('input[name="date"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'mm-dd-yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
		})
	})
	$(document).ready(function(){
		var date_input=$('input[name="date1"]'); //our date input has the name "date"
		var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
		date_input.datepicker({
			format: 'mm-dd-yyyy',
			container: container,
			todayHighlight: true,
			autoclose: true,
		})
	})
</script>
<!-- footer -->
</body>
</html>