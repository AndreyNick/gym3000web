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
            <jsp:include page="additionalPages/langHeader.jsp"/>
        </div>
    </div>
    <div id="main">
        <h1><spring:message code="error.error_403"/></h1>
        <spring:message code="error.not_authorized"/>
        <a href="<c:url value="/logout" />"><spring:message code="message.login"/></a>
    </div>
</div>
<div id="footer">
    <jsp:include page="additionalPages/footer.jsp"/>
</div>
</body>
</html>
