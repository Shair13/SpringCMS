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
<h1>Update category id: ${category.id}: </h1><br>
<br>
<form:form method="post" modelAttribute="category">
    Name: <form:input path="name" value="${category.name}"/><form:errors path="name" cssClass="error" element="div"/>
    <br>
    Description: <form:input path="description" value="${category.description}"/> <br>
    <input type="submit" value="update category">
</form:form>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>
