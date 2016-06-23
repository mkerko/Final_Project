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
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li><a href="Rooms">Rooms</a></li>
								<li><a href="Offers">My Reservations</a></li>
								<c:if test="${sessionScope.role == 'admin'}">
									<li><a href="AllOffers">All Reservations</a></li>
									<li><a href="Users">All Users</a></li>
								</c:if>
								<%--<li><a href="ShortCodes">Short Codes</a></li>--%>
								<li><a href="Contacts">Contact</a></li>
								<form action="Controller" method="post">
									<input type="hidden" name="action" value="logout"/>
									<input class="hvr-shutter-in-horizontal"  type="submit" value="${logout}"/>
								</form>
							</ul>
						</div>
						<!--/.navbar-collapse-->
					</nav>


			</div>
		</div>
	</div>		
		<!-- banner -->
<!--start-contact-->
	<div class="contact">
		<div class="container">
			<div class="contact-top heading">
				<h3>CONTACT US</h3>
			</div>
			<div class="contact-bottom">
				<input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" />
				<input type="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" />
				<input type="text" value="Phone" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Phone';}" />
				<textarea value="Message:" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message';}">Message..</textarea>
				<div class="submit-btn">
					<form>
						<input type="submit" value="SUBMIT">
					</form>
				</div>
			</div>
		<!--end-contact-->
		<!--start-map-->
			<div class="co-bt">
				<div class="col-md-3 add">
					<h4>Address</h4>
					<address>
						795 Folsom Ave, Suite 600<br>
						San Francisco, CA 94107<br>
						<abbr title="Phone">P :</abbr> (123) 456-7890
					</address>
				</div>
				<div class="col-md-9 map">
					<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2884.310671366718!2d7.283884900000001!3d43.70409239999999!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12cddab7066db4e1%3A0x7e52715fee03b279!2sNICE+FRANCE!5e0!3m2!1sen!2sin!4v1435662218413" frameborder="0" style="border:0" allowfullscreen></iframe>	
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--end-map-->
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