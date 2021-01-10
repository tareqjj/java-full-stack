<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/8/2021
  Time: 2:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Show Book Page</title>
</head>
<body>
    <h1>Edit Book</h1>
    <form:form action="/books/${book.id}" method="post" modelAttribute="book">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </p>
        <p>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>
        <p>
            <form:label path="language">Language</form:label>
            <form:errors path="language"/>
            <form:input path="language"/>
        </p>
        <p>
            <form:label path="numberOfPages">Pages</form:label>
            <form:errors path="numberOfPages"/>
            <form:input type="number" path="numberOfPages"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
