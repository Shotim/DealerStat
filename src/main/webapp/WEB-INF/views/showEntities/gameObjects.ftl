<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Game objects list</title>
</head>
<body>
<h1>Game objects list</h1>
<br>
<h2>
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
                    <a href="/gameObject/${object.id}">${object.id}</a>
                </td>
                <td>
                    <a href="/game/${object.gameId}">${object.gameId}</a>
                </td>
                <td>${object.title}</td>
                <td>${object.text}</td>
                <td>${object.status}</td>
                <td>${object.createdAt}</td>
                <td>${object.updatedAt}</td>
                <#--            <td><a href="/delete/${user.id}">Delete</a></td>-->
                <#--            <td><a href="/update/${user.id}">Update</a></td>-->
            </tr>
        </#list>
    </table>
    <br>
    <a href="../.."><-BACK</a>
</h2>
</body>
</html>