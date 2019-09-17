<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Games list</title>
</head>
<body>
<h1>Games list</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <c:forEach var="game" items="${games}">
            <tr>
                <td>
                    <a href="/anonym/game/${game.id}">${game.id}</a>
                </td>
                <td>${game.name}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/anonym/"><-BACK</a>
</h2>
</body>
</html>