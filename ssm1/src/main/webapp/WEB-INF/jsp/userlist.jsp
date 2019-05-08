<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<json:object>
    <json:property name="code" value="${code}"/>
    <json:property name="message">
        <spring:message code="${code}"/>
     </json:property>
    <json:array name="date" var="item" items="${users}">
        <json:object>
            <json:property name="id" value="${item.id}"/>
            <json:property name="name" value="${item.name}"/>
        </json:object>
    </json:array>
</json:object>
