<%@ page import="by.epam.training.domain.User" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="localize" var="loc"/>
    <fmt:message bundle="${loc}" key="local.title.login" var="title"/>
    <fmt:message bundle="${loc}" key="local.ru" var="ru"/>
    <fmt:message bundle="${loc}" key="local.en" var="en"/>
    <fmt:message bundle="${loc}" key="local.greeting" var="greeting"/>
    <fmt:message bundle="${loc}" key="local.button.logout" var="logout"/>
    <title>${title}</title>
</head>
<body>

<form action="Controller" method="post">
    <input type="hidden" name="action" value="en"/>
    <input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
    <input type="submit" value="${en}"/>
</form>

<form action="Controller" method="post">
    <input type="hidden" name="action" value="ru"/>
    <input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
    <input type="submit" value="${ru}"/>
</form>

<h4>${greeting}, ${sessionScope.get("user").getLogin()} </h4>
    <form action="Controller" method="post">
        <input type="hidden" name="action" value="logout"/>
        <input type="submit" value="${logout}"/>
    </form>
</body>
</html>
