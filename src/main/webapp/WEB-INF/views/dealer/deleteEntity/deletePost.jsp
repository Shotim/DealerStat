<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete post</title>
</head>
<body>
<h1>
    <form name="submittion" action="/my${dealerId}/deletePost/${postId}" method="post">
        Post was successfully removed!
        <br>
        <input type="submit" value="Ok">
    </form>
</h1>
</body>
</html>