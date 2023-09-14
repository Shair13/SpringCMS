<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            color: orangered;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Update author id: ${article.id}: </h1><br>
<form:form modelAttribute="article" method="post">
    Title: <form:input path="title" type="text"/> <form:errors path="title" cssClass="error" element="div"/><br>
    Author:
    <form:select path="author.id" itemLabel="fullName" itemValue="id" items="${authors}"/><br>
    Categories:
    <form:select path="categories" itemLabel="name" itemValue="id" items="${categories}" multiple="true"/><form:errors path="categories" cssClass="error" element="div"/><br>
    Content:
    <form:textarea path="content"/><form:errors path="content" cssClass="error" element="div"/> <br>
    <form:hidden path="created"/>
    <br> <br>
    <input type="submit" value="update article">
</form:form>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>
