<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
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
        <span id="links">
            <a href="<c:url value="/home"/>"><spring:message code="message.home"/></a>
        </span>
        <span id="lang">
            <a href="<c:url value="/logout" />"><spring:message code="message.logout"/></a>
            <a href="?lang=en"><spring:message code="message.language_en"/></a>
            |
            <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
        </span>
    </div>
    <div id="main">
        <form:form method="post" action="/profile_save" commandName="user">
            <table>
                <tr>
                    <td colspan="2"><spring:message code="message.edit_user"/>:</td>
                </tr>
                <tr>
                    <td><form:label path="name"><spring:message code="message.name"/></form:label></td>
                    <td><form:input path="name"/></td>
                    <td><springForm:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><form:label path="login"><spring:message code="message.login"/></form:label></td>
                    <td><form:label path="login">${user.login}</form:label></td>
                </tr>
                <tr>
                    <td><form:label path="password"><spring:message code="message.password"/></form:label></td>
                    <td><form:textarea path="password"/></td>
                    <td><springForm:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="<spring:message code="message.save"/>"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
