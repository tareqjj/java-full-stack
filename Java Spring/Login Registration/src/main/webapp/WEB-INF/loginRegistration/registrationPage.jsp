<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/15/2021
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
<h1>Register!</h1>

<p><form:errors path="user.*"/></p>

<form:form method="POST" action="/registration" modelAttribute="user">
    <p>
        <form:label path="email">Email:</form:label>
        <form:input type="email" path="email"/>
    </p>
    <p>
        <form:label path="password">Password:</form:label>
        <form:password path="password"/>
    </p>
    <p>
        <form:label path="passwordConfirmation">Password Confirmation:</form:label>
        <form:password path="passwordConfirmation"/>
    </p>
    <input type="submit" value="Register!"/>
</form:form>

</body>
</html>