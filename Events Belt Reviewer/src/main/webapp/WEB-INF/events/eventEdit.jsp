<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/16/2021
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>Edit Event</title>
</head>
<body style="margin: 30%">
    <h1><c:out value="${eventToEdit.name}"/></h1>
    <p><form:errors path="event.*"/></p>
    <form:form method="POST" action="/events/${eventToEdit.id}/edit" modelAttribute="event">
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
        <form:input path="userPlanner" type="hidden" value="${eventToEdit.userPlanner.id}"/>
        <input type="submit" value="Edit" class="btn btn-primary"/>
    </form:form>
</body>
</html>
