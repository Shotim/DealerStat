<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.09.2019
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>
    <form name="dealer" action="/newDealer" method="post">
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
