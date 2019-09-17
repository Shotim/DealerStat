<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New comment</title>
</head>
<body>
<h2>
    <form name="comment" action="/anonym/post/${id}/newComment" method="post">
        <label for="message">Message</label>
        <input id="message" type="text" name="message">
        <br>
        <input type="submit" value="Ok">
    </form>
</h2>
</body>
</html>