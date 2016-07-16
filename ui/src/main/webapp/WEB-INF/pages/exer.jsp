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
    <title>Exercise</title>
</head>
<body>
<h2>Exercise</h2>


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

</body>
</html>
