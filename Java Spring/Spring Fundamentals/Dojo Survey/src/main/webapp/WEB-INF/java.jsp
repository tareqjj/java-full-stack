<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dojo Survey Index</title>
</head>
<body>
    <h1>Java Submitted Info</h1>
    <p>Name: <%=session.getAttribute("name")%></p>
    <p>Location: <%=session.getAttribute("location")%></p>
    <p>Language: <%=session.getAttribute("language")%></p>
    <p>Comment: <%=session.getAttribute("comment")%></p>
    <a href="/">Go Back</a>
</body>
</html>

