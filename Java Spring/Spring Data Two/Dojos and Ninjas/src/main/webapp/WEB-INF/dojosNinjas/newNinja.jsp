<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2021
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New License</title>
</head>
<body>
<h1>New License</h1>
    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
        <p>
            <form:label path="dojo">Dojo:</form:label>
            <form:errors path="dojo"/>
            <form:select path="dojo">
            <c:forEach var="dojo" items="${dojos}">
                <form:option value="${dojo.id}" label= "${dojo.name}"/>
            </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="firstName">First Name:</form:label>
            <form:errors path="firstName"/>
            <form:input path="firstName"/>
        </p>
        <p>
            <form:label path="lastName">Last Name:</form:label>
            <form:errors path="lastName"/>
            <form:input path="lastName"/>
        </p>
        <p>
            <form:label path="age">Age:</form:label>
            <form:errors path="age"/>
            <form:input type="number" path="age"/>
        </p>
        <input type="submit" value="Create">
    </form:form>
</body>
</html>
