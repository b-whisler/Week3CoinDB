<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country Management - Coin Collection Manager</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Country Management</h1>
<form method = "post" action = "countrySelectionServlet">
<table>
<tr>
<th>Select</th>
<th>Country</th>
<th>Currency</th>
<th>No. Of Coins</th>
</tr>
<c:forEach items="${requestScope.allCountries}" var="country">
<tr>
 <td><input type="radio" name="id" value="${country.id}"></td>
 <td>${country.name}</td>
 <td>${country.currency}</td>
 <td>${fn:length(country.countryCoins)}</td>
 </tr>
</c:forEach>
</table>
<input type = "submit" value = "Add" name = "userSelection">
<input type = "submit" value = "Edit" name = "userSelection">
<input type = "submit" value = "Delete" name = "userSelection">
</form>
<a href="index.html">Back to home</a>
</body>
</html>