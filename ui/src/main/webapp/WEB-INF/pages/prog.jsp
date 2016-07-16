<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link href="<c:url value="/WEB-INF/css/main.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Program</title>
</head>
<body>
<h2>${program.name}</h2>
<spring:url value="/prog/${program.id}" var="programUrl" />
<spring:url value="/e_temp" var="exerciseTemplateUrl" />
<h3><a href="/prog_list">All programs</a></h3>

<c:if test="${!empty exerciseList}">
    <table class="data">
        <tr>
            <th>name</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${exerciseList}" var="exercise">
            <tr>
                <td>${exercise.name}</td>
                <td><a href="${programUrl}/delete/${exercise.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${!empty exerciseTemplateListAll}">
    <table class="data">
        <tr>
            <td align="center">Exercise Templates List:</td>
        </tr>
        <tr>
            <th>Name</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${exerciseTemplateListAll}" var="exerciseTemplate">
            <tr>
                <td><a href="${exerciseTemplateUrl}/${exerciseTemplate.id}">${exerciseTemplate.name}</a></td>
                <td><a href="${programUrl}/add/${exerciseTemplate.id}">Add Template</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
