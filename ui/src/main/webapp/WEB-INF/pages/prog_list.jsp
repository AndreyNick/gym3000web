<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>Programs List</title>
<body>
<div class="header">
    <a class="home" href="<c:url value="/welcome"/>">HOME</a>
</div>
<div class="main">
<h1>Programs List</h1>
<c:if test="${!empty programList}">
    <table class="data">
        <tr>
            <td colspan="5">List of programs</td>
        </tr>
        <tr>
            <th>Name</th>
            <th>Date</th>
            <th>Description</th>
            <th>Note</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${programList}" var="program">
            <tr>
                <td><a href="prog/${program.id}">${program.name}</a></td>
                <td>${program.date}</td>
                <td>${program.description}</td>
                <td>${program.note}</td>
                <td><a href="prog_list/delete/${program.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<form:form method="post" action="prog_list/add" commandName="program">
    <table>
        <tr>
            <td colspan="2">Add program</td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    Name
                </form:label></td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="date" >
                    Date (yyyy-MM-dd)
                </form:label>
            </td>
            <td>
                <fmt:formatDate value="${program.date}" pattern="yyyy-MM-dd" var="programDate"/>
                <form:input path="date" value="${programDate}"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    Description
                </form:label></td>
            <td>
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="note">
                    Note
                </form:label></td>
            <td>
                <form:input path="note"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form:form>
    <div class="footer_place"></div>
</div>
<div class="footer">
    <a>TEST VERSION</a>
</div>
</body>
</html>
