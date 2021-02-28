<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/4/2021
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current visit count</title>
</head>
<body>
    <p>You have visited <a href="/">this server</a> <c:out value="${counter}"/> times.</p>
    <a href="/">Test another visit?</a>
</body>
</html>
