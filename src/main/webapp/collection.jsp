<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Coin Collection - Coin Collection Manager</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Your Coin Collection</h1>
<form method = "post" action = "selectionServlet">
<table>
<tr>
<th>Select</th>
<th>Country</th>
<th>Year</th>
<th>Denomination</th>
</tr>
<c:forEach items="${requestScope.allCoins}" var="currentcoin">
<tr>
 <td><input type="radio" name="id" value="${currentcoin.id}"></td>
 <td>${currentcoin.country.name}</td>
 <td>${currentcoin.year}</td>
 <td>${currentcoin.denomination}</td>
 </tr>
</c:forEach>
</table>
<input type = "submit" value = "Add" name = "userSelection">
<input type = "submit" value = "Edit" name = "userSelection">
<input type = "submit" value = "Delete" name = "userSelection">
</form>
</body>
</html>