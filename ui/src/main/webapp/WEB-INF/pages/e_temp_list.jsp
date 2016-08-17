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
    <title>Exercise Templates</title>
</head>
<body>
<div class="header">
    <a class="home" href="<c:url value="/welcome"/>">HOME</a>
</div>
<div class="main">
<h1>Exercise Templates</h1>

    <c:choose>
        <c:when test="${!empty exerciseTemplateList}">
            <table class="data">
                <tr>
                    <td colspan="5">List of programs</td>
                </tr>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Note</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach items="${exerciseTemplateList}" var="exerciseTemplate">
                    <tr>
                        <td><a href="e_temp/${exerciseTemplate.id}">${exerciseTemplate.name}</a></td>
                        <td>${exerciseTemplate.description}</td>
                        <td>${exerciseTemplate.note}</td>
                        <td><a href="e_temp_list/delete/${exerciseTemplate.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <a>There is no Exercise Templates<br />You can add teb below:</a>
            <br />
        </c:otherwise>
    </c:choose>

<form:form method="post" action="e_temp_list/add" commandName="exerciseTemplate">
    <table>
        <tr>
            <td colspan="2" align="center">Add Exercise Template:</td>
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
                <form:input path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="note">
                    Note
                </form:label>
            </td>
            <td>
                <form:input path="note"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form:form>
</div>
<div class="footer">
    <a>TEST VERSION</a>
</div>


</body>
</html>
