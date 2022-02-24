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
Add a coin:
<form action = "addCoinServlet" method="post">
Country: <select name="country">
		<c:forEach items="${allCountries}" var="country">
			<option value="${country.id}">${country.name}</option>
		</c:forEach>
	</select><br />
Year: <input type = "text" name = "year"><br />
Denomination: <input type = "text" name = "denomination"><br />
<input type = "submit" value="Add Coin">
</form> <br />
<a href="index.html">Back to home</a>
</body>
</html>