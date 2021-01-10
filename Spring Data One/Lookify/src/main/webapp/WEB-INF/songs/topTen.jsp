<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2021
  Time: 4:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Top Ten Songs</title>
</head>
<body>
    <main>
        <h1>Top Ten Songs</h1>
        <a href="/dashboard">Dashboard</a>
        <c:forEach items="${topTen}" var="song">
        <p><c:out value="${song.rating}"/> <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> <c:out value="${song.artist}"/></p>
        </c:forEach>
    </main>
</body>
</html>
