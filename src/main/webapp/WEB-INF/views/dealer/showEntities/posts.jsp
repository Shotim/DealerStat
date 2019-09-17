<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Posts list</title>
</head>
<body>
<h1>Posts list</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Dealer id</th>
        </tr>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>
                    <a href="/my${dealerId}/post/${post.id}">${post.id}</a>
                </td>
                <td>${post.dealerId}</td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/my${dealerId}/"><-BACK</a>
</h2>
</body>
</html>