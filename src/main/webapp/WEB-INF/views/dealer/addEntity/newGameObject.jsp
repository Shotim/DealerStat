<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add game object</title>
</head>
<body>
<h1>Add game object</h1>
<h2>
    <form name="gameobject" action="/my/profile/post/${postId}/newGameObjects/game/${gameId}/newGameObject" method="post">
        <label for="title">Title</label>
        <input id="title" type="text" name="title">
        <label for="text">Text</label>
        <input id="text" type="text" name="text">
        <br>
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>