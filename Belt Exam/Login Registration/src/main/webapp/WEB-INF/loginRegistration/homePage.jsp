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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Shows</title>
</head>
<body>
    <main>
        <header>
            <h1>Welcome, <c:out value="${user.name}" /></h1>
            <a href="/logout">Logout</a>
        </header>
        <div>
            <h2>TV Shows</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Show</th>
                    <th>Network</th>
                    <th>Avg Rating</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${shows}" var="show">
                    <tr>
                        <td><a href="/shows/${show.id}"><c:out value="${show.title}"/></a></td>
                        <td><c:out value="${show.network}"/></td>
                    <c:forEach items="${avgRating}" var="rating">
                        <td><c:out value="${rating}"/></td>
                    </c:forEach>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="/shows/new">Add a Show</a>
        </div>
    </main>

</body>
</html>