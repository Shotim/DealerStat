<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete game object from post</title>
</head>
<body>
<h1>
    <form name="submittion" action="/post/${postId}/deleteGameObject/${gameObjectId}" method="post">
        Game object was successfully removed from post!
        <br>
        <input type="submit" value="Ok">
    </form>
</h1>
</body>
</html>