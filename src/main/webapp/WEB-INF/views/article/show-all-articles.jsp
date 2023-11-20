<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Author</td>
        <td>Categories</td>
        <td>Content</td>
        <td>Created</td>
        <td>Updated</td>
        <td>Delete action</td>
        <td>Update action</td>
    </tr>
    <c:forEach var="article" items="${articles}">
        <tr>
            <td><c:out value="${article.id}"/></td>
            <td><c:out value="${article.title}"/></td>
            <td><c:out value="${article.author.firstName} ${article.author.lastName}"/></td>
            <td><c:forEach items="${article.categories}" var="category">
                ${category.name},
            </c:forEach></td>
            <td><c:out value="${article.content}"/></td>
            <td><c:out value="${article.created}"/></td>
            <td><c:out value="${article.updated}"/></td>
            <td><a href="/article/confirmDelete?id=${article.id}">
                <button>Delete</button>
            </a></td>
            <td><a href="/article/update?id=${article.id}">
                <button>Update</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/article/add">
    <button>Add new article</button>
</a>
<a href="/">
    <button>Back</button>
</a>
</body>
</html>
