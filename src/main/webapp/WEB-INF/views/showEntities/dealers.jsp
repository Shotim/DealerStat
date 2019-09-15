<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users list</title>
</head>
<body>
<h1>Users list</h1>
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
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    <a href="/dealer/${user.id}">${user.id}</a>
                </td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.createdAt}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <a href="/newDealer">Add new user</a>
    <br>
    <a href="../.."><-BACK</a>
</h2>
</body>
</body>
</html>