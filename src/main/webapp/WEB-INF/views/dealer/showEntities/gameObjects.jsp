<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Game objects list</title>
</head>
<body>
<h1>Game objects list</h1>
<br>
<h2>
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
                <td>
                    <a href="/my${dealerId}/game/${object.gameId}">${object.gameId}</a>
                </td>
                <td>${object.title}</td>
                <td>${object.text}</td>
                <td>${object.status}</td>
                <td>${object.createdAt}</td>
                <td>${object.updatedAt}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/my${dealerId}/"><-BACK</a>
</h2>
</body>
</html>