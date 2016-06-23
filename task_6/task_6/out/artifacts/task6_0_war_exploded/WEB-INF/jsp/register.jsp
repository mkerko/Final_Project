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
	<fmt:message bundle="${loc}" key="local.firstName" var="firstName"/>
	<fmt:message bundle="${loc}" key="local.lastName" var="lastName"/>
	<fmt:message bundle="${loc}" key="local.pSeries" var="pSeries"/>
	<fmt:message bundle="${loc}" key="local.pNumber" var="pNumber"/>
	<fmt:message bundle="${loc}" key="local.age" var="age"/>
	<fmt:message bundle="${loc}" key="local.login" var="login"/>
	<fmt:message bundle="${loc}" key="local.password" var="password"/>
	<fmt:message bundle="${loc}" key="local.submit" var="submit"/>
	<fmt:message bundle="${loc}" key="local.register" var="register"/>
	<fmt:message bundle="${loc}" key="local.ru" var="ru"/>
	<fmt:message bundle="${loc}" key="local.en" var="en"/>
	<fmt:message bundle="${loc}" key="local.error.message" var="message"/>
	<fmt:message bundle="${loc}" key="local.button.goback" var="goback"/>

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
								<%--<li><a href="/index.jsp">Home</a></li>--%>
								<%--<li><a href="Rooms">Rooms</a></li>--%>
								<%--<li><a href="Offers">Offers</a></li>--%>
								<%--<li><a href="">Short Codes</a></li>--%>
								<%--<li><a href="SignIn.jsp">Sign In</a></li>--%>
								<%--<li><a href="Contacts">Contact</a></li>--%>
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
						<h3>PERSONAL INFORMATION</h3>
						<input type="hidden" name="action" value="register"/>
						<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
						<input type="hidden" name="role" value="client"/>
						<div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>${firstName}<label>*</label></span>
						<input type="text" name="First_name">
						</div>
						<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>${lastName}<label>*</label></span>
						<input type="text" name="Last_name">
						</div>
						<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>${pSeries}<label>*</label></span>
						<input type="text" name="Passport_series">
						</div>
						<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>${pNumber}<label>*</label></span>
						<input type="text" name="Passport_numb">
						</div>
						<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>${age}<label>*</label></span>
						<input type="text" name="Age">
						</div>
						<div class="clearfix"></div>
						<br>
						<div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>${login}<label>*</label></span>
						<input type="text" name="login" placeholder="${login}"/>
						</div>
						<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>${password}<label>*</label></span>
						<input type="password" name="password" placeholder="${password}"/>
						</div>
						<input type="submit" value="${register}"/><br>
					</div>
				</form>
		  	  <%--<form  action="Controller" method="post">--%>
				 <%--<div class="register-top-grid">--%>
					<%--<h3>PERSONAL INFORMATION</h3>--%>
					 <%--<div class="wow fadeInLeft" data-wow-delay="0.4s">--%>
						 <%--<span>${firstName}<label>*</label></span>--%>
						 <%--<input type="text" name="First_name">--%>
					 <%--</div>--%>
					 <%--<div class="wow fadeInRight" data-wow-delay="0.4s">--%>
						 <%--<span>${lastName}<label>*</label></span>--%>
						 <%--<input type="text" name="Last_name">--%>
					 <%--</div>--%>
					 <%--<div class="wow fadeInRight" data-wow-delay="0.4s">--%>
						 <%--<span>${pSeries}<label>*</label></span>--%>
						 <%--<input type="text" name="Passport_series">--%>
					 <%--</div>--%>
					 <%--<div class="wow fadeInRight" data-wow-delay="0.4s">--%>
						 <%--<span>${pNumber}<label>*</label></span>--%>
						 <%--<input type="text" name="Passport_numb">--%>
					 <%--</div>--%>
					 <%--<div class="wow fadeInRight" data-wow-delay="0.4s">--%>
						 <%--<span>${age}<label>*</label></span>--%>
						 <%--<input type="text" name="Age">--%>
					 <%--</div>--%>
					 <%--<div class="clearfix"> </div>--%>
					   <%--<a class="news-letter" href="#">--%>
						 <%--<label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Sign Up for Newsletter</label>--%>
					   <%--</a>--%>
					 <%--</div>--%>
				     <%--<div class="register-bottom-grid">--%>
						    <%--<h3>LOGIN INFORMATION</h3>--%>
							 <%--<div class="wow fadeInLeft" data-wow-delay="0.4s">--%>
								<%--<span>${login}<label>*</label></span>--%>
								 <%--<input type="text" name="login" placeholder="${login}"/>--%>
							 <%--</div>--%>
							 <%--<div class="wow fadeInRight" data-wow-delay="0.4s">--%>
								<%--<span>${password}<label>*</label></span>--%>
								 <%--<input type="password" name="password" placeholder="${password}"/>--%>
							 <%--</div>--%>
					 <%--</div>--%>
				  <%--<div class="clearfix"> </div>--%>
				  <%--<div class="register-but">--%>

					  <%--<input type="hidden" name="action" value="register"/>--%>
					  <%--<input type="hidden" name="page" value="${pageContext.request.requestURI}"/>--%>
					  <%--<input type="submit" value="${register}"/><br>--%>
					  <%--<div class="clearfix"> </div>--%>
				  <%--</div>--%>
				<%--</form>--%>

		   <%--</div>--%>
	</div>
			</div>
		</div>
<!-- registration -->
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