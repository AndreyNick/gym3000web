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
    <title>Program Template</title>
</head>
<body>
<h2>${programTemplate.name}</h2>
<h3><a href="/p_temp_list">Program Templates list</a> <a href="/e_temp_list">Exercise Templates list</a></h3>


<spring:url value="/p_temp/${programTemplate.id}" var="programTemplateUrl" />
<spring:url value="/e_temp" var="exerciseTemplateUrl" />

<c:if test="${!empty exerciseTemplateList}">
    <table class="data">
        <tr>
            <td colspan="2" align="center">${programTemplate.name}:</td>
        </tr>
        <tr>
            <th>Name</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${exerciseTemplateList}" var="exerciseTemplate">
            <tr>
                <td>${exerciseTemplate.name}</td>
                <td><a href="${programTemplateUrl}/unbind/${exerciseTemplate.id}">Unbind</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${!empty exerciseTemplateListAll}">
    <table class="data">
        <tr>
            <td colspan="2" align="center">Program Templates List:</td>
        </tr>
        <tr>
            <th>Name</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${exerciseTemplateListAll}" var="exerciseTemplate">
            <tr>
                <td><a href="${exerciseTemplateUrl}/${exerciseTemplate.id}">${exerciseTemplate.name}</a></td>
                <td><a href="${programTemplateUrl}/bind/${exerciseTemplate.id}">Bind</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
