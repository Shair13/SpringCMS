<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add article</h1>
<form:form modelAttribute="article" method="post">
    Title: <form:input path="title" type="text"/> <br>
    Author:
    <form:select path="author">
        <form:option value="none" label="--Select author--"/>
        <form:options itemLabel="fullName" itemValue="id" items="${authors}"/>
    </form:select> <br>
    Categories:
    <form:select path="categories" itemLabel="name" itemValue="id" items="${categories}" multiple="true"/> <br>
    Content:
    <form:textarea path="content"/> <br> <br>
    <input type="submit" value="Add">
</form:form>
</body>
</html>
