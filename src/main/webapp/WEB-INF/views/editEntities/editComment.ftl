<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit comment</title>
</head>
<body>
<h1>Edit comment</h1>
<h2>
    <form name="comment" action="/post/${postId}/editComment/${commentId}" method="post">
        Message
        <input title="Message" type="text" name="message">
        <br>
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>