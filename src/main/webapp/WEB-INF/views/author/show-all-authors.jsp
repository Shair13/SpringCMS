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
    <td>First name</td>
    <td>Last name</td>
    <td>Delete action</td>
    <td>Update action</td>
</tr>
<c:forEach var="author" items="${authors}">
    <tr>
        <td>${author.id}</td>
        <td>${author.firstName}</td>
        <td>${author.lastName}</td>
        <td><a href="/author/confirmDelete?id=${author.id}">
            <button>Delete</button>
        </a></td>
        <td><a href="/author/update?id=${author.id}">
            <button>Update</button>
        </a></td>
    </tr>
</c:forEach>
</table>
<br>
<a href="/author/add">
    <button>Add new author</button>
</a>
<a href="/">
    <button>Back</button>
</a>
</body>
</html>
