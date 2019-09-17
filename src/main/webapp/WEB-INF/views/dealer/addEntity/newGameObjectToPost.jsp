<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add game object to post</title>
</head>
<body>
<h1>Game object was added!</h1>
<h2>
    <form name="submittion" action="/my${dealerId}/profile/post/${postId}/newGameObjects/game/${gameId}/newGameObject/${objectId}" method="post">
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>