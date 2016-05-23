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


<c:if test="${!empty program_templates_list}">
    <table class="data">
        <tr>
            <th>name</th>
            <th>exercise templates list</th>
        </tr>
        <c:forEach items="${program_templates_list}" var="program_template">
            <tr>
                <td>${program_template.name}</td>
                <td>${program_template.exerciseTemplateList}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
