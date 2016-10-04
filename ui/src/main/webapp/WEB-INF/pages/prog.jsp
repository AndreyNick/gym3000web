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
    <title>Program</title>
</head>
<spring:url value="/prog/${program.id}" var="programUrl" />
<spring:url value="/exer/${exercise.id}" var="exerciseUrl" />
<spring:url value="/e_temp" var="exerciseTemplateUrl" />
<body>
<div id="wrap">
    <div id="header">
        <span id="links">
            <a href="<c:url value="/home/${sessionScope.user.id}"/>"><spring:message code="message.home"/></a>
            <a href="<c:url value="/prog_list"/>"><spring:message code="message.programs"/></a>
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
                <form:form method="post" action="${programUrl}/edit" commandName="program">
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
                            <td>
                                <form:label path="date" >
                                    <spring:message code="message.date"/> (yyyy-MM-dd)
                                </form:label>
                            </td>
                            <td>
                                <fmt:formatDate value="${program.date}" pattern="yyyy-MM-dd" var="programDate"/>
                                <form:input path="date" value="${programDate}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="description">
                                    <spring:message code="message.description"/>
                                </form:label></td>
                            <td>
                                <form:textarea path="description"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="note">
                                    <spring:message code="message.note"/>
                                </form:label></td>
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
                <span>
                <h1>${program.name}</h1>
                <h2><spring:message code="message.date"/>: ${program.date}</h2>
                <h2><spring:message code="message.description"/>: ${program.description}</h2>
                <h2><spring:message code="message.note"/>: ${program.note}</h2>
                <form method="post" action="${programUrl}/edit_form">
                    <input type="submit" value="<spring:message code="message.edit"/>"/>
                </form>
                    </span>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${!empty exerciseList}">
                <table class="data">
                    <tr>
                        <td colspan="2" align="center"><spring:message code="message.exercise_list"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.name"/></th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${exerciseList}" var="exercise">
                        <tr>
                            <td><a href="/exer/${exercise.id}">${exercise.name}</a></td>
                            <td><a href="${programUrl}/delete/${exercise.id}"><spring:message code="message.delete"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <span class="text">
                    <a><spring:message code="message.no_exercises_in_program"/>
                        <br />
                        <spring:message code="message.you_can_add_them"/></a>
                    <br />
                </span>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${!empty exerciseTemplateListAll}">
                <table class="data">
                    <tr>
                        <td colspan="2" align="center"><spring:message code="message.all_exercise_templates_list"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.name"/></th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${exerciseTemplateListAll}" var="exerciseTemplate">
                        <tr>
                            <td><a href="${exerciseTemplateUrl}/${exerciseTemplate.id}">${exerciseTemplate.name}</a></td>
                            <td><a href="${programUrl}/add/${exerciseTemplate.id}"><spring:message code="message.add"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <span class="text">
                    <a><spring:message code="message.no_exercise_templates"/>
                        <br />
                        You can add them <a href="<c:url value="/e_temp_list"/>">here</a></a>
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
