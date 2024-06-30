<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Color Picker</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="<spring:url value='/styles.css' />">
    <script src="<spring:url value='/js/colorScript.js' />"></script>
    <script src="<spring:url value='/js/colorPrice.js' />"></script>
    <script src="<spring:url value='/js/saveScript.js' />"></script>
    <script src="<spring:url value='/js/comment.js' />"></script>
</head>
<body>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/home">Wyszukaj kolor</a></li>
        <li><a href="${pageContext.request.contextPath}/history">Historia</a></li>
        <li><a href="${pageContext.request.contextPath}/comments">Komentarze</a></li>
        <li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
        <c:if test="${sessionScope.loggedInUser != null}">

            <p class="user" style="display: none">${loggedInUser.id}</p>
                <p class="user1"> Zalogowany użytkownik: ${loggedInUser.firstName} ${loggedInUser.lastName}</p>
        </c:if>
    </ul>

</nav>

<form action="<spring:url value='/searchColor' />" id="colorForm" method="post">
    <label for="colorInput">Wpisz nazwę koloru:</label>
    <input type="text" id="colorInput" name="colorName">
    <button type="submit">Wyszukaj</button>
</form>
<c:if test="${not empty error}">
    <div style="color: red;">${error}</div>
</c:if>
<div id="hiddenDiv" style="display:none;">
    <ul id="colorDisplay"></ul>
</div>

<div id="result">

    <h2 class="info">Wyniki wyszukawania dla koloru: <p class="color">${name}</p> <span class="ilos">1 </span>kg:</h2>

    <table border="1">
        <thead>
        <tr>
            <th>Komponent koloru</th>
            <th>Ilość komponentu(gram)</th>

        </tr>
        </thead>

        <tbody>
        <c:forEach items="${componentQuantities}" varStatus="loop">
            <tr>
                <td class="component">${componentColors[loop.index]}</td>
                <td class="quantity">${componentQuantities[loop.index]}</td>
                </c:forEach>
        </tbody>
    </table>

    <table>
        <c:forEach items="${prices}" var="price">
            <tr>
                <td>
                    Cena netto produkcji koloru <span class="ilos">1 </span> kg bez opakowania(PLN):
                </td>
                <td class="price">
                        ${price.price}
                </td>
                <c:if test="${ error}">
                    <div style="color: red;">${error}</div>
                </c:if>
            </tr>
        </c:forEach>
    </table>

    <label for="value">Wpisz ilość koloru:</label>
    <input type="number" id="value" placeholder="Wpisz wymaganą ilość koloru"><br>

    <button type="button" id="calculate">Oblicz</button>
    <button type="button" class="save">Zapisz</button>
<h4 class="info2" style="color:red"></h4>
</div>
<div class="comments">
    <label for="comments">Komentarze:</label><br>
    <textarea id="comments" name="comments" rows="4" cols="50"></textarea>
    <button type="button" id="comment">Dodaj komentarz</button>
</div>

<h4 class="info3" style="color:red"></h4>
</body>
</html>
