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
</head>
<body>
<c:forEach items="${lastFiveArticles}" var="article">
    <p>Tytuł: ${article.title}, Data dodania: ${article.created}, Content: ${article.content}</p>
</c:forEach>
<button onClick="javascript:location.href='category/showAll'">Categories</button>
<button onClick="javascript:location.href='author/showAll'">Authors</button>
<button onClick="javascript:location.href='article/showAll'">Article</button>
</body>
</html>
