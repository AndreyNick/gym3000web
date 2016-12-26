<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="message.gym3000_title"/></title>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
    <div id="header">
        <div id="items">
            <span id="lang">
                <a href="<c:url value="/profile"/>">${user.name}</a>
                <a href="?lang=en"><spring:message code="message.language_en"/></a>
                |
                <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
            </span>
        </div>
    </div>
    <div id="main">

        <c:if test="${param.error != null}">
            <p><spring:message code="error.invalid_login_and_password"/></p>
        </c:if>

        <c:if test="${param.logout != null}">
            <p><spring:message code="message.logout_success"/></p>
        </c:if>

        <form:form method="post" action="/login">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <table class="data">
                <tr><td colspan="2"><spring:message code="message.enter_login_and_password"/>:</td></tr>
                <tr>
                    <td><label for="username"><spring:message code="message.login"/></label></td>
                    <td><input type="text" id="username" name="ssoId" placeholder="<spring:message code="message.enter_login"/>" required></td>
                </tr>
                <tr>
                    <td><label for="password"><spring:message code="message.password"/></label></td>
                    <td><input type="password" id="password" name="password" placeholder="<spring:message code="message.enter_password"/>" required></td>
                </tr>
                <tr><td colspan="2"><label><input type="checkbox" id="rememberme" name="remember-me"><spring:message code="message.remember_me"/></label></td></tr>
                <tr>
                    <td colspan="2"><input type="submit" value="<spring:message code="message.log_in"/>"></td>
                </tr>
            </table>
        </form:form>

        <a href="<c:url value="/register"/>"><spring:message code="message.registration"/></a>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
