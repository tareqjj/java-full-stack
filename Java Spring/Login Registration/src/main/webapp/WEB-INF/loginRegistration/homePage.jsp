<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/15/2021
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Welcome, <c:out value="${user.email}" /></h1>
<a href="/logout">Logout</a>
</body>
</html>