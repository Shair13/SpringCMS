<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    Name:           <form:input path="name"/>
    Description:    <form:input path="description"/>
    <input type="submit" value="add category">
    <button onClick="javascript:location.href='showAll'">Cancel</button>
</form:form>
</body>
</html>
