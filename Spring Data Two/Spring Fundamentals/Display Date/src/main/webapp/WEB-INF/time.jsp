<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 3:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/timeStyle.css">
    <script type="text/javascript" src="js/timeApp.js"></script>
    <title>TimeTemplate</title>
</head>
<body>
    <h1><c:out value="${time}"/></h1>
</body>
</html>
