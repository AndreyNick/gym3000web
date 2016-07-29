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
    <title>Program Templates</title>
</head>
<body>
<div class="header">
    <a class="home" href="<c:url value="/welcome"/>">HOME</a>
</div>
<div class="main">
<h1>Program Templates</h1>
<c:if test="${!empty programTemplateList}">
    <table class="data">
        <tr>
            <td colspan="2" align="center">Program Templates List:</td>
        </tr>
        <tr>
            <th>Name</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${programTemplateList}" var="programTemplate">
            <tr>
                <td><a href="p_temp/${programTemplate.id}">${programTemplate.name}</a></td>
                <td><a href="p_temp_list/delete/${programTemplate.id}">Delete</a></td>
                <td><a href="p_temp_list/create_program/${programTemplate.id}">Create Program</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form:form method="post" action="p_temp_list/add" commandName="programTemplate">
    <table>
        <tr>
            <td colspan="2" align="center">Add Program Template:</td>
        </tr>
        <tr>
            <td><form:label path="name">
                Name
            </form:label></td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="add"/></td>
        </tr>
    </table>
</form:form>
</div>
<div class="footer">
    <a>TEST VERSION</a>
</div>

</body>
</html>
