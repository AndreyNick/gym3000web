<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="message.gym3000_title"/></title>
</head>
<body>
<div id="wrap">
    <div id="header">
        <span id="links">
            <a href="<c:url value="/welcome"/>"><spring:message code="message.home"/></a>
            <a href="<c:url value="/p_temp_list"/>"><spring:message code="message.program_templates"/></a>
            <a href="<c:url value="/e_temp_list"/>"><spring:message code="message.exercise_templates"/></a>
        </span>
        <span id="lang">
            <a href="?lang=en"><spring:message code="message.language_en"/></a>
            |
            <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
        </span>
    </div>
    <div id="main">
        <h1>${exercise.name}</h1>
        <h2><spring:message code="message.description"/>: ${exercise.description}</h2>
        <h2><spring:message code="message.name"/>: ${exercise.note}</h2>

        <h2><spring:message code="message.programs"/>: <a href="prog/${program.id}">${program.name}</a></h2>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
