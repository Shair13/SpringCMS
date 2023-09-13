<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update author id: ${author.id}: </h1><br>
<br>
<form:form method="post" modelAttribute="author">
    First name: <form:input path="firstName"/>
    Last name:  <form:input path="lastName"/>
    <input type="submit" value="update author">
</form:form>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>
