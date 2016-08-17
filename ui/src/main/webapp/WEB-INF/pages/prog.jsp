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
<spring:url value="/e_temp" var="exerciseTemplateUrl" />
<body>
<div class="header">
    <a class="home" href="<c:url value="/welcome"/>">HOME</a>
    <a href="<c:url value="/prog_list"/>">PROGRAMS</a>
</div>
<div class="main">
<h1>${program.name}</h1>

    <h4>${program.description}</h4>
    <h4>${program.note}</h4>

    <c:choose>
        <c:when test="${!empty exerciseList}">
            <table class="data">
                <tr>
                    <td align="center">Exercise List:</td>
                </tr>
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
        </c:when>
        <c:otherwise>
            <a>There is no Exercises in this programs yet<br />You can add</a>
            <br />
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${!empty exerciseTemplateListAll}">
            <table class="data">
                <tr>
                    <td align="center">All Exercise Templates List:</td>
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
        </c:when>
        <c:otherwise>
            <a>There is no ExerciseTemplates in DB<br />You can add them <a href="<c:url value="/e_temp_list"/>">here</a></a>
            <br />
        </c:otherwise>
    </c:choose>
</div>
<div class="footer">
    <a>TEST VERSION</a>
</div>
</body>
</html>
