<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Colors Application</title>
    <link rel="stylesheet" href="<spring:url value='/styles.css' />">
</head>
<body>

<h2>Colors Application</h2>

<form  method="post">
    <div>
        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" required><br>
    </div>

    <div>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password" required><br>
    </div>

    <button type="submit">Login</button>
</form>

</body>
</html>