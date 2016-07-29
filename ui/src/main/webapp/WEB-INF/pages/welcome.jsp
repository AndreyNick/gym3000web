<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>gym3000</title>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
</head>
<body>
<div class="header">
    <a class="home">HOME</a>
    <a class="sign_in">SIGN IN</a>
    <a class="sign_out">SIGN OUT</a>
</div>
<div class="main">
    <h1>List of links</h1>
    <h3><a href="<c:url value="/p_temp_list"/>">Program Templates List</a></h3>
    <h3><a href="<c:url value="/e_temp_list"/>">Exercise Templates List</a></h3>
    <h3><a href="<c:url value="/prog_list"/>">Programs List</a></h3>
</div>
<div class="footer">
    <a>TEST VERSION</a>
</div>
</body>
</html>
