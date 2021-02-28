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
    <title>Category Page</title>
</head>
<body>
    <h1><c:out value="${category.name}"/></h1>
    <form:form action="/categoryAddProduct" method="post" modelAttribute="categoryProduct">
        <p>
            <form:input path="id" value="${category.id}" type="hidden"/>
            <form:input path="name" value="${category.name}" type="hidden"/>
            <form:label path="products">Add Product:</form:label>
            <form:errors path="products"/>
            <form:select path="products">
                <c:forEach items="${productsNoCategories}" var="product">
                    <form:option value="${product.id}" label= "${product.name}"/>
                </c:forEach>
            </form:select>
        </p>
        <input type="submit" value="Add">
    </form:form>
    <h2>Categories:</h2>
    <ul>
        <c:forEach items="${category.products}" var="product">
        <li><c:out value="${product.name}"/></li>
        </c:forEach>
    </ul>

</body>
</html>
