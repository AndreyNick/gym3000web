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
        <jsp:include page="additionalPages/homeLangHeader.jsp"/>
    </div>
    <div id="main">
        <div>
            <h1><spring:message code="message.user_page"/></h1>
            <table>
                <tr>
                    <td><h2><spring:message code="message.name"/>: ${user.name}</h2></td>
                    <td><a href="<c:url value="/profile_edit_name"/>"><spring:message code="message.edit"/></a></td>
                </tr>
                <tr>
                    <td><h2><spring:message code="message.login"/>: ${user.login}</h2></td>
                    <td><a href="<c:url value="/profile_edit_login"/>"><spring:message code="message.edit"/></a></td>
                </tr>
                <tr>
                    <td colspan="2"><a href="<c:url value="/profile_edit_password"/>">
                        <spring:message code="message.edit_password"/></a></td>
                </tr>
                <tr>
                    <td colspan="2"><a href="<c:url value="/logout" />">
                        <spring:message code="message.logout"/></a></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div id="footer">
    <jsp:include page="additionalPages/footer.jsp"/>
</div>
</body>
</html>
