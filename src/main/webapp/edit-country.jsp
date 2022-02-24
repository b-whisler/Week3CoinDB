<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Country - Coin Collection Manager</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1>Edit Country</h1>
<form action = "editCountryServlet" method="post">
Country name: <input type = "text" name = "country" value= "${countryToEdit.name}"><br />
Currency: <input type = "text" name = "currency" value= "${countryToEdit.currency}"><br />
<input type = "hidden" name = "id" value="${countryToEdit.id}">
<input type = "submit" value="Save Country">
</form>
</body>
</html>