<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/12/2021
  Time: 1:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Questions Dashboard</title>
</head>
<body>
    <h1>Questions Dashboard</h1>
    <table>
        <thead>
        <tr>
            <th>Questions</th>
            <th>Tags</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
                <td>
                <c:forEach items="${question.tags}" var="tag">
                <c:out value="${tag.subject}"/>
                </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/questions/new">New Question</a>
</body>
</html>
