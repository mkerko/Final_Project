<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="localize" var="loc"/>
    <fmt:message bundle="${loc}" key="local.title.login" var="title"/>
    <fmt:message bundle="${loc}" key="local.book" var="book"/>
    <fmt:message bundle="${loc}" key="local.checkIn" var="checkIn"/>
    <fmt:message bundle="${loc}" key="local.checkOut" var="checkOut"/>
    <fmt:message bundle="${loc}" key="local.guestNumber" var="guestNumber"/>
    <fmt:message bundle="${loc}" key="local.ru" var="ru"/>
    <fmt:message bundle="${loc}" key="local.en" var="en"/>
    <fmt:message bundle="${loc}" key="local.greeting" var="greeting"/>
    <fmt:message bundle="${loc}" key="local.button.logout" var="logout"/>
    <fmt:message bundle="${loc}" key="local.error.message" var="message"/>
    <fmt:message bundle="${loc}" key="local.button.goback" var="goback"/>
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

    <h4>${greeting}, ${sessionScope.get("user").getLogin()}</h4>
        <form action="Controller" method="post">
            <input type="hidden" name="action" value="logout"/>
            <input type="submit" value="${logout}"/>
        </form>

    <h1>${book}</h1>

    <form action="Controller" method="post">

        <input type="hidden" name="action" value="reservation"/>
        <input type="hidden" name="page" value="${pageContext.request.requestURI}"/>

        <label>${checkIn} : </label><input type="date" name="startDate"><br>
        <label>${checkOut} : </label><input type="date" name="endDate"><br>
        <label>${guestNumber} : </label><input type="number" name="guestNumber"><br>
        <input type="hidden" name="roomID" value="1"><br>
        <input type="hidden" name="userID" value="${sessionScope.get("user").getID()}">
        <input type="submit" value="${book}"/>
        <br>

    </form>

    <c:if test="${requestScope.error != null}">
        <div>
            <h4>${message}</h4>
            <p>${requestScope.error}</p>
        </div>
    </c:if>




</body>
</html>
