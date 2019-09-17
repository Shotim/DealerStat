<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add game objects</title>
</head>
<body>
<h1>Add game object</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Game id</th>
        </tr>
        <c:forEach var="game" items="${games}">
            <tr>
                <td>
                    <a href="/my/post/${id}/newGameObjects/game/${game.id}">${game.id}</a>
                </td>
                <td>${game.name}</td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <a href="/my/post/${id}/newGameObjects/newGame">
        If you can't find required game add new
    </a>
    <br>
    <a href="../"><-BACK</a>
</h2>
</body>
</html>