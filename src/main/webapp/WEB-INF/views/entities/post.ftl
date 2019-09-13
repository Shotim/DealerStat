<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Post</title>
</head>
<body>
<h1>Post</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Dealer id</th>
        </tr>
        <tr>
            <td>${post[0].id}</td>
            <td>${post[0].dealerId}</td>
        </tr>
    </table>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>Game id</th>
            <th>Title</th>
            <th>Text</th>
            <th>Status</th>
            <th>Created at</th>
            <th>Updated at</th>
        </tr>
        <#list gameobjects as object>
            <tr>
                <td>
                    <a href="/gameObject/#{object.id}">#{object.id}</a>
                </td>
                <td>${object.gameId}</td>
                <td>${object.title}</td>
                <td>${object.text}</td>
                <td>${object.status}</td>
                <td>${object.createdAt}</td>
                <td>${object.updatedAt}</td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="/post/${post[0].id}/newGameObjects">Add game object</a>
    <br>
    <a href="../../"><-BACK</a>
</h2>
</body>
</html>