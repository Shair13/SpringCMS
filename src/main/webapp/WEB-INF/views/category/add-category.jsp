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
<form:form method="post" modelAttribute="category">
    Name:           <form:input path="name"/><form:errors path="name" cssClass="error" element="div"/> <br>
    Description:    <form:input path="description"/> <br>
    <input type="submit" value="add category">
</form:form>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>
