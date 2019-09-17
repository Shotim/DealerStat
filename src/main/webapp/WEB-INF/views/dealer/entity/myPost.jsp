<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Post</title>
</head>
<body>
<h1>Post</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Dealer id</th>
        </tr>
        <tr>
            <td>${post.id}</td>
            <td>${post.dealerId}</td>
        </tr>
    </table>
    <br>
    Game objects list
    <table>
        <tr>
            <th>ID</th>
            <th>Game id</th>
            <th>Title</th>
            <th>Text</th>
            <th>Status</th>
            <th>Created at</th>
            <th>Updated at</th>
        </tr>
        <c:forEach var="object" items="${gameobjects}">
            <tr>
                <td>
                    <a href="/my${dealerId}/gameObject/${object.id}">${object.id}</a>
                </td>
                <td>${object.gameId}</td>
                <td>${object.title}</td>
                <td>${object.text}</td>
                <td>${object.status}</td>
                <td>${object.createdAt}</td>
                <td>${object.updatedAt}</td>
                <td>
                    <a href="/my${dealerId}/profile/post/${post.id}/deleteGameObject/${object.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/my${dealerId}/profile/post/${post.id}/newGameObjects">Add game object</a>
    <br>
    Comments
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
                <td>${comment.createdAt}</td>
                <td>${comment.approved}</td>
                <td>
                    <a href="/my${dealerId}/post/${post.id}/deleteComment/${comment.id}">Delete</a>
                </td>
                <td>
                    <a href="/my${dealerId}/post/${post.id}/editComment/${comment.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="../"><-BACK</a>
</h2>
</body>
</html>