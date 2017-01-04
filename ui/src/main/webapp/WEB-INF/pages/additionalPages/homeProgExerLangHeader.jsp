<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="items">
            <span id="links">
                <a href="<c:url value="/home"/>"><spring:message code="message.home"/></a>
                <a href="<c:url value="/p_temp_list"/>"><spring:message code="message.program_templates"/></a>
                <a href="<c:url value="/e_temp_list"/>"><spring:message code="message.exercise_templates"/></a>
            </span>
            <span id="lang">
                <a href="<c:url value="/profile"/>">${user.name}</a>
                <a href="?lang=en"><spring:message code="message.language_en"/></a>
                |
                <a href="?lang=ru"><spring:message code="message.language_ru"/></a>
            </span>
</div>