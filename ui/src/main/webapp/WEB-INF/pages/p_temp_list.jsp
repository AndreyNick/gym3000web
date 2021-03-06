<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="message.gym3000_title"/></title>
</head>
<body>
<div id="wrap">
    <div id="header">
        <jsp:include page="additionalPages/homeLangHeader.jsp"/>
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
                            <sec:authorize access="hasRole('ADMIN')">
                                <td>
                                    <a href="p_temp_list/delete/${programTemplate.id}">
                                        <spring:message code="message.delete"/></a>
                                </td>
                            </sec:authorize>
                            <td><a href="p_temp_list/create_program/${programTemplate.id}"><spring:message
                                    code="message.create_program"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <span class="text">
                    <a><br/><spring:message code="message.no_program_templates"/></a>
                </span>
            </c:otherwise>
        </c:choose>

        <sec:authorize access="hasRole('ADMIN')">
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
                        <td><springForm:errors path="name" cssClass="error"/></td>
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
                        <td><springForm:errors path="description" cssClass="error"/></td>
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
                        <td><springForm:errors path="note" cssClass="error"/></td>
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
    <jsp:include page="additionalPages/footer.jsp"/>
</div>

</body>
</html>
