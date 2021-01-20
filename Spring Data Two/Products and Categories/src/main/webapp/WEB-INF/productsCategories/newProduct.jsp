<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2021
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New Product</title>
</head>
<body>
<h1>New Product</h1>
    <form:form action="/products/new" method="post" modelAttribute="product">
        <p>
            <form:label path="name">Name:</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="description">Description:</form:label>
            <form:errors path="description"/>
            <form:input path="description"/>
        </p>
        <p>
            <form:label path="price">Price:</form:label>
            <form:errors path="price"/>
            <form:input path="price" />
        </p>
        <input type="submit" value="Create">
    </form:form>
</body>
</html>
