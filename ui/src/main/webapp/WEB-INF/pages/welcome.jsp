<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>gym3000</title>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
</head>
<body>
<div id="wrap">
    <div id="header">
        <a id="home" href="<c:url value="/welcome"/>"><spring:message code="message.home"/></a>
        <span id="lang">
            <a href="?lang=en">EN</a>
            |
            <a href="?lang=ru">RU</a>
        </span>
    </div>
    <div id="main">
        <h1><spring:message code="message.list_of_links"/></h1>
        <h3><a href="<c:url value="/p_temp_list"/>">Program Templates List</a></h3>
        <h3><a href="<c:url value="/e_temp_list"/>">Exercise Templates List</a></h3>
        <h3><a href="<c:url value="/prog_list"/>">Programs List</a></h3>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
