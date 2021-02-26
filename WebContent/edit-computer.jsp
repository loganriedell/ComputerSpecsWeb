<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit A Computer</title>
</head>
<body>
	<form action = "editComputerServlet" method="post">
		CPU: <input type ="text" name = "cpu" value="${comToEdit.cpu}">
		GPU: <input type = "text" name = "gpu" value= "${comToEdit.gpu}">
		OS: <input type = "text" name = "os" value = "${comToEdit.operatingSystem}">
		<input type = "hidden" name = "id" value="${comToEdit.id}">
		<input type = "submit" value="Save Edited Computer">
	</form>

</body>
</html>