<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/17/2021
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>New Show</title>
</head>
<body>
    <main>
        <div style="width: 30%">
            <h2>Create a Show</h2>
            <p><form:errors path="show.*"/></p>
            <form:form method="POST" action="/shows/new" modelAttribute="show">
                <p>
                    <form:label path="title" class="col-form-label">Title:</form:label>
                    <form:input path="title" class="form-control"/>
                </p>

                <p>
                    <form:label path="network" class="col-form-label">Network:</form:label>
                    <form:input path="network" class="form-control"/>
                </p>
                <form:input path="user" type="hidden" value="${loggedUser.id}"/>
                <input type="submit" value="Create" class="btn btn-warning"/>
            </form:form>
        </div>
    </main>
</body>
</html>
