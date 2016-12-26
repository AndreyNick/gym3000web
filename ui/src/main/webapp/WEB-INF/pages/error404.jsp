<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><spring:message code="message.gym3000_title"/></title>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
    <div id="header">
        <div id="items">
            <span id="links">
                <a href="<c:url value="/home"/>"><spring:message code="message.home"/></a>
            </span>
            <span id="lang">
                <a href="<c:url value="/profile"/>">${user.name}</a>
                <a href="?lang=en"><spring:message code="message.language_en"/></a>
                |
                <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
            </span>
        </div>
    </div>
    <div id="main">
        <h1><spring:message code="message.no_such_page"/></h1>

        <h2><spring:message code="message.back_home_page"/></h2>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
