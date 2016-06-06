<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Program Templates</title>
</head>
<body>
<h2>Program Templates</h2>


<form:form method="post" action="p_temp/add" commandName="programTemplate">
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


<c:if test="${!empty programTemplateList}">
    <table class="data">
        <tr>
            <th>name</th>
            <th>exercise templates list</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${programTemplateList}" var="programTemplate">
            <tr>
                <td>${programTemplate.name}</td>
                <td>${programTemplate.exerciseTemplateList}</td>
                <td><a href="p_temp/delete/${programTemplate.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
