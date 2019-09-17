<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
<h1>Dealer</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Created at</th>
            <th>Role</th>
        </tr>
        <tr>
            <td>${dealer.id}</td>
            <td>${dealer.firstName}</td>
            <td>${dealer.lastName}</td>
            <td>${dealer.email}</td>
            <td>${dealer.createdAt}</td>
            <td>${dealer.role}</td>
        </tr>
    </table>
    <br>
    <br>
    Users posts id's
    <table>
        <c:forEach var="post" items="${posts}">
            <tr>
                <td>
                    <a href="/anonym/post/${post.id}">${post.id}</a>
                </td>
            </tr>
            </c:forEach>
    </table>
    <br>
    <a href="/anonym/dealers"><-BACK</a>
</h2>
</body>
</html>