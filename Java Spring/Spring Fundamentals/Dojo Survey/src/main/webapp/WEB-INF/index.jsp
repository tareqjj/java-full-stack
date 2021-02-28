<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/4/2021
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body{
            display: flex;
            justify-content: center;
        }
        form > label, select, textarea {
            display: block;
        }
    </style>
    <title>Dojo Survey Index</title>
</head>
<body>
    <form action="/formProcess" method="post">
        Name:<input type="text" name="name">
        <label for="location">Choose a location:</label>
        <select id="location" name="location">
            <option value="San Jose">San Jose</option>
            <option value="Ramallah">Ramallah</option>
            <option value="New York City">New York City</option>
            <option value="Poughkeepsie">Poughkeepsie</option>
        </select>
        <label for="language">Choose a language:</label>
        <select id="language" name="language">
            <option value="Python">Python</option>
            <option value="CSS">CSS</option>
            <option value="Java">Java</option>
            <option value="HTML">HTML</option>
        </select>
        <label for="comment">Comment (optional)</label>
        <textarea id="comment" name="comment"></textarea>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
