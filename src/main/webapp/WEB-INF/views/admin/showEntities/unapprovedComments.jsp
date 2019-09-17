<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.09.2019
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Unapproved comments</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Author id</th>
        <th>Message</th>
        <th>Created at</th>
        <th>approved</th>
    </tr>
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.id}</td>
            <td>${comment.authorId}</td>
            <td>${comment.message}</td>
            <td>
                <a href="/admin/post/${comment.postId}">${comment.postId}</a>
            </td>
            <td>${comment.createdAt}</td>
            <td>${comment.approved}</td>
            <td>
                <a href="/admin/unapprovedComments/approve${comment.id}">Approve</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/admin/"><-BACK</a>
</body>
</html>
