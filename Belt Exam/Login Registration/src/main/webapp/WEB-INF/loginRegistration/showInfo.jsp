<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/17/2021
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Show Info</title>
</head>
<body>
    <h1><c:out value="${showToView.title}"/></h1>
    <p><c:out value="${showToView.network}"/></p>
    <a href="/shows/${showToView.id}/edit">Edit</a>
    <p>People that rated this show:</p>
    <ul>
    <c:forEach items="${userRatings}" var="user">
        <li><c:out value="${user.name}"/></li>
    </c:forEach>
    </ul>

<%--    <c:if test="${showToView.userRatings.contains(loggedUser)}">--%>
        <p><form:errors path="rate.*"/></p>
        <form:form method="POST" action="/addRating" modelAttribute="rate">
            <p>
                <form:label path="rating" class="col-form-label">Leave a Rating:</form:label>
                <form:input path="rating" class="form-control"/>
            </p>

            <form:input path="user" type="hidden" value="${loggedUser.id}"/>
            <form:input path="show" type="hidden" value="${showToView.id}"/>
            <input type="submit" value="Rate!" class="btn btn-warning"/>
        </form:form>
<%--    </c:if>--%>

</body>
</html>
