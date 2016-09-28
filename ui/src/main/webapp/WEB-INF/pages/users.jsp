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
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
</head>
<body>
<div id="wrap">
    <div id="header">
        <span id="links">
            <a href="<c:url value="/users"/>"><spring:message code="message.home"/></a>
        </span>
        <span id="lang">
            <a href="?lang=en"><spring:message code="message.language_en"/></a>
            |
            <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
        </span>
    </div>
    <div id="main">
        <h1><spring:message code="message.list_users"/></h1>
        <c:if test="${!empty ownerList}">
            <table class="data">
                <tr>
                    <td colspan="5"><spring:message code="message.list_users"/></td>
                </tr>
                <tr>
                    <th><spring:message code="message.name"/></th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${ownerList}" var="owner">
                    <tr>
                        <td><a href="home/${owner.id}">${owner.name}</a></td>
                        <td><a href="users/delete/${owner.id}"><spring:message code="message.delete"/></a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

        <form:form method="post" action="users/add" commandName="owner">
            <table>
                <tr>
                    <td colspan="2"><spring:message code="message.add_program"/></td>
                </tr>
                <tr>
                    <td>
                        <form:label path="name">
                            <spring:message code="message.name"/>
                        </form:label></td>
                    <td>
                        <form:input path="name"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="<spring:message code="message.add"/>"/></td>
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