<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        span{color: red}
        .green{color: green}
    </style>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Ninja Gold Game</title>
</head>
<body>
<header>
    <div>
        <span>Your Gold:</span>
        <div>
            <%=session.getAttribute("gold")%>
        </div>
    </div>
    <form action="/findGold" method="post">
        <input type="hidden" name="whichForm" value="newGame">
        <input type="submit" value="Play again!">
    </form>
</header>
<main>
    <div>
        <h2>Farm</h2>
        <p>(earns 10-20 gold)</p>
        <form action="/findGold" method="post">
            <input type="hidden" name="whichForm" value="farm">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div>
        <h2>Cave</h2>
        <p>(earns 5-10 gold)</p>
        <form action="/findGold" method="post">
            <input type="hidden" name="whichForm" value="cave">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div>
        <h2>House</h2>
        <p>(earns 2-5 gold)</p>
        <form action="/findGold" method="post">
            <input type="hidden" name="whichForm" value="house">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div>
        <h2>Casino</h2>
        <p>(earns/takes 0-50 gold)</p>
        <form action="/findGold" method="post">
            <input type="hidden" name="whichForm" value="casino">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
    <div>
        <h2>Spa</h2>
        <p>(earns 5-20 gold)</p>
        <form action="/findGold" method="post">
            <input type="hidden" name="whichForm" value="spa">
            <input type="submit" value="Find Gold!">
        </form>
    </div>
</main>
<footer>
    <p>Activities:</p>
    <div class="green">
        <%=session.getAttribute("activities")%>
    </div>
</footer>
</body>
</html>
