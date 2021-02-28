<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2021
  Time: 3:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Song</title>
</head>
<body>
<h1>Add Song</h1>
    <form:form action="/songs/new" method="post" modelAttribute="song">
        <p>
            <form:label path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </p>
        <p>
            <form:label path="artist">Artist</form:label>
            <form:errors path="artist"/>
            <form:textarea path="artist"/>
        </p>
        <p>
            <form:label path="rating">Rating</form:label>
            <form:errors path="rating"/>
            <form:input type="number" path="rating"/>
        </p>
        <input type="submit" value="Add Song"/>
    </form:form>
</body>
</html>
