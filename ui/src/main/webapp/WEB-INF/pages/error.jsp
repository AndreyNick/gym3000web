<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Error</title>
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
</head>
<body>
<div id="wrap">
    <div id="header">
        <a id="home" href="<c:url value="/welcome"/>">HOME</a>
        <a id="sign_in">SIGN IN</a>
        <a id="sign_out">SIGN OUT</a>
    </div>
    <div id="main">
        <h1>There is no such page</h1>
        <h2>You can back HOME page</h2>
    </div>
</div>
<div id="footer">
    <a>TEST VERSION</a>
</div>
</body>
</html>
