<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Comment</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
        <tr>
            <td>${comment[0].id}"</td>
            <td>${comment[0].authorId}</td>
            <td>${comment[0].message}</td>
            <td>${comment[0].postId}</td>
            <td>${comment[0].createdAt}</td>
            <td>${comment[0].approved}</td>
        </tr>
</table>
<br>
<a href="../"><-BACK</a>
</body>
</html>