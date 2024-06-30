<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<spring:url value='/styles.css' />">
    <title>Komentarze</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/home">Wyszukaj kolor</a></li>
        <li><a href="${pageContext.request.contextPath}/history">Historia</a></li>
        <li><a href="${pageContext.request.contextPath}/comments">Komentarze</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
        <c:if test="${sessionScope.loggedInUser != null}">
            <p class="user1">Zalogowany użytkownik: ${sessionScope.loggedInUser.firstName} ${sessionScope.loggedInUser.lastName}</p>
        </c:if>
    </ul>
</nav>
<br/>
<br/>
<h2>Wszystkie komentarze</h2>
<table>
    <tr>
        <th>Nazwa Koloru</th>
        <th>Nazwa użytkownika</th>
        <th>Data</th>
        <th>Treść komentarza</th>
    </tr>
    <c:forEach var="comment" items="${comments}">
        <tr>
            <td>${comment.colorName}</td>
            <td>${comment.customer.firstName}</td>
            <td>${comment.date}</td>
            <td>${comment.commentText}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
