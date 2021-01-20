<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/10/2021
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Product Page</title>
</head>
<body>
    <h1><c:out value="${product.name}"/></h1>
    <form:form action="/productAddCategory" method="post" modelAttribute="productCategory">
        <p>
            <form:input path="id" value="${product.id}" type="hidden"/>
            <form:input path="name" value="${product.name}" type="hidden"/>
            <form:input path="description" value="${product.description}" type="hidden"/>
            <form:input path="price" value="${product.price}" type="hidden"/>
            <form:label path="categories">Add Category:</form:label>
            <form:errors path="categories"/>
            <form:select path="categories">
                <c:forEach items="${categoriesNoProducts}" var="category">
                    <form:option value="${category.id}" label= "${category.name}"/>
                </c:forEach>
            </form:select>
        </p>
        <input type="submit" value="Add">
    </form:form>
    <h2>Categories:</h2>
    <ul>
        <c:forEach items="${product.categories}" var="category">
        <li><c:out value="${category.name}"/></li>
        </c:forEach>
    </ul>

</body>
</html>
