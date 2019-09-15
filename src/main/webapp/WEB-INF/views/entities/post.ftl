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
            <td>${post.id}</td>
            <td>${post.dealerId}</td>
        </tr>
    </table>
    <br>
    Game objects list
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
                <td>
                    <a href="/post/${post.id}/deleteGameObject/${object.id}">Delete</a>
                </td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="/post/${post.id}/newComment"> Add comment</a>
    <br>
    Comments
    <table>
        <tr>
            <th>ID</th>
            <th>Author id</th>
            <th>Message</th>
            <th>Created at</th>
            <th>approved</th>
        </tr>
        <#list comments as comment>
            <tr>
                <td>${comment.id}</td>
                <td>${comment.authorId}</td>
                <td>${comment.message}</td>
                <td>${comment.createdAt}</td>
                <td>${comment.approved?string('approved','not approved')}</td>
                <td>
                    <a href="/post/${post.id}/deleteComment/${comment.id}">Delete</a>
                </td>
                <td>
                    <a href="/post/${post.id}/editComment/${comment.id}">Edit</a>
                </td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="/post/${post.id}/newGameObjects">Add game object</a>
    <br>
    <a href="../../"><-BACK</a>
</h2>
</body>
</html>