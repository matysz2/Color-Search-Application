<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Color Picker</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="<spring:url value='/styles.css' />">
    <script src="<spring:url value='/js/colorScript.js' />"></script>
</head>
<body>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/searchColor">Wyszukaj kolor</a></li>
        <li><a href="${pageContext.request.contextPath}/history">Historia</a></li>
        <li><a href="${pageContext.request.contextPath}/comments">Komentarze</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
    </ul>
</nav>
<form id="colorForm">
    <label for="colorInput">Enter color name:</label>
    <input type="text" id="colorInput" name="colorName">
    <button type="submit">Submit</button>
</form>
<div id="hiddenDiv" style="display:none;">
    <ul id="colorDisplay"></ul>
</div>

</body>
</html>
