<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All CPU's</title>
<style>
			table, tr, td{
				 border: 1px solid black			
			}
</style>
</head>
<body>
<form method = "post" action = "editCPUServlet">
	<table>
		<c:forEach items="${requestScope.allCPUs}" var="currCPU">
			<tr>
	 			<td><input type="radio" name="cpu_id" value="${currCPU.getId()}"></td>
	 			<td>Name:${currCPU.name}</td>
	 			<td>Pins:${currCPU.pins}</td>
	 			<td>Cores:${currCPU.cores}</td>
	 			<td>
	 				Computers:
	 				<ul>
	 				<c:forEach items="${currCPU.listOfComputers}" var="com">
	 					<li>GPU:"${com.gpu}", Operating System: "${com.operatingSystem}"</li>
	 				</c:forEach>
	 				</ul>
	 			</td>
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