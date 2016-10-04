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
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="message.gym3000_title"/></title>
</head>
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
                <form:form method="post" action="/exer/${exercise.id}/edit" commandName="exercise">
                    <table>
                        <tr>
                            <td colspan="2"><spring:message code="message.edit_exercise"/></td>
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
                <h1>${exercise.name}</h1>
                <h2><spring:message code="message.program"/>: <a href="/prog/${program.id}">${program.name}</a></h2>
                <h2><spring:message code="message.description"/>: ${exercise.description}</h2>
                <h2><spring:message code="message.note"/>: ${exercise.note}</h2>
                <form method="post" action="/exer/${exercise.id}/edit_form">
                    <input type="submit" value="<spring:message code="message.edit"/>"/>
                </form>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${!empty setList}">
                <table class="data">
                    <tr>
                        <td colspan="5" align="center"><spring:message code="message.set_list"/></td>
                    </tr>
                    <tr>
                        <th><spring:message code="message.times"/></th>
                        <th><spring:message code="message.weight"/></th>
                        <th><spring:message code="message.measure"/></th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${setList}" var="set">
                        <c:choose>
                            <c:when test="${set.id == edit_set}">
                                <form:form method="post" action="/exer/${exercise.id}/edit/${set.id}" commandName="set">
                                        <tr>
                                            <td><springForm:input path="times"/></td>
                                            <td><springForm:input path="weight"/></td>
                                            <td><form:radiobutton path="measure" value="KG" /><spring:message code="message.kg"/>
                                                <form:radiobutton path="measure" value="POUND" /><spring:message code="message.pound"/></td>
                                            <td colspan="2">
                                                <input type="submit" value="<spring:message code="message.save"/>"/>
                                            </td>

                                        </tr>
                                </form:form>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td>${set.times}</td>
                                    <td>${set.weight}</td>
                                    <td>${set.measure}</td>
                                    <td><a href="/exer/${exercise.id}/delete/${set.id}"><spring:message code="message.delete"/></a></td>
                                    <td><a href="/exer/${exercise.id}/edit_form/${set.id}"><spring:message code="message.edit"/></a></td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <spring:message code="message.no_sets_here"/>
                <br />
            </c:otherwise>
        </c:choose>

        <form:form method="post" action="/exer/${exercise.id}/add" commandName="set">
            <table>
                <tr>
                    <td colspan="3" align="center"><spring:message code="message.add_set"/></td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="times">
                            <spring:message code="message.times"/>
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:input path="times"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="weight">
                            <spring:message code="message.weight"/>
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:input path="weight"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="measure">
                            <spring:message code="message.measure"/>
                        </springForm:label>
                    </td>
                    <td>
                        <form:radiobutton path="measure" value="KG" /><spring:message code="message.kg"/>
                        <form:radiobutton path="measure" value="POUND" /><spring:message code="message.pound"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="3"><input type="submit" value="<spring:message code="message.add"/>"/></td>
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
