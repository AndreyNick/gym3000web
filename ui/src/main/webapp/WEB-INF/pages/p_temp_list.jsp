<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <h1><spring:message code="message.program_templates"/></h1>

        <c:choose>
            <c:when test="${!empty programTemplateList}">
                <table class="data">
                    <tr>
                        <td colspan="5" align="center"><spring:message code="message.program_templates_list"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.name"/></th>
                        <th><spring:message code="message.description"/></th>
                        <th><spring:message code="message.note"/></th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${programTemplateList}" var="programTemplate">
                        <tr>
                            <td><a href="p_temp/${programTemplate.id}">${programTemplate.name}</a></td>
                            <td>${programTemplate.description}</td>
                            <td>${programTemplate.note}</td>
                            <td><a href="p_temp_list/delete/${programTemplate.id}"><spring:message code="message.delete"/></a></td>
                            <td><a href="p_temp_list/create_program/${programTemplate.id}"><spring:message code="message.create_program"/></a></td>
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
                <a><spring:message code="message.no_program_templates"/><br /><spring:message code="message.you_can_add_them"/></a>
                <br />
            </c:otherwise>
        </c:choose>

        <form:form method="post" action="p_temp_list/add" commandName="programTemplate">
            <table>
                <tr>
                    <td colspan="2" align="center"><spring:message code="message.add_program_template"/></td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="name">
                            <spring:message code="message.name"/>
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:input path="name"/>
                    </td>
                    <td><springForm:errors path="name" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="description">
                            <spring:message code="message.description"/>
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:textarea path="description"/>
                    </td>
                    <td><springForm:errors path="description" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="note">
                            <spring:message code="message.note"/>
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:textarea path="note"/>
                    </td>
                    <td><springForm:errors path="note" cssClass="error" /></td>
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
