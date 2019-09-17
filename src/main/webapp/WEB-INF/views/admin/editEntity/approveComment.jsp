<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.09.2019
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Approve comment</title>
</head>
<body>
<br>
<h1>Comment was successfully approved!!!</h1>
<form name="submittion" action="/admin/unapprovedComments/approve${id}" method="post">
    <input type="submit" value="OK">
</form>
</body>
</html>
