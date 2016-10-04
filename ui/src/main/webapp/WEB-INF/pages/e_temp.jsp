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
<spring:url value="/p_temp" var="programTemplateUrl" />
<spring:url value="/e_temp" var="exerciseTemplateUrl" />
<body>
<div id="wrap">
    <div id="header">
        <span id="links">
            <a href="<c:url value="/home/${sessionScope.user.id}"/>"><spring:message code="message.home"/></a>
            <a href="<c:url value="/p_temp_list"/>"><spring:message code="message.program_templates"/></a>
            <a href="<c:url value="/e_temp_list"/>"><spring:message code="message.exercise_templates"/></a>
        </span>
        <span id="lang">
            <a href="${pageContext.request.contextPath}/users">${sessionScope.user.name}</a>
            <a href="?lang=en"><spring:message code="message.language_en"/></a>
            |
            <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
        </span>
    </div>
    <div id="main">
        <c:choose>
            <c:when test="${edit}">
                <form:form method="post" action="${exerciseTemplateUrl}/${exerciseTemplate.id}/edit" commandName="exerciseTemplate">
                    <table>
                        <tr>
                            <td colspan="2" align="center"><spring:message code="message.edit_exercise_template"/></td>
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
                            <td colspan="2"><input type="submit" value="<spring:message code="message.save"/>"/></td>
                        </tr>
                    </table>
                </form:form>
            </c:when>
            <c:otherwise>
                <h1>${exerciseTemplate.name}</h1>
                <h2><spring:message code="message.description"/>: ${exerciseTemplate.description}</h2>
                <h2><spring:message code="message.note"/>: ${exerciseTemplate.note}</h2>
                <form method="post" action="${exerciseTemplateUrl}/${exerciseTemplate.id}/edit_form">
                    <input type="submit" value="<spring:message code="message.edit"/>"/>
                </form>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${!empty programTemplateList}">
                <table class="data">
                    <tr>
                        <td colspan="2" align="center"><spring:message code="message.exercise_template_bound_program_templates"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.name"/></th>
                    </tr>
                    <c:forEach items="${programTemplateList}" var="programTemplate">
                        <tr>
                            <td><a href="${programTemplateUrl}/${programTemplate.id}">${programTemplate.name}</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <span class="text">
                    <a><spring:message code="message.exercise_template_dont_used_by_program_template"/></a>
                    <br />
                </span>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>


</body>
</html>
