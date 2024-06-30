<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<spring:url value='/styles.css' />">
    <title>Historia koloru</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/home">Wyszukaj kolor</a></li>
        <li><a href="${pageContext.request.contextPath}/history">Historia</a></li>
        <li><a href="${pageContext.request.contextPath}/comments">Komentarze</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
        <c:if test="${sessionScope.loggedInUser != null}">

            <p class="user1"> Zalogowany użytkownik: ${loggedInUser.firstName} ${loggedInUser.lastName}</p>
        </c:if>
    </ul>

</nav>
<br>
<br>
<h1>Historia kolorów</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nazwa Koloru</th>
        <th>Data Wyszukiwania</th>
        <th>Cena</th>
        <th>Ilość</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="colorHistory" items="${colorHistoryList}">
        <tr>
            <td>${colorHistory.id}</td>
            <td>${colorHistory.colorName}</td>
            <td>${colorHistory.searchTimestamp}</td>
            <td>${colorHistory.price} PLN</td>
            <td>${colorHistory.quantity} kg</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
