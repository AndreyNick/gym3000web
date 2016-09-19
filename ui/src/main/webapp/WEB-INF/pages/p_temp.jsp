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
    <title>Program Template</title>
</head>
<spring:url value="/p_temp/${programTemplate.id}" var="programTemplateUrl" />
<spring:url value="/e_temp" var="exerciseTemplateUrl" />
<body>
<div id="wrap">
    <div id="header">
        <a id="home" href="<c:url value="/welcome"/>">HOME</a>
        <a href="<c:url value="/p_temp_list"/>">PROGRAM TEMPLATES</a>
        <a href="<c:url value="/e_temp_list"/>">EXERCISE TEMPLATES</a>
    </div>
    <div id="main">
        <c:choose>
            <c:when test="${edit}">
                <form:form method="post" action="${programTemplateUrl}/edit" commandName="programTemplate">
                    <table>
                        <tr>
                            <td colspan="2" align="center">Edit Program Template:</td>
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
                            <td colspan="2"><input type="submit" value="Save"/></td>
                        </tr>
                    </table>
                </form:form>
            </c:when>
            <c:otherwise>
                <h1>${programTemplate.name}</h1>
                <h4>${programTemplate.description}</h4>
                <h4>${programTemplate.note}</h4>
                <form method="post" action="${programTemplateUrl}/edit_form">
                    <input type="submit" value="Edit"/>
                </form>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${!empty exerciseTemplateList}">
                <table class="data">
                    <tr>
                        <td colspan="4" align="center">Exercise Templates List:</td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Note</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${exerciseTemplateList}" var="exerciseTemplate">
                        <tr>
                            <td>${exerciseTemplate.name}</td>
                            <td>${exerciseTemplate.description}</td>
                            <td>${exerciseTemplate.note}</td>
                            <td><a href="${programTemplateUrl}/unbind/${exerciseTemplate.id}">Unbind</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <a>There is no Exercise Templates under this Program Template<br />You can bind them from the list below:</a>
                <br />
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${!empty exerciseTemplateListAll}">
                <table class="data">
                    <tr>
                        <td colspan="4" align="center">Program Templates List:</td>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Note</th>
                        <th>&nbsp;</th>
                    </tr>
                    <c:forEach items="${exerciseTemplateListAll}" var="exerciseTemplate">
                        <tr>
                            <td><a href="${exerciseTemplateUrl}/${exerciseTemplate.id}">${exerciseTemplate.name}</a></td>
                            <td>${exerciseTemplate.description}</td>
                            <td>${exerciseTemplate.note}</td>
                            <td><a href="${programTemplateUrl}/bind/${exerciseTemplate.id}">Bind</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <a>There is no Exercise Templates in DB<br />You can create them <a href="<c:url value="/e_temp_list"/>">here</a></a>
                <br />
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div id="footer">
    <a>TEST VERSION</a>
</div>
</body>
</html>
