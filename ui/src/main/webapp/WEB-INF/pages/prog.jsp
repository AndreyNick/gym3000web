<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Programs</title>
<body>

<h2>Programs</h2>

<form:form method="post" action="prog/add" commandName="program">
    <table>
        <tr>
            <td>
                <form:label path="name">
                    name
                </form:label></td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="date" >
                    date
                </form:label>
            </td>
            <td>
                <fmt:formatDate value="${program.date}" pattern="dd.MM.yy" var="programDate"/>
                <form:input path="date" value="${programDate}"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="add"/></td>
        </tr>
    </table>
</form:form>

<c:if test="${!empty programList}">
    <table class="data">
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${programList}" var="program">
            <tr>
                <td>${program.name}</td>
                <td>${program.date}</td>
                <td><a href="prog/delete/${program.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
