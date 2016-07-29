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
    <title>Exercise Template</title>
</head>
<spring:url value="/p_temp" var="programTemplateUrl" />
<body>
<div class="header">
    <a class="home" href="<c:url value="/welcome"/>">HOME</a>
    <a href="<c:url value="/p_temp_list"/>">PROGRAM TEMPLATES</a>
    <a href="<c:url value="/e_temp_list"/>">EXERCISE TEMPLATES</a>
</div>
<div class="main">
<h2>${exerciseTemplate.name}</h2>

<c:if test="${!empty programTemplateList}">
    <table class="data">
        <tr>
            <td colspan="2" align="center">This ${exerciseTemplate.name} was bind to ProgramTemplates:</td>
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
</c:if>
</div>
<div class="footer">
    <a>TEST VERSION</a>
</div>


</body>
</html>
