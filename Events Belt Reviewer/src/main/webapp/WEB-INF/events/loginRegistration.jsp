<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/16/2021
  Time: 2:55 AM
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
    </style>
    <title>Login and Registration</title>
</head>
<body>
    <main>
        <div>
            <h1>Register</h1>
            <p><form:errors path="user.*"/></p>
            <form:form method="POST" action="/registration" modelAttribute="user">
                <p>
                    <form:label path="firstName" class="col-form-label">First Name:</form:label>
                    <form:input path="firstName" class="form-control"/>
                </p>
                <p>
                    <form:label path="lastName" class="col-form-label">Last Name:</form:label>
                    <form:input path="lastName" class="form-control"/>
                </p>
                <p>
                    <form:label path="email" class="col-form-label">Email:</form:label>
                    <form:input type="email" path="email" class="form-control"/>
                </p>
                <p>
                    <form:label path="location" class="col-form-label">Location:</form:label>
                    <form:input path="location" class="form-control"/>
                    <br>
                    <form:select path="state" class="form-select">
                        <c:forEach items="${states}" var="state">
                            <form:option value="${state}" label= "${state}"/>
                        </c:forEach>
                    </form:select>
                </p>
                <p>
                    <form:label path="password" class="col-form-label">Password:</form:label>
                    <form:password path="password" class="form-control"/>
                </p>
                <p>
                    <form:label path="passwordConfirmation" class="col-form-label">Password Confirmation:</form:label>
                    <form:password path="passwordConfirmation" class="form-control"/>
                </p>
                <input type="submit" value="Register!" class="btn btn-success"/>
            </form:form>
        </div>
        <div>
            <h1>Login</h1>
            <p><c:out value="${error}" /></p>
            <form method="post" action="/login">
                <p>
                    <label for="email" class="col-form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control"/>
                </p>
                <p>
                    <label for="password" class="col-form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control"/>
                </p>
                <input type="submit" value="Login!" class="btn btn-primary"/>
            </form>
        </div>
    </main>
</body>
</html>
