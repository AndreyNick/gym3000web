<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <h1><spring:message code="message.list_of_links"/></h1>

        <h3><a href="<c:url value="/p_temp_list"/>"><spring:message code="message.program_templates_list"/></a></h3>

        <h3><a href="<c:url value="/e_temp_list"/>"><spring:message code="message.exercise_templates_list"/></a></h3>

        <h3><a href="<c:url value="/prog_list"/>"><spring:message code="message.programs_list"/></a></h3>
        <sec:authorize access="hasRole('ADMIN')">
            <h3><a href="<c:url value="/users"/>"><spring:message code="message.list_users"/></a></h3>
        </sec:authorize>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
