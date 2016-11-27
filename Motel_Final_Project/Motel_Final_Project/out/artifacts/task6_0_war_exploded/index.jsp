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
	<fmt:message bundle="${loc}" key="local.nav.login" var="navlogin"/>
	<fmt:message bundle="${loc}" key="local.footer.siteMap" var="siteMap"/>
	<fmt:message bundle="${loc}" key="local.footer.payment" var="payment"/>
	<fmt:message bundle="${loc}" key="local.book" var="book"/>
	<fmt:message bundle="${loc}" key="local.ru" var="ru"/>
	<fmt:message bundle="${loc}" key="local.en" var="en"/>
	<fmt:message bundle="${loc}" key="local.error.message" var="message"/>
	<fmt:message bundle="${loc}" key="local.room.name1" var="room1Name"/>
	<fmt:message bundle="${loc}" key="local.room.name2" var="room2Name"/>
	<fmt:message bundle="${loc}" key="local.room.name3" var="room3Name"/>
	<fmt:message bundle="${loc}" key="local.room.name4" var="room4Name"/>
	<fmt:message bundle="${loc}" key="local.room.description1" var="description1"/>
	<fmt:message bundle="${loc}" key="local.room.description2" var="description2"/>
	<fmt:message bundle="${loc}" key="local.room.description3" var="description3"/>
	<fmt:message bundle="${loc}" key="local.room.description4" var="description4"/>
	<fmt:message bundle="${loc}" key="local.main.hotelDescription" var="description"/>
	<fmt:message bundle="${loc}" key="local.main.quickMessage" var="quickMessage"/>
	<fmt:message bundle="${loc}" key="local.main.messageArea" var="messageArea"/>
	<fmt:message bundle="${loc}" key="local.main.send" var="send"/>
	<fmt:message bundle="${loc}" key="local.main.sent" var="sent"/>
	<fmt:message bundle="${loc}" key="local.main.faciliteies" var="faciliteies"/>
	<fmt:message bundle="${loc}" key="local.main.f1" var="f1"/>
	<fmt:message bundle="${loc}" key="local.main.f2" var="f2"/>
	<fmt:message bundle="${loc}" key="local.main.f3" var="f3"/>
	<fmt:message bundle="${loc}" key="local.main.f4" var="f4"/>
	<fmt:message bundle="${loc}" key="local.main.f5" var="f5"/>
	<fmt:message bundle="${loc}" key="local.title.orders" var="orders"/>



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
	<div class="banner">
		<div class="header">
			<div class="container">
				<div class="logo">
					<h1><a href="index.jsp">Hotel EDEN</a></h1>
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
									<c:if test="${sessionScope.role == 'admin'}">
										<li><a href="AllOffers">${allReservations}</a></li>
										<li><a href="Users">${users}</a></li>
									</c:if>
									<c:choose>
										<c:when test="${sessionScope.role == 'admin' || sessionScope.role == 'client'}">
											<li><a href="Offers">${myReservations}</a></li>
											<li><a href="Cabinet">${cabinet}</a></li>
											<li>
												<div class="booking-form2">
													<form action="Controller" method="post">
														<input type="hidden" name="action" value="logout"/>
														<input class="hvr-shutter-in-horizontal"  type="submit" value="${logout}">
													</form>
												</div>
											</li>
										</c:when>
										<c:otherwise>
											<li><a href="SignIn">${navlogin}</a></li>
										</c:otherwise>
									</c:choose>
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
									<c:if test="${sessionScope.locale == 'ru' || (sessionScope.locale != 'ru' && sessionScope.locale != 'en')}">
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

					<div class="clearfix"> </div>

			</div>
		</div>
	</div>
	<!-- banner -->
	<!-- hod -->
	<div class="hod">
		<div class="container">
			<div class="col-md-6 hod-left">
				<img href="Room1" src="images/rooms/12.jpg" class="img-responsive" alt="">
			</div>
			<div class="col-md-6 hod-right">
				<a href="Room1"><h2><span>${room1Name} </span>110$</h2></a>
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
				<a href="Room2"><h4><span>${room2Name} </span>150$</h4></a>
				<img src="images/rooms/2.jpg" class="img-responsive" alt="">
				<p>${description2}</p>
				<a class="hvr-shutter-in-horizontal" href="Room2">${book}</a>
			</div>
			<div class="col-md-4 tels-left">
				<a href="Room3"><h4><span>${room3Name} </span>200$</h4></a>
				<img src="images/rooms/3.jpg" class="img-responsive" alt="">
				<p>${description3}</p>
				<a class="hvr-shutter-in-horizontal" href="Room3">${book}</a>
			</div>
			<div class="col-md-4 tels-left">
				<a href="Room4"><h4><span>${room4Name} </span>110$</h4></a>
				<img src="images/rooms/42.jpg" class="img-responsive" alt="">
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
				<h3>Hotel Eden</h3>
				<p>
					${description}
				</p>
			</div>
		</div>
	</div>
	<!-- special -->
	<!-- quick -->
	<div class="quick">
		<div class="container">
			<div class="col-md-6 quick-left">
				<h3>${faciliteies}</h3>
					<ul>
						<li><a>${f1}</a></li>
						<li><a>${f2}</a></li>
						<li><a>${f3}</a></li>
						<li><a>${f4}</a></li>
						<li><a>${f5}</a></li>
					</ul>
			</div>
			<div class="col-md-6 quick-left">
				<h3>${quickMessage}</h3>
				<form id="javascript_form">
					<input type="text" name="subject" placeholder="email@example.com" />
					<textarea name="text" placeholder="${messageArea}"></textarea>
					<input type="submit" id="js_send" value="${send}" />
				</form>

				<script>
					var form_id_js = "javascript_form";

					var data_js = {
						"access_token": "uhfadaer03y5my05cb9yev4f"
					};

					var sendButton = document.getElementById("js_send");

					function js_send() {
						sendButton.value='${sent}';
						sendButton.disabled=true;
						var request = new XMLHttpRequest();
						request.onreadystatechange = function() {
							if (request.readyState == 4 && request.status == 200) {
								js_onSuccess();
							} else
							if(request.readyState == 4) {
								js_onError(request.response);
							}
						};

						var subject = document.querySelector("#" + form_id_js + " [name='subject']").value;
						var message = document.querySelector("#" + form_id_js + " [name='text']").value;
						data_js['subject'] = subject;
						data_js['text'] = message;
						var params = toParams(data_js);

						request.open("POST", "https://postmail.invotes.com/send", true);
						request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

						request.send(params);

						return false;
					}

					sendButton.onclick = js_send;

					function toParams(data_js) {
						var form_data = [];
						for ( var key in data_js ) {
							form_data.push(encodeURIComponent(key) + "=" + encodeURIComponent(data_js[key]));
						}

						return form_data.join("&");
					}

					var js_form = document.getElementById(form_id_js);
					js_form.addEventListener("submit", function (e) {
						e.preventDefault();
					});
				</script>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!-- quick -->
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
			<c:if test="${sessionScope.role == 'client' || sessionScope.role == 'admin'}">
				<h4>${siteMap}</h4>
				<li><a href="Offers">${myReservations}</a></li>
				<li><a href="Cabinet">${cabinet}</a></li>
			</c:if>
			<c:if test="${sessionScope.role == 'admin'}">
				<li><a href="AllOffers">${allReservations}</a></li>
				<li><a href="Users">${users}</a></li>
			</c:if>
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