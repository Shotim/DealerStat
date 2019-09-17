<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit user</title>
</head>
<body>
<h1>Edit user</h1>
<h2>
    <form name="dealer" action="/dealer/${dealerId}/edit" method="post">
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" id="firstName">
        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" id="lastName">
        <label for="password">Password</label>
        <input id="password" type="password" name="password">
        <label for="email">Email</label>
        <input id="email" type="text" name="email">
        <br>
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>