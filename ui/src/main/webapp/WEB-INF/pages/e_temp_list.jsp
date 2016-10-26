<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <a href="<c:url value="/home"/>"><spring:message code="message.home"/></a>
        </span>
        <span id="lang">
            <a href="<c:url value="/user"/>">${user.name}</a>
            <a href="?lang=en"><spring:message code="message.language_en"/></a>
            |
            <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
        </span>
    </div>
    <div id="main">
        <h1><spring:message code="message.exercise_templates"/></h1>
        <c:choose>
            <c:when test="${!empty exerciseTemplateList}">
                <table class="data">
                    <tr>
                        <td colspan="5"><spring:message code="message.exercise_templates_list"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.name"/></th>
                        <th><spring:message code="message.description"/></th>
                        <th><spring:message code="message.note"/></th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${exerciseTemplateList}" var="exerciseTemplate">
                        <tr>
                            <td><a href="e_temp/${exerciseTemplate.id}">${exerciseTemplate.name}</a></td>
                            <td>${exerciseTemplate.description}</td>
                            <td>${exerciseTemplate.note}</td>
                            <sec:authorize access="hasRole('ADMIN')">
                                <td>
                                    <a href="e_temp_list/delete/${exerciseTemplate.id}">
                                        <spring:message code="message.delete"/></a>
                                </td>
                            </sec:authorize>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <span class="text">
                    <a><br /><spring:message code="message.no_exercise_templates"/></a>
                </span>
            </c:otherwise>
        </c:choose>
        <sec:authorize access="hasRole('ADMIN')">
            <form:form method="post" action="e_temp_list/add" commandName="exerciseTemplate">
                <table>
                    <tr>
                        <td colspan="2" align="center"><spring:message code="message.add_exercise_template"/></td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="name">
                                <spring:message code="message.name"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="name"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="description">
                                <spring:message code="message.description"/>
                            </form:label>
                        </td>
                        <td>
                            <form:textarea path="description"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="note">
                                <spring:message code="message.note"/>
                            </form:label>
                        </td>
                        <td>
                            <form:textarea path="note"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="<spring:message code="message.add"/>"/></td>
                    </tr>
                </table>
            </form:form>
        </sec:authorize>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
