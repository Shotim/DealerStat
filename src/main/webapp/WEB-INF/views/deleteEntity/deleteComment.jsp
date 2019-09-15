<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete comment</title>
</head>
<body>
<h1>
    <form name="submittion" action="/post/${postId}/deleteComment/${commentId}" method="post">
        Comment was successfully removed from post!
        <br>
        <input type="submit" value="Ok">
    </form>
</h1>
</body>
</html>