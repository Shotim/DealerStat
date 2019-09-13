<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Posts list</title>
</head>
<body>
<h1>Posts list</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Dealer id</th>
        </tr>
        <#list posts as post>
            <tr>
                <td>
                    <a href="/post/${post.id}">${post.id}</a>
                </td>
                <td>${post.dealerId}</td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="../.."><-BACK</a>
</h2>
</body>
</html>