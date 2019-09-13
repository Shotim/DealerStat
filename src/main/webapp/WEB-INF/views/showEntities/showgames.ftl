<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Games list</title>
</head>
<body>
<h1>Games list</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
        </tr>
        <#list games as game>
            <tr>
                <td>
                    <a href="/game/${game.id}">${game.id}</a>
                </td>
                <td>${game.name}</td>
                <#--            <td><a href="/delete/${user.id}">Delete</a></td>-->
                <#--            <td><a href="/update/${user.id}">Update</a></td>-->
            </tr>
        </#list>
    </table>
    <br>
    <a href="/addGame">Add new game</a>
    <br>
    <a href="../.."><-BACK</a>
</h2>
</body>
</html>