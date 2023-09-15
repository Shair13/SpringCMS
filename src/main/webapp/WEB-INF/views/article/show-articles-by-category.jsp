<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Articles by category:</h1>
<table>
    <tr>
        <td>Id</td>
        <td>Title</td>
        <td>Author</td>
        <td>Category</td>
        <td>Content</td>
        <td>Created</td>
        <td>Updated</td>
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
        </tr>
    </c:forEach>
</table>
<a href="/">
    <button>Back</button>
</a>
</body>
</html>
