<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="localize" var="loc"/>
    <fmt:message bundle="${loc}" key="local.title.login" var="title"/>
    <fmt:message bundle="${loc}" key="local.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.submit" var="submit"/>
    <fmt:message bundle="${loc}" key="local.register" var="register"/>
    <fmt:message bundle="${loc}" key="local.ru" var="ru"/>
    <fmt:message bundle="${loc}" key="local.en" var="en"/>
    <fmt:message bundle="${loc}" key="local.error.message" var="message"/>

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



  <div id="login-form">
    <h1>${login}</h1>
    <fieldset>
      <form action="Controller" method="post">
        <input type="hidden" name="action" value="login"/>
        <input type="hidden" name="page" value="${pageContext.request.requestURI}"/>
        <input type="email" name="login" placeholder="${login}"><br>
        <input type="password" name="password" placeholder="${password}"><br>
        <input type="submit" value="${submit}"><br>
        <a class="info" href="Registration">${register}</a>
      </form>
    </fieldset>
  </div>

  <c:if test="${requestScope.error != null}">
    <div class="error">
      <h4>${message}</h4>
      <p>${requestScope.error}</p>
    </div>
  </c:if>


  </body>
</html>
