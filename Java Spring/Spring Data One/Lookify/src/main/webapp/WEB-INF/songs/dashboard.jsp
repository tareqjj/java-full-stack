<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2021
  Time: 2:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <title>Lookify!</title>
</head>
<body>
    <header>
        <a href="/songs/new">Add New</a>
        <a href="/search/topTen">Top Songs</a>
        <form action="/search" method="post">
            <p>
                <label for="artist"></label>
                <input type="text" name="artist" id="artist"/>
            </p>
            <input type="submit" value="Search Artists"/>
        </form>
    </header>
    <main>
        <h1>All Songs</h1>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Rating</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${songs}" var="song">
                <tr>
                    <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
                    <td><c:out value="${song.rating}"/></td>
                    <td>
                    <span class="delete">
                        <form action="/songs/${song.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <button type="submit" value="delete">delete</button>
                        </form>
                    </span>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>
</body>
</html>
