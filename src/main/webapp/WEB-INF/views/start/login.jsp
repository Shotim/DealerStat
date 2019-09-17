<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17.09.2019
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login Form</h1>

<c:if test="${not empty errorMessage}">
    ${errorMessage}
</c:if>

<form name='login' action="/login" method='post'>
    <table>
        <tr>
            <td><input type='text' name='username' placeholder="Email"></td>
        </tr>
        <tr>
            <td><input type='password' name='password' placeholder="Password"/></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Login"/></td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<form action="/login" method="post">
    <input type="text" name="username" value="guest" hidden>
    <input type="text" name="password" value="guest" hidden>
    <input type="submit" value="Enter as a guest">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<h4>
    <a href="/signUp">Sign Up</a>
</h4>
</body>
</html>
