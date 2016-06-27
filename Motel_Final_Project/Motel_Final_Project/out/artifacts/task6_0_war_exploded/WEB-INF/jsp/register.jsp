<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<fmt:setLocale value="${sessionScope.locale}"/>
	<fmt:setBundle basename="localize" var="loc"/>
	<fmt:message bundle="${loc}" key="local.guestNumber" var="guestNumber"/>
	<fmt:message bundle="${loc}" key="local.firstName" var="firstName"/>
	<fmt:message bundle="${loc}" key="local.lastName" var="lastName"/>
	<fmt:message bundle="${loc}" key="local.pSeries" var="pSeries"/>
	<fmt:message bundle="${loc}" key="local.pNumber" var="pNumber"/>
	<fmt:message bundle="${loc}" key="local.age" var="age"/>
	<fmt:message bundle="${loc}" key="local.login" var="login"/>
	<fmt:message bundle="${loc}" key="local.personalInfo" var="personalInfo"/>
	<fmt:message bundle="${loc}" key="local.password" var="password"/>
	<fmt:message bundle="${loc}" key="local.register" var="register"/>
	<fmt:message bundle="${loc}" key="local.title.home" var="title"/>
	<fmt:message bundle="${loc}" key="local.nav.allreservations" var="allReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.cabinet" var="cabinet"/>
	<fmt:message bundle="${loc}" key="local.nav.myreservations" var="myReservations"/>
	<fmt:message bundle="${loc}" key="local.nav.users" var="users"/>
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
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
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


			</div>
		</div>
	</div>		
		<!-- banner -->
<!-- registration -->
	<div class="main-1">
		<div class="container">
			<div class="register">
				<form action="Controller" method="post">
					<div class="register-top-grid">
						<h3>${personalInfo}</h3>
						<input type="hidden" name="action" value="register"/>
						<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
						<input type="hidden" name="role" value="client"/>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${firstName}<label>*</label></span>
							<input type="text" name="First_name" id="First_name"  placeholder="${firstName}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${lastName}<label>*</label></span>
							<input type="text" name="Last_name" id="Last_name" placeholder="${lastName}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${pSeries}<label>*</label></span>
							<input type="text" name="Passport_series" id="Passport_series" placeholder="${pSeries}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${pNumber}<label>*</label></span>
							<input type="text" name="Passport_numb" id="Passport_numb" placeholder="${pNumber}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${age}<label>*</label></span>
							<input type="text" name="Age" id="Age" placeholder="${age}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${login}<label>*</label></span>
							<input type="text" name="login" id="login" placeholder="${login}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${password}<label>*</label></span>
							<input type="password" name="password" id="password" placeholder="${password}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span>${password}<label>*</label></span>
							<input type="password" name="password" id="confirm_password" placeholder="${password}"/>*
						</div>
						<div class=" col-sm-6 col-md-6" data-wow-delay="0.4s">
							<span><label>*</label></span>
							<div class="booking-form2">
								<input type="submit" value="${register}"/>
							</div>
						</div>
					</div>
				</form>
			</div>
			<div class=" col-sm-12 col-md-12" data-wow-delay="0.4s">
				<c:if test="${requestScope.error != null}">
					<div class="alert alert-danger" role="alert">
						<strong></strong> ${message}
					</div>
				</c:if>
			</div>
		</div>

	</div>

<script>
	var password = document.getElementById("password"),
			confirm_password = document.getElementById("confirm_password"),
			First_name = document.getElementById("First_name"),
			Last_name = document.getElementById("Last_name"),
			Passport_series = document.getElementById("Passport_series"),
			Passport_numb = document.getElementById("Passport_numb"),
			Age = document.getElementById("Age"),
			login = document.getElementById("login")
			;

	function validatePassword(){
		if(password.value != confirm_password.value) {
			confirm_password.setCustomValidity("Passwords Don't Match");
		} else {
			confirm_password.setCustomValidity('');
		}
		if(First_name.value == '') {
			First_name.setCustomValidity("Please, fill out");
		} else {
			First_name.setCustomValidity('');
		}
		if(Last_name.value == '') {
			Last_name.setCustomValidity("Please, fill out");
		} else {
			Last_name.setCustomValidity('');
		}
		if(Passport_series.value == '') {
			Passport_series.setCustomValidity("Please, fill out");
		} else {
			Passport_series.setCustomValidity('');
		}
		if(Passport_numb.value == '') {
			Passport_numb.setCustomValidity("Please, fill out");
		} else {
			Passport_numb.setCustomValidity('');
		}
		if(Age.value == '') {
			Age.setCustomValidity("Please, fill out");
		} else {
			Age.setCustomValidity('');
		}
		if(login.value == '') {
			login.setCustomValidity("Please, fill out");
		} else {
			login.setCustomValidity('');
		}
	}

	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
</script>
<!-- registration -->
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