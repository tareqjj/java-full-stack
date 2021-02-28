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
    <style>
        .delete button{
            background: none!important;
            border: none;
            padding: 0!important;
            /*optional*/
            font-family: arial, sans-serif;
            /*input has OS specific font-family*/
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }
    </style>
    <title>Show Language Page</title>
</head>
<body>
    <header>
        <form class="delete" action="/languages/${language.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <button type="submit" value="Delete">Delete</button>
        </form>
        <a href="/languages">Dashboard</a>
    </header>
    <h1>Edit Language</h1>
    <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="name">Title</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </p>
        <p>
            <form:label path="creator">Description</form:label>
            <form:errors path="creator"/>
            <form:input path="creator"/>
        </p>
        <p>
            <form:label path="version">Language</form:label>
            <form:errors path="version"/>
            <form:input path="version"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
