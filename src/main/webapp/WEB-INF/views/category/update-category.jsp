<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update category id: ${category.id}: </h1><br>
<br>
<form:form method="post" modelAttribute="category">
    Name: <form:input path="name" value="${category.name}"/>
    Description: <form:input path="description" value="${category.description}"/>
    <input type="submit" value="update category">
</form:form>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>
