<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/8/2021
  Time: 1:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <style>
        .delete button{
            background: none!important;
            border: none;
            padding: 0!important;
            /*optional*/
            font-family: arial, sans-serif;
            /*input has OS specific font-family*/
            color: blue;
            text-decoration: underline;
            cursor: pointer;
        }
    </style>
    <title>Display All Languages</title>
</head>
<body>
    <h1>All Languages</h1>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${languages}" var="language">
            <tr>
                <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
                <td><c:out value="${language.creator}"/></td>
                <td><c:out value="${language.version}"/></td>
                <td>
                    <span class="delete">
                        <form action="/languages/${language.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <button type="submit" value="delete">delete</button>
                        </form>
                    </span>
                    <a href="/languages/${language.id}/edit">edit </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <main>
        <form:form action="/languages" method="post" modelAttribute="language">
            <p>
                <form:label path="name">Name</form:label>
                <form:errors path="name"/>
                <form:input path="name"/>
            </p>
            <p>
                <form:label path="creator">Creator</form:label>
                <form:errors path="creator"/>
                <form:input path="creator"/>
            </p>
            <p>
                <form:label path="version">Version</form:label>
                <form:errors path="version"/>
                <form:input path="version"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </main>
</body>
</html>
