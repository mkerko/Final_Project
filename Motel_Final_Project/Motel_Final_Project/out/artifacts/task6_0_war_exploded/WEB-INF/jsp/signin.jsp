<!DOCTYPE HTML>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
 <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="localize" var="loc"/>
    <fmt:message bundle="${loc}" key="local.title.login" var="title"/>
	<fmt:message bundle="${loc}" key="local.nav.allreservations" var="allReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.cabinet" var="cabinet"/>
	<fmt:message bundle="${loc}" key="local.sign.create" var="create"/>
	<fmt:message bundle="${loc}" key="local.nav.myreservations" var="myReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.users" var="users"/>
	<fmt:message bundle="${loc}" key="local.footer.siteMap" var="siteMap"/>
	<fmt:message bundle="${loc}" key="local.footer.payment" var="payment"/>
    <fmt:message bundle="${loc}" key="local.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.submit" var="submit"/>
    <fmt:message bundle="${loc}" key="local.register" var="register"/>
    <fmt:message bundle="${loc}" key="local.ru" var="ru"/>
    <fmt:message bundle="${loc}" key="local.en" var="en"/>
    <fmt:message bundle="${loc}" key="local.error.message" var="message"/>
	<fmt:message bundle="${loc}" key="local.sign.newcust" var="newcust"/>
	<fmt:message bundle="${loc}" key="local.sign.newdesc" var="newdesc"/>
	<fmt:message bundle="${loc}" key="local.sign.regcust" var="regcust"/>
	<fmt:message bundle="${loc}" key="local.sign.regdesc" var="regdesc"/>

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
					<h1><a href="SignIn">Hotel EDEN</a></h1>
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

							</ul>
						</div>
						<!--/.navbar-collapse-->
					</nav>

					<div class="clearfix"> </div>



			</div>
		</div>
	</div>		
		<!-- banner -->

<div class="login-page">
		<div class="container">
			<div class="account_grid">
				<div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
					<h3>${newcust}</h3>
					<p>${newdesc}</p>
					<a class="acount-btn" href="Registration">${create}</a>
			   </div>
			   <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
				   <h3>${regcust}</h3>
				   <p>${regdesc}</p>
					<form action="Controller" method="post">
			        <input type="hidden" name="action" value="login"/>
			        <input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
			        <input type="text" name="login" placeholder="${login}"><br><br>
			        <input type="password" name="password" placeholder="${password}"><br><br>
			        <input type="submit" value="${submit}"><br>
						<c:if test="${requestScope.error != null}">
							<div class="alert alert-danger" role="alert">
								<strong></strong> ${message}
							</div>
						</c:if>
			      </form>
			   </div>	
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
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
			<h4>Language</h4>
			<li>
				<form action="Controller" method="post">
					<input type="hidden" name="action" value="ru"/>
					<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
					<button type="submit" style="border: 0; background: transparent">
						<img src="/images/48/ru.png" width="32" height="32" alt="RU" />
					</button>
				</form>
			</li>
			<li>
				<form action="Controller" method="post">
					<input type="hidden" name="action" value="en"/>
					<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
					<button type="submit" style="border: 0; background: transparent">
						<img src="/images/48/gb.png" width="32" height="32" alt="GB" />
					</button>
				</form>
			</li>
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