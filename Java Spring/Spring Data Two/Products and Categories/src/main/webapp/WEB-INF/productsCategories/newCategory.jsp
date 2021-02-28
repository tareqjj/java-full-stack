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
    <title>New Category</title>
</head>
<body>
    <h1>New Category</h1>
    <form:form action="/categories/new" method="post" modelAttribute="category">
        <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <input type="submit" value="Create">
    </form:form>
</body>
</html>
