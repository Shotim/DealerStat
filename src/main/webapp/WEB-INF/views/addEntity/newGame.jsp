<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New game object</title>
</head>
<body>
<h1>New game object</h1>
<h2>
    <form name="game" action="/post/${id}/newGameObjects/newGame" method="post">
        <label for="name">Name</label>
        <input id="name" type="text" name="name">
        <br>
        <input type="submit" value="Ok">
    </form>
    <br>
</h2>
</body>
</html>