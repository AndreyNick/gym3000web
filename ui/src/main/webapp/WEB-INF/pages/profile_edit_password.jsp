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
        <form:form method="post" action="/profile_save_password" commandName="user">
            <table>
                <tr>
                    <td colspan="2">Edit password:</td>
                </tr>
                <tr>
                    <td><label>Current password:</label></td>
                    <td><form:input path="previousPassword" type="password"/></td>
                    <td><springForm:errors path="previousPassword" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>New password:</label></td>
                    <td><form:input path="password" type="password"/></td>
                    <td><springForm:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>New password again:</label></td>
                    <td><form:input path="confirmPassword" type="password"/></td>
                    <td><springForm:errors path="confirmPassword" cssClass="error"/></td>
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
