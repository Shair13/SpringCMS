<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szer13
  Date: 12.09.2023
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .separatorLine{
            color: orangered;
            font-weight: bold;
        }
    </style>
</head>
<body>
<button onClick="javascript:location.href='category/showAll'">Categories</button>
<button onClick="javascript:location.href='author/showAll'">Authors</button>
<button onClick="javascript:location.href='article/showAll'">Article</button>
<h2>Select article by category:</h2>
<c:forEach items="${categories}" var="category">
    <a href="/articleByCategory?id=${category.id}">${category.name}</a>,
</c:forEach> <br>

<h1>Last 5 articles:</h1>
<c:forEach items="${lastFiveArticles}" var="article" varStatus="i">
    <p>
        <h3>Article ${i.count}:</h3>
        <b>Tytuł:</b> <c:out value="${article.title}"/> <br>
        <b>Data dodania:</b> <c:out value="${article.created}"/> <br><br>
        <b>Content:</b> <c:out value="${article.content}"/>
        <p class="separatorLine">______________________________________________________________________________</p>
    </p>
</c:forEach>
</body>
</html>
