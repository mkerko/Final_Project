<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localize" var="loc"/>
<fmt:message bundle="${loc}" key="local.title.login" var="title"/>
<fmt:message bundle="${loc}" key="local.firstName" var="firstName"/>
<fmt:message bundle="${loc}" key="local.lastName" var="lastName"/>
<fmt:message bundle="${loc}" key="local.pSeries" var="pSeries"/>
<fmt:message bundle="${loc}" key="local.pNumber" var="pNumber"/>
<fmt:message bundle="${loc}" key="local.age" var="age"/>
<fmt:message bundle="${loc}" key="local.password" var="password"/>
<fmt:message bundle="${loc}" key="local.register" var="register"/>
<fmt:message bundle="${loc}" key="local.ru" var="ru"/>
<fmt:message bundle="${loc}" key="local.en" var="en"/>
<fmt:message bundle="${loc}" key="local.error.message" var="message"/>
<fmt:message bundle="${loc}" key="local.button.goback" var="goback"/>
<title>${title}</title>
</head>
<body>

<form action="Controller" method="get">
<input type="hidden" name="action" value="en"/>
<input type="hidden" name="page" value="/WEB-INF/jsp/registration.jsp"/>
<input type="submit" value="${en}"/>
</form>

<form action="Controller" method="get">
<input type="hidden" name="action" value="ru"/>
<input type="hidden" name="page" value="/WEB-INF/jsp/registration.jsp"/>
<input type="submit" value="${ru}"/>
</form>

<hr/>

<p>${register}</p>
<form action="Controller" method="post">
    <input type="hidden" name="action" value="register"/>
    <input type="hidden" name="page" value="${pageContext.request.requestURI}"/>


    <label>${firstName}: </label><input type="text" name="First_name"><br>
    <label>${lastName}: </label><input type="text" name="Last_name"><br>
    <label>${pSeries}: </label><input type="text" name="Passport_series"><br>
    <label>${pNumber}: </label><input type="number" name="Passport_numb"><br>
    <label>${age}: </label><input type="date" name="Age"><br>

    <br>
    <input type="text" name="login" placeholder="${login}"/><br/>
    <input type="password" name="password" placeholder="${password}"/>
    <br/><br/>
    <input type="submit" value="${register}"/><br>
</form>

<c:if test="${requestScope.error != null}">
<div>
<h4>${message}</h4>
<p>${requestScope.error}</p>
</div>
</c:if>

<a href="/index.jsp">${goback}</a>

</body>
</html>



