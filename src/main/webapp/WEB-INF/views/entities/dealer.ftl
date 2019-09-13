<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
<h1>Dealer</h1>
<h2>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Created at</th>
            <th>Role</th>
        </tr>
        <tr>
            <td>${dealer[0].id}</td>
            <td>${dealer[0].firstName}</td>
            <td>${dealer[0].lastName}</td>
            <td>${dealer[0].email}</td>
            <td>${dealer[0].createdAt}</td>
            <td>${dealer[0].role}</td>
        </tr>
    </table>
    <br>
    <br>
    Users posts id's
    <table>
        <#list posts as post>
            <tr>
                <td>
                    <a href="/post/${post.id}">${post.id}</a>
                </td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="/adddealer${dealer[0].id}post/">Add post</a>
    <br>
    <br>
    <a href="../"><-BACK</a>
</h2>
</body>
</html>