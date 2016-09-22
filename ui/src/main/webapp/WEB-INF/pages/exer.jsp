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
        <h1>${exercise.name}</h1>
        <h4>${exercise.description}</h4>
        <h4>${exercise.note}</h4>

        <form:form method="post" action="exer/add" commandName="exercise">
            <table>
                <tr>
                    <td><form:label path="name">
                        name
                    </form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="add"/></td>
                </tr>
            </table>
        </form:form>

        <c:if test="${!empty exerciseList}">
            <table class="data">
                <tr>
                    <th>name</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${exerciseList}" var="exercise">
                    <tr>
                        <td>${exercise.name}</td>
                        <td><a href="exer/delete/${exercise.id}">delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
<div id="footer">
    <a>TEST VERSION</a>
</div>

</body>
</html>
