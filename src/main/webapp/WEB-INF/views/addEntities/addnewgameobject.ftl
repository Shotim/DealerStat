<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add game object</title>
</head>
<body>
<h1>Add game object</h1>
<h2>
    <form name="gameobject" action="/post/${postId}/addgameobjects/showgame/${gameId}/addnewgameobject" method="post">
        Title
        <input title="Title" type="text" name="title">
        Text
        <input title="Text" type="text" name="text">
        <br>
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>