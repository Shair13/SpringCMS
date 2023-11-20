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
<h1>Update author id: ${author.id}: </h1><br>
<br>
<form:form method="post" modelAttribute="author">
    First name: <form:input path="firstName"/><form:errors path="firstName" cssClass="error" element="div"/> <br>
    Last name:  <form:input path="lastName"/><form:errors path="lastName" cssClass="error" element="div"/> <br>
    <input type="submit" value="update author">
</form:form>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>
