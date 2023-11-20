<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<h5>Do you really want to delete article with ID <c:out value="${param.id}" />?</h5>
<button onClick="javascript:location.href='delete?id=<c:out value="${param.id}" />'">OK</button>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>