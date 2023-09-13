<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update author id: ${article.id}: </h1><br>
<form:form modelAttribute="article" method="post">
    Title: <form:input path="title" type="text"/> <br>
    Author:
    <form:select path="author.id" itemLabel="fullName" itemValue="id" items="${authors}"/><br>
    Categories:
    <form:select path="categories" itemLabel="name" itemValue="id" items="${categories}" multiple="true"/> <br>
    Content:
    <form:textarea path="content"/> <br>
    <form:hidden path="created"/>
    <br> <br>
    <input type="submit" value="update article">
</form:form>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>
