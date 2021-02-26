<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Computers</title>
	<style>
			table, tr, td{
				 border: 1px solid black			
			}
	</style>
</head>
<body>
	
<form method = "post" action = "navServlet">
	<table>
		<c:forEach items="${requestScope.allComputers}" var="currentComputer">
			<tr>
	 			<td><input type="radio" name="id" value="${currentComputer.id}"></td>
	 			<td>${currentComputer.cpu}</td>
	 			<td>${currentComputer.gpu}</td>
	 			<td>${currentComputer.operatingSystem}</td>
	 		</tr>
		</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThis">
	<input type = "submit" value = "delete" name="doThis">
	<input type="submit" value = "add" name="doThis">
	<a href = "index.html">Home</a>
</form>	
</body>
</html>