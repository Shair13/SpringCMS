<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szer13
  Date: 12.09.2023
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Description</td>
        <td>Delete action</td>
        <td>Update action</td>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="/category/confirmDelete?id=${category.id}">
                <button>Delete</button>
            </a></td>
            <td><a href="/category/update?id=${category.id}">
                <button>Update</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/category/add">
    <button>Add new category</button>
</a>
</body>
</html>
