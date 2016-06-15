<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Exercise Template</title>
</head>
<body>
<h2>${exerciseTemplate.name}</h2>
<h3><a href="/p_temp_list">Program Templates list</a> <a href="/e_temp_list">Exercise Templates list</a></h3>


<spring:url value="/p_temp" var="programTemplateUrl" />

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


</body>
</html>
