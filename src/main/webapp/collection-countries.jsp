<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${allCountries}" var="country">
			<h1>${country.name}</h1>
			Currency: ${country.currency}<br />
			Your ${country.name} coins:
			<table>
			<tr>
			<th>Year</th>
			<th>Denomination</th>
			</tr>
			<c:forEach items="${country.countryCoins}" var="coin">
			<tr>
			<td>${coin.year}</td>
			<td>${coin.denomination}</td>
			</tr>
			</c:forEach>
			</table>
</c:forEach><br />
<a href="index.html">Back to home</a>
</body>
</html>