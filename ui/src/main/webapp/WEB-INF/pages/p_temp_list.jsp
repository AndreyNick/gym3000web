<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title>ProgramTemplates</title>
</head>
<body>
<div id="wrap">
    <div id="header">
        <a id="home" href="<c:url value="/welcome"/>">HOME</a>
    </div>
    <div id="main">
        <h1>ProgramTemplates</h1>

        <c:choose>
            <c:when test="${!empty programTemplateList}">
                <table class="data">
                    <tr>
                        <td colspan="5" align="center">Program Templates List:</td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Note</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${programTemplateList}" var="programTemplate">
                        <tr>
                            <td><a href="p_temp/${programTemplate.id}">${programTemplate.name}</a></td>
                            <td>${programTemplate.description}</td>
                            <td>${programTemplate.note}</td>
                            <td><a href="p_temp_list/delete/${programTemplate.id}">Delete</a></td>
                            <td><a href="p_temp_list/create_program/${programTemplate.id}">Create Program</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <a>There is no ProgramTemplates<br />You can add teb below:</a>
                <br />
            </c:otherwise>
        </c:choose>

        <form:form method="post" action="p_temp_list/add" commandName="programTemplate">
            <table>
                <tr>
                    <td colspan="2" align="center">Add ProgramTemplate:</td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="name">
                            Name
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:input path="name"/>
                    </td>
                    <td><springForm:errors path="name" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="description">
                            Description
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:textarea path="description"/>
                    </td>
                    <td><springForm:errors path="description" cssClass="error" /></td>
                </tr>
                <tr>
                    <td>
                        <springForm:label path="note">
                            Note
                        </springForm:label>
                    </td>
                    <td>
                        <springForm:textarea path="note"/>
                    </td>
                    <td><springForm:errors path="note" cssClass="error" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Add new ProgramTemplate"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
<div id="footer">
    <a>TEST VERSION</a>
</div>

</body>
</html>
