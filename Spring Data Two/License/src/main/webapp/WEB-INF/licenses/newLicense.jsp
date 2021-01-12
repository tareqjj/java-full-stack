<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/9/2021
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>New License</title>
</head>
<body>
<h1>New License</h1>
    <form:form action="/licenses/new" method="post" modelAttribute="license">
        <p>
            <form:label path="person">Person</form:label>
            <form:errors path="person"/>
            <form:select path="person">
            <c:forEach var="person" items="${persons}">
                <form:option value="${person.id}" label= "${person.firstName} ${person.lastName}"/>;
            </c:forEach>
            </form:select>
        </p>
        <p>
            <form:label path="state">State</form:label>
            <form:errors path="state"/>
            <form:input path="state"/>
        </p>
        <p>
            <form:label path="expirationDate">Expiration Date</form:label>
            <form:errors path="expirationDate"/>
            <form:input type="date" path="expirationDate"/>
        </p>
        <input type="submit" value="Create">
    </form:form>
</body>
</html>
