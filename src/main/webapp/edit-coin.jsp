<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Coin - Coin Collection Manager</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Edit Coin</h1>
<form action = "editCoinServlet" method="post">
Country: <select name="country">
		<c:forEach items="${allCountries}" var="country">
			<option value="${country.id}">${country.name}</option>
		</c:forEach>
	</select><br />
Year: <input type = "text" name = "year" value= "${coinToEdit.year}"><br />
Denomination: <input type = "text" name = "denomination" value= "${coinToEdit.denomination}"><br />
<input type = "hidden" name = "id" value="${coinToEdit.id}">
<input type = "submit" value="Save Coin">
</form>
</body>
</html>