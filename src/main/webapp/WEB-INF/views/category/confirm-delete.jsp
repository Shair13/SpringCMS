<%--
  Created by IntelliJ IDEA.
  User: szer13
  Date: 12.09.2023
  Time: 23:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Book delete</title>
</head>
<body>
<h5>Do you really want to delete category with ID ${param.id}?</h5>
<button onClick="javascript:location.href='delete?id=${param.id}'">OK</button>
<button onClick="javascript:location.href='showAll'">Cancel</button>
</body>
</html>