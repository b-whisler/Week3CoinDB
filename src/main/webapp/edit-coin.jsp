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
<form action = "editCoinServlet" method="post">
Country: <input type ="text" name = "country" value= "${coinToEdit.country}"><br />
Year: <input type = "text" name = "year" value= "${coinToEdit.year}"><br />
Denomination: <input type = "text" name = "denomination" value= "${coinToEdit.denomination}"><br />
<input type = "hidden" name = "id" value="${coinToEdit.id}">
<input type = "submit" value="Save Coin">
</form>
</body>
</html>