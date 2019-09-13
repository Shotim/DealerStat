<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Game</title>
</head>
<body>
<h1>Game</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <tr>
            <td>${game[0].id}</td>
            <td>${game[0].name}</td>
        </tr>
    </table>
    <table>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Text</th>
            <th>Status</th>
            <th>Created at</th>
            <th>Updated at</th>
        </tr>
        <#list gameobjects as object>
            <tr>
                <td>${object.id}</td>
                <td>${object.title}</td>
                <td>${object.text}</td>
                <td>${object.status}</td>
                <td>${object.createdAt}</td>
                <td>${object.updatedAt}</td>
                <td>
                    <a href="/post/${postId}/addgameobjects/showgame/${gameId}/addgameobject/${object.id}">Add this</a>
                </td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="/post/${postId}/addgameobjects/showgame/${gameId}/addnewgameobject">If you can't find object add new</a>
    <br>
    <a href="../"><-BACK</a>
</h2>
</body>
</html>