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
<spring:url value="/p_temp/${programTemplate.id}" var="programTemplateUrl" />
<spring:url value="/e_temp" var="exerciseTemplateUrl" />
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
        <c:choose>
            <c:when test="${edit}">
                <form:form method="post" action="${programTemplateUrl}/edit" commandName="programTemplate">
                    <table>
                        <tr>
                            <td colspan="2" align="center"><spring:message code="message.edit_program_template"/></td>
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
                <h1>${programTemplate.name}</h1>
                <h2><spring:message code="message.description"/>: ${programTemplate.description}</h2>
                <h2><spring:message code="message.note"/>: ${programTemplate.note}</h2>
                <form method="post" action="${programTemplateUrl}/edit_form">
                    <input type="submit" value="<spring:message code="message.edit"/>"/>
                </form>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${!empty exerciseTemplateList}">
                <table class="data">
                    <tr>
                        <td colspan="4" align="center"><spring:message code="message.exercise_templates_under_program_template"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.name"/></th>
                        <th><spring:message code="message.description"/></th>
                        <th><spring:message code="message.note"/></th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${exerciseTemplateList}" var="exerciseTemplate">
                        <tr>
                            <td>${exerciseTemplate.name}</td>
                            <td>${exerciseTemplate.description}</td>
                            <td>${exerciseTemplate.note}</td>
                            <td><a href="${programTemplateUrl}/unbind/${exerciseTemplate.id}"><spring:message code="message.unbind"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <a><spring:message code="message.no_exercise_templates_under_program_template"/><br /><spring:message code="message.you_can_bind_from_list"/></a>
                <br />
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${!empty exerciseTemplateListAll}">
                <table class="data">
                    <tr>
                        <td colspan="4" align="center"><spring:message code="message.all_program_templates"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.name"/></th>
                        <th><spring:message code="message.description"/></th>
                        <th><spring:message code="message.note"/></th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${exerciseTemplateListAll}" var="exerciseTemplate">
                        <tr>
                            <td><a href="${exerciseTemplateUrl}/${exerciseTemplate.id}">${exerciseTemplate.name}</a></td>
                            <td>${exerciseTemplate.description}</td>
                            <td>${exerciseTemplate.note}</td>
                            <td><a href="${programTemplateUrl}/bind/${exerciseTemplate.id}"><spring:message code="message.bind"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <a><spring:message code="message.no_exercise_templates"/><br />You can create them <a href="<c:url value="/e_temp_list"/>">here</a></a>
                <br />
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div id="footer">
    <a><spring:message code="message.test_version"/></a>
</div>
</body>
</html>
