<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/5/2021
  Time: 1:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>debtors prison</title>
</head>
<body>
    <h1>You are in debtors prison with a balance due of  <%=session.getAttribute("gold")%> gold!</h1>
    <p>
        <form action="/findGold" method="post">
            <input type="hidden" name="whichForm" value="newGame">
            <input type="submit" value="Play again!">
        </form>
    </p>
</body>
</html>
