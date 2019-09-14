<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New comment</title>
</head>
<body>
<h2>
    <form name="comment" action="/post/${id}/newComment" method="post">
        Your id
        <input title="Your id" type="number" name="authorId">
        <br>
        Message
        <input title="Meddage" type="text" name="message">
        <br>
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>