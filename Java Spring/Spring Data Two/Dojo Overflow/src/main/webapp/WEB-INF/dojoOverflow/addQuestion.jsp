<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/12/2021
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>New Question</title>
</head>
<body>
    <h1>What is your question?</h1>
    <form:form action="/addQuestion" method="post" modelAttribute="questions">
        <p>
            <form:label path="question">Question:</form:label>
            <form:errors path="question"/>
            <form:textarea path="question"/>
        </p>
        <form:form action="/addQuestion" method="post" modelAttribute="tags">
            <p>
                <form:label path="subject">Subject:</form:label>
                <form:errors path="subject"/>
                <form:input path="subject"/>
            </p>
        <input type="submit" value="Submit"/>
        </form:form>
    </form:form>
</body>
</html>
