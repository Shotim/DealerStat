<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add game objects</title>
</head>
<body>
<h1>Add game object</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Game id</th>
        </tr>
        <#list games as game>
            <tr>
                <td>
                    <a href="/post/${id}/addgameobjects/showgame/${game.id}">${game.id}</a>
                </td>
                <td>${game.name}</td>
            </tr>
        </#list>
    </table>
    <br>

    <a href="/post/${id}/addgameobjects/addnewgame">
        If you can't find required game add new
    </a>
    <br>
    <a href="../"><-BACK</a>
</h2>
</body>
</html>