<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit user</title>
</head>
<body>
<h1>Edit user</h1>
<h2>
    <form name="dealer" action="/dealer/${dealerId}/edit" method="post">
        First name
        <input title="First name" type="text" name="firstName">
        <br>
        Last name
        <input title="Last name" type="text" name="lastName">
        <br>
        Password
        <input title="Password" type="password" name="password">
        <br>
        Email
        <input title="Email" type="text" name="email">
        <br>
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>