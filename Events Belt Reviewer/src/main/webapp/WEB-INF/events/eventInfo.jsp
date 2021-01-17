<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/16/2021
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        main{display: flex; justify-content: space-evenly; margin: 50px}
        .wall{border: 1px black}
    </style>
    <title><c:out value="${eventToView.name}"/></title>
</head>
<body>
    <main>
        <div>
            <h1><c:out value="${eventToView.name}"/></h1>
            <p><c:out value="${eventToView.userPlanner.firstName}"/> <c:out value="${eventToView.userPlanner.lastName}"/></p>
            <p><c:out value="${eventToView.stringDate}"/></p>
            <p><c:out value="${eventToView.location}"/></p>
            <p>People who are attending the event: <c:out value="${eventToView.usersAttendingEvents.size()}"/></p>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Location</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${eventToView.usersAttendingEvents}" var="user">
                    <tr>
                        <td><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></td>
                        <td><c:out value="${user.location}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <div class="wall">
                <h2>Message Wall</h2>
                <c:forEach items="${eventMessages}" var="message">
                        <p><c:out value="${message.userAuthor.firstName}"/> <c:out value="${message.userAuthor.lastName}"/> says: <c:out value="${message.comment}"/></p>
                        <p>----------------------</p>
                </c:forEach>
            </div>
            <div>
                <p><form:errors path="event.*"/></p>
                <form:form method="POST" action="/events/${eventToView.id}" modelAttribute="message">
                    <p>
                    <form:label path="comment" class="col-form-label">Add Comment:</form:label>
                    <form:input path="comment" class="form-control"/>
                    </p>
                    <form:input path="userAuthor" type="hidden" value="${loggedUser.id}"/>
                    <form:input path="event" type="hidden" value="${eventToView.id}"/>
                    <input type="submit" value="Submit" class="btn btn-success"/>
                </form:form>
            </div>
        </div>
    </main>
</body>
</html>
