<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Post</title>
</head>
<body>
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
            <a href="/gameobject/#{object.id}">#{object.id}</a>
        </tr>
        <tr>#{object.gameId}</tr>
        <tr>#{object.title}</tr>
        <tr>#{object.text}</tr>
        <tr>#{object.status}</tr>
        <tr>#{object.createdAt}</tr>
        <tr>#{object.updatedAt}</tr>
    </#list>
</table>
<a href="../"><-BACK</a>
</body>
</html>