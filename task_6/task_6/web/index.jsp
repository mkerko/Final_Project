<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:setBundle basename="localize" var="loc"/>
	<fmt:message bundle="${loc}" key="local.button.logout" var="logout"/>
	<fmt:message bundle="${loc}" key="local.title.home" var="title"/>
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
	<fmt:message bundle="${loc}" key="local.book" var="book"/>
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
	<div class="banner">
		<div class="header">
			<div class="container">
				<div class="logo">
					<h1><a href="index.jsp">Motel</a></h1>
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
									<form action="Controller" method="post">
										<input type="hidden" name="action" value="logout"/>
										<input class="hvr-shutter-in-horizontal"  type="submit" value="${logout}"/>
									</form>
									</li>
								</ul>
							</div>
						<!--/.navbar-collapse-->
					</nav>

					<div class="clearfix"> </div>

				<!-- search-scripts -->
					<script src="js/classie.js"></script>
					<script src="js/uisearch.js"></script>
					<script>
						new UISearch( document.getElementById( 'sb-search' ) );
					</script>
				<!-- //search-scripts -->

			</div>
		</div>
	</div>
	<!-- banner -->
	<!-- hod -->
	<div class="hod">
		<div class="container">
			<div class="col-md-6 hod-left">
				<img src="images/rooms/1.jpg" class="img-responsive" alt="">
			</div>
			<div class="col-md-6 hod-right">
				<h2>${room1Name} <span>110$</span></h2>
				<p>${description1}</p>
				<a class="hvr-shutter-in-horizontal" href="Room1">${book}</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- hod -->
	<!-- tels -->
	<div class="tels">
		<div class="container">
			<div class="col-md-4 tels-left">
				<h4>${room2Name} <span>150$</span></h4>
				<img src="images/rooms/2.jpg" class="img-responsive" alt="">
				<p>${description2}</p>
				<a class="hvr-shutter-in-horizontal" href="Room2">${book}</a>
			</div>
			<div class="col-md-4 tels-left">
				<h4>${room3Name} <span>200$</span></h4>
				<img src="images/rooms/3.jpg" class="img-responsive" alt="">
				<p>${description3}</p>
				<a class="hvr-shutter-in-horizontal" href="Room3">${book}</a>
			</div>
			<div class="col-md-4 tels-left">
				<h4>${room4Name} <span>110$</span></h4>
				<img src="images/rooms/4.jpg" class="img-responsive" alt="">
				<p>${description4}</p>
				<a class="hvr-shutter-in-horizontal" href="Room4">${book}</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- tels -->
	<!-- special -->
	<div class="special">
		<div class="container">
			<div class="spe-info">
				<h3>Special Offer</h3>
				<p>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
			</div>
		</div>
	</div>
	<!-- special -->
	<!-- quick -->
	<div class="quick">
		<div class="container">
			<div class="col-md-4 quick-left">
				<h3>Most Popular</h3>
					<ul>
						<li><a href="#">Distribution of letters, as opposed</a></li>
						<li><a href="#">Distribution of letters, as opposed</a></li>
						<li><a href="#">Distribution of letters, as opposed</a></li>
						<li><a href="#">Distribution of letters, as opposed</a></li>
						<li><a href="#">Distribution of letters, as opposed</a></li>
					</ul>
			</div>
			<div class="col-md-4 quick-left">
				<h3>News & Events</h3>
				<div class="new">
					<div class="n-lft">
						<h5>10</h5>
						<h6>Sep</h6>
					</div>
					<div class="n-rgt">
						<p>Lorem Ipsum is that it has a more-or-less normal<a href="#">More</a></p>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="new-1">
					<div class="n-lft">
						<h5>15</h5>
						<h6>Sep</h6>
					</div>
					<div class="n-rgt">
						<p>That it has a more-or-less normal distribution<a href="#">More</a></p>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="col-md-4 quick-left">
				<h3>Quick Message</h3>
					<form>
						<input type="text" class="textbox" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}">
						<textarea placeholder="" onfocus="this.value='';" onblur="if (this.value == '') {this.value = 'Message';}">Message</textarea>
						<input type="submit" value="Submit">
					</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- quick -->
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