<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:setBundle basename="localize" var="loc"/>
	<fmt:message bundle="${loc}" key="local.button.goback" var="logout"/>
	<fmt:message bundle="${loc}" key="local.title.room1" var="title"/>
	<fmt:message bundle="${loc}" key="local.nav.allreservations" var="allReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.cabinet" var="cabinet"/>
	<fmt:message bundle="${loc}" key="local.nav.myreservations" var="myReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.users" var="users"/>
	<fmt:message bundle="${loc}" key="local.room.name1" var="room1Name"/>
	<fmt:message bundle="${loc}" key="local.room.name2" var="room2Name"/>
	<fmt:message bundle="${loc}" key="local.room.name3" var="room3Name"/>
	<fmt:message bundle="${loc}" key="local.room.name4" var="room4Name"/>
	<fmt:message bundle="${loc}" key="local.room.description1" var="description1"/>
	<fmt:message bundle="${loc}" key="local.room.description2" var="description2"/>
	<fmt:message bundle="${loc}" key="local.room.description3" var="description3"/>
	<fmt:message bundle="${loc}" key="local.room.description4" var="description4"/>
	<fmt:message bundle="${loc}" key="local.footer.siteMap" var="siteMap"/>
	<fmt:message bundle="${loc}" key="local.footer.payment" var="payment"/>
	<fmt:message bundle="${loc}" key="local.login" var="login"/>
	<fmt:message bundle="${loc}" key="local.book" var="book"/>
	<fmt:message bundle="${loc}" key="local.password" var="password"/>
	<fmt:message bundle="${loc}" key="local.submit" var="submit"/>
	<fmt:message bundle="${loc}" key="local.register" var="register"/>
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
<!-- details -->

<div class="details">
	<div class="container">
		<div class="col-md-7 details-left">
			<h3>${room1Name}</h3>
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<img src="../images/rooms/12.jpg" >
						<div class="carousel-caption">
						</div>
					</div>
					<div class="item">
						<img src="../images/rooms/13.jpg" >
						<div class="carousel-caption">
						</div>
					</div>
				</div>

				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
					<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<div class="col-md-5 details-right">
			<br><br>
			<p>${description1}</p>
			<br>
			<!-- Button trigger modal -->
				<button data-toggle="modal" data-target="#myModal" style="
				margin-top: 25px;
				font-family: 'Open Sans', sans-serif;
				cursor: pointer;
				background: #000000;
				border: 1px solid #000000;
				padding: 10px 24px;
				outline: none;
				color: #ffffff;
				font-size: 0.8em;
				text-transform: uppercase;
				-webkit-appearance: none;">
					Learn more
				</button>
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<h4 class="modal-title" id="myModalLabel">Details</h4>
						</div>
						<div class="modal-body">
							<div class="list-group">
								<div class="row">
									<div class="col-md-5"><b>Floor</b></div>
									<div class="col-md-7">5th</div>
								</div><br>
								<div class="row">
									<div class="col-md-5"><b>Bath/Shower</b></div>
									<div class="col-md-7">marble bathroom and separate shower</div>
								</div><br>
								<div class="row">
									<div class="col-md-5"><b>Vanity sink</b></div>
									<div class="col-md-7">Single</div>
								</div><br>
								<div class="row">
									<div class="col-md-5"><b>View</b></div>
									<div class="col-md-7">City</div>
								</div><br>
								<div class="row">
									<div class="col-md-5"><b>Size</b></div>
									<div class="col-md-7">55 sqm - 592 sqf</div>
								</div>


							</div>
						</div>
						<div class="modal-footer">
							<button data-toggle="modal" data-target="#myModal" style="
				margin-top: 25px;
				font-family: 'Open Sans', sans-serif;
				cursor: pointer;
				background: #000000;
				border: 1px solid #000000;
				padding: 10px 24px;
				outline: none;
				color: #ffffff;
				font-size: 0.8em;
				text-transform: uppercase;
				-webkit-appearance: none;">
								Close
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="clearfix"> </div>

		<div class="details-top">
		</div>
		<div class="booking-form">
				<form action="Controller" method="post">
					<input type="hidden" name="action" value="book"/>
					<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
					<div class="col-md-3">
						<h5>CHECK IN</h5><br>
						<label>${checkIn}: </label><input type="date" name="startDate">
					</div>
					<div class="col-md-3">
						<h5>CHECK OUT</h5><br>
						<label>${checkOut}: </label><input type="date" name="endDate">
					</div>
					<div class="col-md-3">
						<h5>NUMBER OF GUESTS</h5><br>
						<label>${guestNumber}: </label><input type="number" name="guestNumber"><br><br>
					</div>
					<input type="hidden" name="roomID" value="1"><br>
					<input type="hidden" name="price" value="110"><br>
					<input type="hidden" name="userID" value="${sessionScope.get("user").getID()}">
					<div class="col-md-3">
						<input type="submit" value="${book}"/>
					</div>
					<div class=" col-sm-12 col-md-12" data-wow-delay="0.4s">
						<c:if test="${requestScope.error != null}">
							<div class="alert alert-danger" role="alert">
								<strong></strong> ${message}
							</div>
						</c:if>
					</div>
				</form>
			</div>


		</div>
	</div>

</div>
<!-- details -->
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
<script type="text/javascript">
	function fnc()
	{

		document.getElementById("message").click();
	}
</script>
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
</body>
</html>