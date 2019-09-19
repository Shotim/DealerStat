<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Game</title>
</head>
<body>
<h1>Game</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <tr>
            <td>${game.id}</td>
            <td>${game.name}</td>
        </tr>
    </table>
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Text</th>
            <th>Status</th>
            <th>Created at</th>
            <th>Updated at</th>
        </tr>
        <c:forEach var="object" items="${gameobjects}">
            <tr>
                <td>${object.id}</td>
                <td>${object.title}</td>
                <td>${object.text}</td>
                <td>${object.status}</td>
                <td>${object.createdAt}</td>
                <td>${object.updatedAt}</td>
                <td>
                    <a href="/my/profile/post/${postId}/newGameObjects/game/${gameId}/newGameObject/${object.id}">Add this</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/my/profile/post/${postId}/newGameObjects/game/${gameId}/newGameObject">If you can't find object add new</a>
    <br>
    <a href="../"><-BACK</a>
</h2>
</body>
</html>