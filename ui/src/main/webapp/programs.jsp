<%--
  Created by IntelliJ IDEA.
  User: anni0913
  Date: 23.12.2014
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Programs</title>
</head>
<body>
<h1>Programs</h1>
<table style="border-style: solid">
  <tr>
    <td>Name</td>
    <td>Description</td>
  </tr>
    <tr>
      <td>${programs}</td>
      <td>${programs}</td>
    </tr>
</table>
<br/>
<a href="add-program">New program</a>
</body>
</html>