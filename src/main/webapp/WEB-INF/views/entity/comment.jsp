<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Comment</title>
</head>
<body>
<h1>Comment</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <tr>
            <td>${comment.id}"</td>
            <td>${comment.authorId}</td>
            <td>${comment.message}</td>
            <td>${comment.postId}</td>
            <td>${comment.createdAt}</td>
            <td>${comment.approved}</td>
        </tr>
    </table>
    <br>
    <a href="../"><-BACK</a>
</h2>
</body>
</html>