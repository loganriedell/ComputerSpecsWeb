<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Computer</title>
<style>
	<style>
			table, tr, td{
				 border: 1px solid black			
			}
	</style>
</style>
</head>
<body>
	<form action="navigationServlet" method="post">
		GPU: <input type="text" name="gpu">
		OS: <input type="text" name="os"}>
		<h1>Choose a CPU:</h1>
		<table>
			<c:forEach items="${requestScope.allCPUs}" var="currentCPU">
				<tr>
		 			<td><input type="radio" name="id" value="${currentCPU.id}"></td>
		 			<td>${currentCPU.name}</td>
		 			<td>${currentCPU.cores}</td>
		 			<td>${currentCPU.pins}</td>
		 		</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Add Computer" name="action">
		<input type="submit" value="Add New CPU" name="action">
	</form>

</body>
</html>