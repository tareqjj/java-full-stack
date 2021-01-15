
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/12/2021
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question Profile</title>
</head>
<body>
    <h1><c:out value="${question.question}"/></h1>
    <h2> Tags:
        <c:forEach items="${tags}" var="tag">
            <c:out value="${tag.subject}"/>
        </c:forEach>
    </h2>
    <table>
        <thead>
        <tr>
            <th>Answers:</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${answerList}" var="answer">
            <tr>
                <td><c:out value="${answer.answer}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h2>Add your answer:</h2>
    <form:form action="/questions/${question.id}" method="post" modelAttribute="answers">
        <p>
            <form:label path="answer">Answer:</form:label>
            <form:errors path="answer"/>
            <form:textarea path="answer"/>
        </p>
        <input type="submit" value="Answer it!">
    </form:form>
</body>
</html>
