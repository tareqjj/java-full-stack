<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/8/2021
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>Language Show Page</title>
</head>
<body>
    <a href="/languages">Dashboard</a>
    <h1><c:out value="${language.name}"/></h1>
    <p>Creator: <c:out value="${language.creator}"/></p>
    <p>Version: <c:out value="${language.version}"/></p>
    <a href="/languages/${language.id}/edit">Edit</a>
    <form class="delete" action="/languages/${language.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <button type="submit" value="Delete">Delete</button>
    </form>
</body>
</html>
