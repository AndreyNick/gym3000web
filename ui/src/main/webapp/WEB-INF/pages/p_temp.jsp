<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Program Template</title>
</head>
<body>
<h2>${programTemplate.name}</h2>
<h3><a href="/p_temp_list">Program Templates list</a> <a href="/e_temp_list">Exercise Templates list</a></h3>


<c:if test="${!empty exerciseTemplateList}">
    <table class="data">
        <tr>
            <td colspan="2" align="center">${programTemplate.name}</td>
        </tr>
        <tr>
            <th>Name</th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${exerciseTemplateList}" var="exerciseTemplate">
            <tr>
                <td>${exerciseTemplate.name}</td>
                <td><a href="p_temp/unbind/?e=${exerciseTemplate.id},p=${programTemplate.id}">Unbind</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<form method="post" action="p_temp/bind/${programTemplate.id}/">
    /*action="p_temp/bind/${programTemplate.id}"*/
    <table>
        <tr>
            <td colspan="2" align="center">Bind Exercise Template</td>
        </tr>
        <tr>
            <td>
                Exercise Template name
            </td>
            <td>
                <label>
                    <select name="id">
                        <c:forEach items="${exerciseTemplateListAll}" var="exerciseTemplate">
                            <option value="${exerciseTemplate.id}">${exerciseTemplate.name}</option>
                        </c:forEach>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Bind"/></td>
        </tr>
    </table>
</form>



</body>
</html>
