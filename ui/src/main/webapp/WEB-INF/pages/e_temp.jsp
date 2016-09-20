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
    <title>ExerciseTemplate</title>
</head>
<spring:url value="/p_temp" var="programTemplateUrl" />
<spring:url value="/e_temp" var="exerciseTemplateUrl" />
<body>
<div id="wrap">
    <div id="header">
        <a id="home" href="<c:url value="/welcome"/>">HOME</a>
        <a href="<c:url value="/p_temp_list"/>">PROGRAM TEMPLATES</a>
        <a href="<c:url value="/e_temp_list"/>">EXERCISE TEMPLATES</a>
    </div>
    <div id="main">
        <c:choose>
            <c:when test="${edit}">
                <form:form method="post" action="${exerciseTemplateUrl}/${exerciseTemplate.id}/edit" commandName="exerciseTemplate">
                    <table>
                        <tr>
                            <td colspan="2" align="center">Edit ExerciseTemplate:</td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="name">
                                    Name
                                </form:label>
                            </td>
                            <td>
                                <form:input path="name"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="description">
                                    Description
                                </form:label>
                            </td>
                            <td>
                                <form:textarea path="description"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="note">
                                    Note
                                </form:label>
                            </td>
                            <td>
                                <form:textarea path="note"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Save"/></td>
                        </tr>
                    </table>
                </form:form>
            </c:when>
            <c:otherwise>
                <h1>${exerciseTemplate.name}</h1>
                <h2>Description: ${exerciseTemplate.description}</h2>
                <h2>Note: ${exerciseTemplate.note}</h2>
                <form method="post" action="${exerciseTemplateUrl}/${exerciseTemplate.id}/edit_form">
                    <input type="submit" value="Edit"/>
                </form>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${!empty programTemplateList}">
                <table class="data">
                    <tr>
                        <td colspan="2" align="center">ExerciseTemplate "${exerciseTemplate.name}" is bound to ProgramTemplates:</td>
                    </tr>
                    <tr>
                        <th>Name</th>
                    </tr>
                    <c:forEach items="${programTemplateList}" var="programTemplate">
                        <tr>
                            <td><a href="${programTemplateUrl}/${programTemplate.id}">${programTemplate.name}</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <a>This ExerciseTemplate isn't used in any ProgramTemplate</a>
                <br />
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div id="footer">
    <a>TEST VERSION</a>
</div>


</body>
</html>
