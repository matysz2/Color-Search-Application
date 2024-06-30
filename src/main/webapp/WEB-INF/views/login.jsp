<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

<form:form action="login" method="post" modelAttribute="loginForm">
    <div>
        <label for="email">Email:</label><br>
        <form:input path="email" type="email" id="email" required="required"/><br>
        <form:errors path="email" cssClass="error"/>
    </div>

    <div>
        <label for="password">Password:</label><br>
        <form:input path="password" type="password" id="password" required="required"/><br>
        <form:errors path="password" cssClass="error"/>
    </div>

    <button type="submit">Login</button>
</form:form>

<c:if test="${not empty error}">
    <div style="color: red; margin-left: 45%;">${error}</div>
</c:if>

</body>
</html>
