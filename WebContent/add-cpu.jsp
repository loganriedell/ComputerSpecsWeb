<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A CPU</title>
</head>
<body>
	<form action=navigationServlet method="post">
		<p>
			GPU: <input type = "text" name = "gpu" value = ${gpu}>
			OS: <input type = "text" name = "os" value = ${os}>
		</p>
		<p>
			Name: <input type = "text" name= "cpuName">
			Pins: <input type = "text" name= "pins">
			Cores: <input type = "text" name = "cores">
			<input type="submit" value="Add CPU" name="action">
		</p>
	</form>
</body>
</html>