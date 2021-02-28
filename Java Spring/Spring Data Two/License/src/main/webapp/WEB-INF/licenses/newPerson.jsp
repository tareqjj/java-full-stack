<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2021
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New Person</title>
</head>
<body>
    <h1>New Person</h1>
    <form:form action="/persons/new" method="post" modelAttribute="person">
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
        <input type="submit" value="Create">
    </form:form>
</body>
</html>
