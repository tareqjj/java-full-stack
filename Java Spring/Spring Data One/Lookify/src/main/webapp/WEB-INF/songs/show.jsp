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
    <a href="/dashboard">Dashboard</a>
    <p>Title: <c:out value="${song.title}"/></p>
    <p>Artist: <c:out value="${song.artist}"/></p>
    <p>Rating (1-10): <c:out value="${song.rating}"/></p>
    <form class="delete" action="/songs/${song.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <button type="submit" value="Delete">Delete</button>
    </form>
</body>
</html>
