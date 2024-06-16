<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Color Picker</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="js/colorScript.js"></script>
</head>
<body>
<form id="colorForm">
    <label for="colorInput">Enter color name:</label>
    <input type="text" id="colorInput" name="colorName">
    <button type="submit">Submit</button>
</form>
<div id="hiddenDiv" style="display:none;">
    <p>Color Name: <span id="colorDisplay"></span></p>
</div>
</body>
</html>
