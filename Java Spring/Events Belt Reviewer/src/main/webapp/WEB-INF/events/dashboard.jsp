<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/16/2021
  Time: 3:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Events</title>
</head>
<body style="margin: 10px">
    <header>
        <h1><c:out value="${loggedUser.firstName}"/></h1>
        <a href="/logout">Logout</a>
    </header>
    <main>
        <div>
            <h2>Here are some of the events in your state:</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action / Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${inStateEvents}" var="event">
                    <tr>
                        <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
                        <td><c:out value="${event.stringDate}"/></td>
                        <td><c:out value="${event.location}"/></td>
                        <td><c:out value="${event.userPlanner.firstName}"/></td>
                        <c:choose>
                            <c:when test="${event.userPlanner.id == loggedUser.id}">
                                <td><a href="/events/${event.id}/edit">Edit</a> |
                                    <form style="display: inline" action="/destroy/${event.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input style="background: none; border: none; padding: 0;color: #3200e5;" type="submit" value="Delete">
                                    </form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${event.usersAttendingEvents.contains(loggedUser)}">
                                        <td>Joining | <a href="/cancel/${event.id}">Cancel</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="/joinEvent/${event.id}">Join</a></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <h2>Here are some of the events in your state:</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>State</th>
                    <th>Host</th>
                    <th>Action / Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${outStateEvents}" var="event">
                    <tr>
                        <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
                        <td><c:out value="${event.stringDate}"/></td>
                        <td><c:out value="${event.location}"/></td>
                        <td><c:out value="${event.state}"/></td>
                        <td><c:out value="${event.userPlanner.firstName}"/></td>
                        <c:choose>
                            <c:when test="${event.userPlanner.id == loggedUser.id}">
                                <td><a href="/events/${event.id}/edit">Edit</a> |
                                    <form style="display: inline" action="/destroy/${event.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input style="background: none; border: none; padding: 0;color: #3200e5;" type="submit" value="Delete">
                                    </form>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${event.usersAttendingEvents.contains(loggedUser)}">
                                        <td>Joining | <a href="/cancel/${event.id}">Cancel</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="/joinEvent/${event.id}">Join</a></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div style="width: 30%">
            <h2>Create an Event</h2>
            <p><form:errors path="event.*"/></p>
            <form:form method="POST" action="/createEvent" modelAttribute="event">
                <p>
                <form:label path="name" class="col-form-label">Name:</form:label>
                <form:input path="name" class="form-control"/>
                </p>
                <p>
                <form:label path="date" class="col-form-label">Date:</form:label>
                <form:input type="date" path="date" class="form-control"/>
                </p>
                <p>
                <form:label path="location" class="col-form-label">Location:</form:label>
                <form:input path="location" class="form-control"/>
                </p>
                <p>
                    <form:select path="state" class="form-select">
                        <c:forEach items="${states}" var="state">
                            <form:option value="${state}" label= "${state}"/>
                        </c:forEach>
                    </form:select>
                </p>
                <form:input path="userPlanner" type="hidden" value="${loggedUser.id}"/>
                <br>
                <input type="submit" value="Create an Event!" class="btn btn-warning"/>
            </form:form>
        </div>
    </main>
</body>
</html>
